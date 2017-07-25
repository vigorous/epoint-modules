package com.epoint.message.service.impl;

import com.alibaba.fastjson.JSON;
import com.epoint.member.dao.EPMemberStoreInfoMapper;
import com.epoint.member.entity.MemberStoreInfo;
import com.epoint.message.dao.EPSystemMessageMapper;
import com.epoint.message.entity.SystemMessage;
import com.epoint.message.enums.MessageConstant;
import com.epoint.message.exception.MessageException;
import com.epoint.message.service.IFlowMessageService;
import com.epoint.order.dao.EPOrderItemMapper;
import com.epoint.order.dao.EPOrderMapper;
import com.epoint.order.dto.OrderItemDTO;
import com.epoint.order.entity.Order;
import com.epoint.order.entity.OrderItem;
import com.epoint.order.enums.OrderConstant;
import com.epoint.order.enums.OrderItemConstant;
import com.epoint.order.exception.OrderException;
import com.epoint.staff.dao.EPStaffGroupMapper;
import com.epoint.staff.dao.EPStaffMapper;
import com.epoint.staff.entity.Staff;
import com.epoint.staff.entity.StaffGroup;
import com.rd.push.JPushBusinessManager;
import com.rd.push.enums.AppType;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * @author xishengchun on 2017-05-27.
 */
@Service
public class FlowMessageService implements IFlowMessageService {

    private Logger logger = LogManager.getLogger(FlowMessageService.class);

    @Autowired
    private EPSystemMessageMapper epSystemMessageMapper;

    @Autowired
    private EPMemberStoreInfoMapper epMemberStoreInfoMapper;

    @Autowired
    private EPStaffMapper epStaffMapper;

    @Autowired
    private EPOrderMapper epOrderMapper;

    @Autowired
    private EPOrderItemMapper epOrderItemMapper;

    @Autowired
    private EPStaffGroupMapper epStaffGroupMapper;

    @Override
    public void noticeCheckCar(SystemMessage systemMessage) {

        if (systemMessage == null) {
            throw new MessageException("消息无效");
        }

        if (!MessageConstant.MessageType.validMessageType(systemMessage.getType())) {
            throw new MessageException("消息的类型无效");
        }

        if (systemMessage.getStoreId() == null) {
            throw new MessageException("门店无效");
        }

        systemMessage.setTitle("您有新的验车任务,请尽快处理");
        doPush(systemMessage, MessageConstant.MessageType.CHECK_CAR);
        // 保存推送消息
        epSystemMessageMapper.insert(systemMessage);

    }

    @Override
    public void noticeCreateOrder(SystemMessage systemMessage) {
        if (systemMessage == null) {
            throw new MessageException("消息无效");
        }

        Short type = systemMessage.getType();
        if (!MessageConstant.MessageType.validMessageType(type)) {
            throw new MessageException("消息的类型无效");
        }

        if (systemMessage.getStoreId() == null) {
            throw new MessageException("门店无效");
        }

        systemMessage.setTitle("您有新的开单任务,请尽快处理");
        doPush(systemMessage, MessageConstant.MessageType.get(type));
        // 保存推送消息
        epSystemMessageMapper.insert(systemMessage);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void noticeDispatch(Long orderId) {
        //根据订单ID查询订单信息（erp_work_order）
        Order order = epOrderMapper.selectById(orderId);
        if (order == null) {
            throw new MessageException("订单不存在");
        }
        //门店ID
        Long storeId = order.getStoreId();
        String carNo = order.getCarNo();

        //根据订单ID查询订单明细表（erp_work_order_item）
        List<OrderItemDTO> orderItemForAutoWork = epOrderItemMapper.queryOrderItemForAutoWork(order.getId());
        List<OrderItemDTO> orderItemForGoods = epOrderItemMapper.queryOrderItemForGoods(order.getId());

        //所有的订单明细
        List<OrderItemDTO> orderItemDTOS = new ArrayList<>();

        if (!CollectionUtils.isEmpty(orderItemForGoods)) {
            orderItemDTOS.addAll(orderItemForGoods);
        }

        if (!CollectionUtils.isEmpty(orderItemForAutoWork)) {
            orderItemDTOS.addAll(orderItemForAutoWork);
        }

        //当前时间
        Date today = new Date();
        List<SystemMessage> messageList = new ArrayList<>();

        if (!CollectionUtils.isEmpty(orderItemDTOS)) {
            for (OrderItemDTO orderItemDTO : orderItemDTOS) {
                String workerIds = orderItemDTO.getWorkerIds();
                String workGroups = orderItemDTO.getWorkerGroupIds();
                if (StringUtils.isNotEmpty(workGroups)) {
                    String[] gWorkers = workGroups.split(",");
                    for (int i = 0; i < gWorkers.length; i++) {
                        StaffGroup staffGroup = epStaffGroupMapper.queryOneStaffGroup(Long.valueOf(gWorkers[i]));
                        if (staffGroup != null) {
                            if ("".equals(workerIds)) {
                                workerIds = staffGroup.getStaffIds();
                            } else {
                                workerIds = workerIds + "," + staffGroup.getStaffIds();
                            }

                        }
                    }

                    if (StringUtils.isNotBlank(workerIds)) {
                        String[] staffIds = workerIds.split(",");
                        Map<String, String> staffMap = new HashMap<>();
                        if (staffIds != null && staffIds.length > 0) {
                            for (String staffId : staffIds) {
                                staffMap.put(staffId, staffId);
                            }
                            List<String> newStaffIds = new ArrayList<>(staffMap.keySet());
                            if (!CollectionUtils.isEmpty(newStaffIds)) {
                                for (String staffId : newStaffIds) {
                                    SystemMessage systemMessage = new SystemMessage();
                                    systemMessage.setCreateTime(today);
                                    systemMessage.setMemberId(order.getMemberId());
                                    systemMessage.setStaffId(NumberUtils.toLong(staffId));
                                    systemMessage.setStatus((short) MessageConstant.MessageStatus.UNREAD.code);
                                    systemMessage.setStoreId(storeId);
                                    systemMessage.setTitle("您有新的施工任务，请尽快处理");
                                    systemMessage.setDataId(orderId);
                                    systemMessage.setCarNo(carNo);
                                    systemMessage.setType((short) MessageConstant.MessageType.DISPATCH.code);
                                    messageList.add(systemMessage);
                                }
                            }
                        }
                    }
                }
            }
        } else {
            throw new OrderException("派工失败:订单没有明细");
        }

        if (!CollectionUtils.isEmpty(messageList)) {
            for (SystemMessage systemMessage : messageList) {
                doPush(systemMessage, MessageConstant.MessageType.DISPATCH);
                epSystemMessageMapper.insert(systemMessage);
            }
        } else {
            throw new MessageException("派工失败:施工人员未选择，请选择后进行派工");
        }
    }

    @Override
    public void noticeDispatch(Long orderId, OrderItem orderItem) {
        logger.info("orderId:{}, orderItem:{}", orderId, orderItem);

        //根据订单ID查询订单信息（erp_work_order）
        Order order = epOrderMapper.selectById(orderId);
        if (order == null) {
            throw new MessageException("订单不存在");
        }
        //门店ID
        Long storeId = order.getStoreId();
        String carNo = order.getCarNo();

        if (orderItem == null) {
            throw new MessageException("订单明细为空");
        }
        if (orderItem.getId() == null) {
            throw new MessageException("订单明细ID为空");
        }
        //根据订单明细ID查询订单明细信息
        OrderItem item = epOrderItemMapper.selectById(orderItem.getId());
        if (item == null) {
            throw new MessageException("订单明细不存在");
        }

        //当前时间
        Date today = new Date();
        List<SystemMessage> messageList = new ArrayList<>();

        String workerIds = item.getWorkerIds();
        String workGroupIds = item.getWorkerGroupIds();
        if (StringUtils.isNotEmpty(workGroupIds)) {
            String[] workGroups = workGroupIds.split(",");
            for (String groupId : workGroups) {
                StaffGroup staffGroup = epStaffGroupMapper.queryOneStaffGroup(Long.valueOf(groupId));
                if (staffGroup != null) {
                    if ("".equals(workerIds)) {
                        workerIds = staffGroup.getStaffIds();
                    } else {
                        workerIds = workerIds + "," + staffGroup.getStaffIds();
                    }
                }
            }
        }

        if (StringUtils.isNotBlank(workerIds)) {
            String[] staffIds = workerIds.split(",");
            Map<String, String> staffMap = new HashMap<>();
            if (staffIds != null && staffIds.length > 0) {
                for (String staffId : staffIds) {
                    staffMap.put(staffId, staffId);
                }
                List<String> newStaffIds = new ArrayList<>(staffMap.keySet());
                if (!CollectionUtils.isEmpty(newStaffIds)) {
                    for (String staffId : newStaffIds) {
                        SystemMessage systemMessage = new SystemMessage();
                        systemMessage.setCreateTime(today);
                        systemMessage.setMemberId(order.getMemberId());
                        systemMessage.setStaffId(NumberUtils.toLong(staffId));
                        systemMessage.setStatus((short) MessageConstant.MessageStatus.UNREAD.code);
                        systemMessage.setStoreId(storeId);
                        systemMessage.setTitle("您有新的施工任务，请尽快处理");
                        systemMessage.setDataId(orderId);
                        systemMessage.setCarNo(carNo);
                        systemMessage.setType((short) MessageConstant.MessageType.DISPATCH.code);
                        messageList.add(systemMessage);
                    }
                }
            }
        }

        if (!CollectionUtils.isEmpty(messageList)) {
            for (SystemMessage systemMessage : messageList) {
                doPush(systemMessage, MessageConstant.MessageType.DISPATCH);
                epSystemMessageMapper.insert(systemMessage);
            }
        } else {
            throw new MessageException("派工失败:选择施工人员后进行派工");
        }

    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void noticePick(Long orderId) {
        //根据订单ID查询订单信息（erp_work_order）
        Order order = epOrderMapper.selectById(orderId);
        if (order == null) {
            throw new MessageException("订单不存在");
        }
        //门店ID
        Long storeId = order.getStoreId();
        String carNo = order.getCarNo();

        //根据订单ID查询订单商品明细（erp_work_order_item）
        List<OrderItemDTO> orderItemForGoods = epOrderItemMapper.queryOrderItemForGoods(order.getId());

        List<SystemMessage> messageList = new ArrayList<>();

        if (!CollectionUtils.isEmpty(orderItemForGoods)) {
            for (OrderItemDTO orderItemDTO : orderItemForGoods) {
                String itemName = orderItemDTO.getItemName();
                String pickerIds = orderItemDTO.getPickerIds();
                String pickerGroups = orderItemDTO.getPickerGroupIds();

                if (StringUtils.isNotEmpty(pickerGroups)) {
                    String[] pickers = pickerGroups.split(",");
                    for (int i = 0; i < pickers.length; i++) {
                        StaffGroup staffGroup = epStaffGroupMapper.queryOneStaffGroup(Long.valueOf(pickers[i]));
                        if (staffGroup != null) {
                            if ("".equals(pickerIds)) {
                                pickerIds = staffGroup.getStaffIds();
                            } else {
                                pickerIds = pickerIds + "," + staffGroup.getStaffIds();
                            }

                        }
                    }
                }
                if (StringUtils.isNotBlank(pickerIds)) {
                    String[] staffIds = pickerIds.split(",");
                    Map<String, String> staffMap = new HashMap<>();
                    if (staffIds != null && staffIds.length > 0) {
                        for (String staffId : staffIds) {
                            staffMap.put(staffId, staffId);
                        }
                        List<String> newStaffIds = new ArrayList<>(staffMap.keySet());
                        if (!CollectionUtils.isEmpty(newStaffIds)) {
                            for (String staffId : newStaffIds) {
                                SystemMessage systemMessage = new SystemMessage();
                                systemMessage.setCreateTime(new Date());
                                systemMessage.setMemberId(order.getMemberId());
                                systemMessage.setStaffId(NumberUtils.toLong(staffId));
                                systemMessage.setStatus((short) MessageConstant.MessageStatus.UNREAD.code);
                                systemMessage.setStoreId(storeId);
                                systemMessage.setTitle("您有新的领料任务，请尽快处理");
                                systemMessage.setDataId(orderId);
                                systemMessage.setCarNo(carNo);
                                systemMessage.setType((short) MessageConstant.MessageType.PICK.code);
                                messageList.add(systemMessage);
                            }
                        }
                    }
                }
            }
        } else {
            throw new MessageException("无商品明细，无需领料");
        }

        if (!CollectionUtils.isEmpty(messageList)) {
            for (SystemMessage systemMessage : messageList) {
                doPush(systemMessage, MessageConstant.MessageType.PICK);
                epSystemMessageMapper.insert(systemMessage);
            }
        } else {
            throw new MessageException("领料失败:领料人员未选择，请选择后进行派工");
        }
    }

    @Override
    public void noticePick(Long orderId, OrderItem orderItem) {
        logger.info("orderId:{}, orderItem:{}", orderId, orderItem);

        //根据订单ID查询订单信息（erp_work_order）
        Order order = epOrderMapper.selectById(orderId);
        if (order == null) {
            throw new MessageException("订单不存在");
        }
        //门店ID
        Long storeId = order.getStoreId();
        String carNo = order.getCarNo();

        if (orderItem == null) {
            throw new MessageException("订单明细为空");
        }
        if (orderItem.getId() == null) {
            throw new MessageException("订单明细ID为空");
        }
        //根据订单明细ID查询订单明细信息
        OrderItem item = epOrderItemMapper.selectById(orderItem.getId());
        if (item == null) {
            throw new MessageException("订单明细不存在");
        }

        Long itemId = item.getItemId();
        String type = item.getType();
        Map<String, Object> extras = new HashMap<>();
        if (OrderItemConstant.OrderItemType.isGoods(type)) {
            extras.put("goodsId", itemId);
        }

        String pickerIds = item.getPickerIds();
        String pickerGroups = item.getPickerGroupIds();

        Date today = new Date();
        List<SystemMessage> messageList = new ArrayList<>();

        if (StringUtils.isNotEmpty(pickerGroups)) {
            String[] pickers = pickerGroups.split(",");
            for (int i = 0; i < pickers.length; i++) {
                StaffGroup staffGroup = epStaffGroupMapper.queryOneStaffGroup(Long.valueOf(pickers[i]));
                if (staffGroup != null) {
                    if ("".equals(pickerIds)) {
                        pickerIds = staffGroup.getStaffIds();
                    } else {
                        pickerIds = pickerIds + "," + staffGroup.getStaffIds();
                    }

                }
            }
        }
        if (StringUtils.isNotBlank(pickerIds)) {
            String[] staffIds = pickerIds.split(",");
            Map<String, String> staffMap = new HashMap<>();
            if (staffIds != null && staffIds.length > 0) {
                for (String staffId : staffIds) {
                    staffMap.put(staffId, staffId);
                }
                List<String> newStaffIds = new ArrayList<>(staffMap.keySet());
                if (!CollectionUtils.isEmpty(newStaffIds)) {
                    for (String staffId : newStaffIds) {
                        SystemMessage systemMessage = new SystemMessage();
                        systemMessage.setCreateTime(today);
                        systemMessage.setMemberId(order.getMemberId());
                        systemMessage.setStaffId(NumberUtils.toLong(staffId));
                        systemMessage.setStatus((short) MessageConstant.MessageStatus.UNREAD.code);
                        systemMessage.setStoreId(storeId);
                        systemMessage.setTitle("您有新的领料任务，请尽快处理");
                        systemMessage.setDataId(orderId);
                        systemMessage.setCarNo(carNo);
                        systemMessage.setType((short) MessageConstant.MessageType.PICK.code);
                        if (extras.size() > 0) {// 附加信息
                            systemMessage.setExtras(JSON.toJSONString(extras));
                        }
                        messageList.add(systemMessage);
                    }
                }
            }
        }

        if (!CollectionUtils.isEmpty(messageList)) {
            for (SystemMessage systemMessage : messageList) {
                doPush(systemMessage, MessageConstant.MessageType.PICK);
                epSystemMessageMapper.insert(systemMessage);
            }
        } else {
            throw new MessageException("领料失败:选择领料人员后进行派工");
        }
    }

    @Override
    public void noticePay(Long orderId) {
        Order order = epOrderMapper.selectById(orderId);
        if (order == null) {
            throw new MessageException("指派收银失败:订单不存在");
        }

        if (OrderConstant.PayStatus.isPaySuccess(order.getPayStatus())) {
            throw new MessageException("指派收银失败:订单已经支付完成");
        }

        Long orderStaffId = order.getOrderStaffId();
        // 收银人员是空值,不需要发送
        if (orderStaffId == null) {
            throw new MessageException("指派收银失败:收银人员不存在");
        }

        SystemMessage systemMessage = new SystemMessage();
        Date today = new Date();
        systemMessage.setCreateTime(today);
        systemMessage.setUpdateTime(today);
        systemMessage.setStoreId(order.getStoreId());
        systemMessage.setCarNo(order.getCarNo());
        systemMessage.setDataId(orderId);
        systemMessage.setMemberId(order.getMemberId());
        systemMessage.setStaffId(orderStaffId);
        systemMessage.setStatus((short) MessageConstant.MessageStatus.UNREAD.code);
        systemMessage.setTitle("你的新的收银订单,请尽快处理");
        systemMessage.setType((short) MessageConstant.MessageType.PAY.code);

        doPush(systemMessage, MessageConstant.MessageType.PAY);
        epSystemMessageMapper.insert(systemMessage);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void noticeInspector(Long orderId, List<Long> orderItemIdList) {
        Order order = epOrderMapper.selectById(orderId);
        if (order == null) {
            throw new MessageException("指派质检失败:订单不存在");
        }

        List<SystemMessage> systemMessageList = new ArrayList<>();
        // 查询需订单明细的质检人员
        for (Long orderItemId : orderItemIdList) {
            OrderItem orderItem = epOrderItemMapper.selectById(orderItemId);
            if (orderItem != null) {
                String inspectorIds = orderItem.getInspectorIds();
                if (StringUtils.isNotBlank(inspectorIds)) {
                    String[] staffIds = inspectorIds.split(",");
                    Map<String, String> staffMap = new HashMap<>();
                    if (staffIds != null && staffIds.length > 0) {
                        for (String staffId : staffIds) {
                            staffMap.put(staffId, staffId);
                        }
                        List<String> newStaffIds = new ArrayList<>(staffMap.keySet());
                        if (!CollectionUtils.isEmpty(newStaffIds)) {
                            for (String staffId : newStaffIds) {
                                SystemMessage systemMessage = new SystemMessage();
                                Date today = new Date();
                                systemMessage.setCreateTime(today);
                                systemMessage.setUpdateTime(today);
                                systemMessage.setStoreId(order.getStoreId());
                                systemMessage.setCarNo(order.getCarNo());
                                systemMessage.setDataId(orderId);
                                systemMessage.setMemberId(order.getMemberId());
                                systemMessage.setStaffId(NumberUtils.toLong(staffId));
                                systemMessage.setStatus((short) MessageConstant.MessageStatus.UNREAD.code);
                                systemMessage.setTitle("你的新的质检订单,请尽快处理");
                                systemMessage.setType((short) MessageConstant.MessageType.INSPECT.code);
                                systemMessageList.add(systemMessage);
                            }
                        }
                    }
                }
            }
        }

        if (!CollectionUtils.isEmpty(systemMessageList)) {
            for (SystemMessage systemMessage : systemMessageList) {
                doPush(systemMessage, MessageConstant.MessageType.INSPECT);
                epSystemMessageMapper.insert(systemMessage);
            }
        } else {
            throw new MessageException("指派质检失败:质检人员未选择");
        }
    }

    @Override
    public void noticeMessage(SystemMessage systemMessage) {
        if (systemMessage == null) {
            throw new MessageException("消息无效");
        }
        if (systemMessage.getStoreId() == null) {
            throw new MessageException("门店无效");
        }
        Short type = systemMessage.getType();
        doAppPush(systemMessage, MessageConstant.MessageType.get(type));
        // 保存推送消息
        epSystemMessageMapper.insert(systemMessage);
    }

    @Override
    public void noticePickMessage(Long orderId, OrderItem orderItem,String extras) {
        logger.info("orderId:{}, orderItem:{}", orderId, orderItem);

        //根据订单ID查询订单信息（erp_work_order）
        Order order = epOrderMapper.selectById(orderId);
        if (order == null) {
            throw new MessageException("订单不存在");
        }
        //门店ID
        Long storeId = order.getStoreId();
        String carNo = order.getCarNo();

        if (orderItem == null) {
            throw new MessageException("订单明细为空");
        }
        String pickerIds = orderItem.getPickerIds();
        String pickerGroups = orderItem.getPickerGroupIds();
        Date today = new Date();
        List<SystemMessage> messageList = new ArrayList<>();

        if (StringUtils.isNotEmpty(pickerGroups)) {
            String[] pickers = pickerGroups.split(",");
            for (int i = 0; i < pickers.length; i++) {
                StaffGroup staffGroup = epStaffGroupMapper.queryOneStaffGroup(Long.valueOf(pickers[i]));
                if (staffGroup != null) {
                    if ("".equals(pickerIds)) {
                        pickerIds = staffGroup.getStaffIds();
                    } else {
                        pickerIds = pickerIds + "," + staffGroup.getStaffIds();
                    }

                }
            }
        }
        if (StringUtils.isNotBlank(pickerIds)) {
            String[] staffIds = pickerIds.split(",");
            Map<String, String> staffMap = new HashMap<>();
            if (staffIds != null && staffIds.length > 0) {
                for (String staffId : staffIds) {
                    staffMap.put(staffId, staffId);
                }
                List<String> newStaffIds = new ArrayList<>(staffMap.keySet());
                if (!CollectionUtils.isEmpty(newStaffIds)) {
                    for (String staffId : newStaffIds) {
                        SystemMessage systemMessage = new SystemMessage();
                        systemMessage.setCreateTime(today);
                        systemMessage.setMemberId(order.getMemberId());
                        systemMessage.setStaffId(NumberUtils.toLong(staffId));
                        systemMessage.setStatus((short) MessageConstant.MessageStatus.UNREAD.code);
                        systemMessage.setStoreId(storeId);
                        systemMessage.setTitle("您有新的领料任务，请尽快处理");
                        systemMessage.setDataId(orderId);
                        systemMessage.setCarNo(carNo);
                        systemMessage.setType((short) MessageConstant.MessageType.PICK.code);
                        systemMessage.setExtras(extras);
                        messageList.add(systemMessage);
                    }
                }
            }
        }

        if (!CollectionUtils.isEmpty(messageList)) {
            for (SystemMessage systemMessage : messageList) {
                doPush(systemMessage, MessageConstant.MessageType.PICK);
                epSystemMessageMapper.insert(systemMessage);
            }
        } else {
            throw new MessageException("领料失败:选择领料人员后进行派工");
        }
    }

    @Override
    public void noticeDispatchMessage(Long orderId, OrderItem orderItem, String extras) {
        logger.info("orderId:{}, orderItem:{}", orderId, orderItem);

        //根据订单ID查询订单信息（erp_work_order）
        Order order = epOrderMapper.selectById(orderId);
        if (order == null) {
            throw new MessageException("订单不存在");
        }
        //门店ID
        Long storeId = order.getStoreId();
        String carNo = order.getCarNo();

        if (orderItem == null) {
            throw new MessageException("订单明细为空");
        }
        //当前时间
        Date today = new Date();
        List<SystemMessage> messageList = new ArrayList<>();

        String workerIds = orderItem.getWorkerIds();
        String workGroupIds = orderItem.getWorkerGroupIds();
        if (StringUtils.isNotEmpty(workGroupIds)) {
            String[] workGroups = workGroupIds.split(",");
            for (String groupId : workGroups) {
                StaffGroup staffGroup = epStaffGroupMapper.queryOneStaffGroup(Long.valueOf(groupId));
                if (staffGroup != null) {
                    if ("".equals(workerIds)) {
                        workerIds = staffGroup.getStaffIds();
                    } else {
                        workerIds = workerIds + "," + staffGroup.getStaffIds();
                    }
                }
            }
        }

        if (StringUtils.isNotBlank(workerIds)) {
            String[] staffIds = workerIds.split(",");
            Map<String, String> staffMap = new HashMap<>();
            if (staffIds != null && staffIds.length > 0) {
                for (String staffId : staffIds) {
                    staffMap.put(staffId, staffId);
                }
                List<String> newStaffIds = new ArrayList<>(staffMap.keySet());
                if (!CollectionUtils.isEmpty(newStaffIds)) {
                    for (String staffId : newStaffIds) {
                        SystemMessage systemMessage = new SystemMessage();
                        systemMessage.setCreateTime(today);
                        systemMessage.setMemberId(order.getMemberId());
                        systemMessage.setStaffId(NumberUtils.toLong(staffId));
                        systemMessage.setStatus((short) MessageConstant.MessageStatus.UNREAD.code);
                        systemMessage.setStoreId(storeId);
                        systemMessage.setTitle("您有新的施工任务，请尽快处理");
                        systemMessage.setDataId(orderId);
                        systemMessage.setCarNo(carNo);
                        systemMessage.setType((short) MessageConstant.MessageType.DISPATCH.code);
                        systemMessage.setExtras(extras);
                        messageList.add(systemMessage);
                    }
                }
            }
        }

        if (!CollectionUtils.isEmpty(messageList)) {
            for (SystemMessage systemMessage : messageList) {
                doPush(systemMessage, MessageConstant.MessageType.DISPATCH);
                epSystemMessageMapper.insert(systemMessage);
            }
        } else {
            throw new MessageException("派工失败:选择施工人员后进行派工");
        }
    }


    /**
     * 推送处理
     *
     * @param systemMessage
     * @param messageType
     */
    private void doPush(SystemMessage systemMessage, MessageConstant.MessageType messageType) {
        Long memberId = systemMessage.getMemberId();
        MemberStoreInfo memberStoreInfo = epMemberStoreInfoMapper.selectById(memberId);
        if (memberStoreInfo == null) {
            logger.error("会员不存在 memberId:{} ", memberId);
            throw new MessageException("会员不存在");
        }
        Long staffId = systemMessage.getStaffId();
        Staff staff = epStaffMapper.selectById(staffId);
        if (staff != null) {
            String uuid = staff.getUuid();
            if (StringUtils.isBlank(uuid)) {
                logger.info("员工UUID不存在 staffId:{}", staffId);
                throw new MessageException("员工UUID不存在");
            }

            String title = systemMessage.getTitle();
            String androidTitle = AppType.BUSINESS.name;

            StringBuffer memberBuffer = new StringBuffer();
            String memberName = memberStoreInfo.getName();
            if (org.apache.commons.lang3.StringUtils.isNotBlank(memberName)) {
                memberBuffer.append(memberName);
            }
            String mobile = memberStoreInfo.getMobile();
            if (org.apache.commons.lang3.StringUtils.isNotBlank(mobile)) {
                memberBuffer.append("(");
                memberBuffer.append(mobile);
                memberBuffer.append(")");
            }

            Map<String, String> extras = new HashMap<>();
            extras.put("event", messageType.eventCode);
            if (StringUtils.isNotBlank(systemMessage.getCarNo())) {
                extras.put("carNo", systemMessage.getCarNo());
            }else {
                extras.put("carNo", "");
            }
            if (StringUtils.isNotBlank(memberBuffer.toString())) {
                extras.put("member", memberBuffer.toString());
            }else {
                extras.put("member", "");
            }
            JPushBusinessManager.getBusiness().sendPushByAlias(title, androidTitle, 1, title, extras, uuid);
        }
    }



    /**
     * App推送处理
     *
     * @param systemMessage
     * @param messageType
     */
    private void doAppPush(SystemMessage systemMessage, MessageConstant.MessageType messageType) {
        Map<String, String> extras = new HashMap<>();
        Long memberId = systemMessage.getMemberId();
        Long staffId = systemMessage.getStaffId();
        Staff staff = epStaffMapper.selectById(staffId);
        if (staff != null) {
            String uuid = staff.getUuid();
            if (StringUtils.isBlank(uuid)) {
                logger.info("员工UUID不存在 staffId:{}", staffId);
                throw new MessageException("员工UUID不存在");
            }

            String title = systemMessage.getTitle();
            String androidTitle = AppType.BUSINESS.name;
            if (memberId != null) {
                MemberStoreInfo memberStoreInfo = epMemberStoreInfoMapper.selectById(memberId);
                if (memberStoreInfo == null) {
                    logger.error("会员不存在 memberId:{} ", memberId);
                    throw new MessageException("会员不存在");
                }
                StringBuffer memberBuffer = new StringBuffer();
                String memberName = memberStoreInfo.getName();
                if (org.apache.commons.lang3.StringUtils.isNotBlank(memberName)) {
                    memberBuffer.append(memberName);
                }
                String mobile = memberStoreInfo.getMobile();
                if (org.apache.commons.lang3.StringUtils.isNotBlank(mobile)) {
                    memberBuffer.append("(");
                    memberBuffer.append(mobile);
                    memberBuffer.append(")");
                }
                if (StringUtils.isNotBlank(memberBuffer.toString())) {
                    extras.put("member", memberBuffer.toString());
                }else {
                    extras.put("member", "");
                }
            }
            extras.put("event", messageType.eventCode);
            if (StringUtils.isNotBlank(systemMessage.getCarNo())) {
                extras.put("carNo", systemMessage.getCarNo());
            }else {
                extras.put("carNo", "");
            }
            JPushBusinessManager.getBusiness().sendPushByAlias(title, androidTitle, 1, title, extras, uuid);
        }
    }


}
