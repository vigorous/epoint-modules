package com.epoint.order.service.impl;

import com.epoint.goods.exception.GoodsException;
import com.epoint.goods.service.IEPGoodsService;
import com.epoint.order.dao.EPOrderItemMapper;
import com.epoint.order.dao.EPOrderMapper;
import com.epoint.order.dto.OrderItemDTO;
import com.epoint.order.entity.Order;
import com.epoint.order.entity.OrderItem;
import com.epoint.order.enums.OrderItemConstant;
import com.epoint.order.exception.OrderException;
import com.epoint.order.service.IEPOrderService;
import com.epoint.staff.dao.EPStaffGroupMapper;
import com.epoint.staff.dao.EPStaffMapper;
import com.epoint.staff.entity.Staff;
import com.epoint.staff.entity.StaffGroup;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author xishengchun on 2017-06-05.
 */
@Service
public class EPOrderService implements IEPOrderService {

    private Logger logger = LogManager.getLogger(EPOrderService.class);

    @Autowired
    private EPOrderMapper epOrderMapper;

    @Autowired
    private EPOrderItemMapper orderItemMapper;

    @Autowired
    private EPStaffGroupMapper epStaffGroupMapper;

    @Autowired
    private EPStaffMapper epStaffMapper;

    @Autowired
    private IEPGoodsService epGoodsService;

    /**
     * 如果还需要其他订单明细内容,则请在方法中补充
     *
     * @param orderId
     * @return
     */
    @Override
    public List<OrderItemDTO> queryOrderItemForGoods(Long orderId) {
        List<OrderItemDTO> orderItemDTOList = orderItemMapper.queryOrderItemForGoods(orderId);

        for (OrderItemDTO orderItemDTO : orderItemDTOList) {
            StringBuffer pickerNameBuffer = new StringBuffer();

            String pickerGroupIds = orderItemDTO.getPickerGroupIds();
            if (org.apache.commons.lang3.StringUtils.isNotBlank(pickerGroupIds)) {
                String[] pickerGroupIdArray = pickerGroupIds.split(",");
                // 选择的组别
                for (String groupId : pickerGroupIdArray) {
                    StaffGroup staffGroup = epStaffGroupMapper.selectById(NumberUtils.toLong(groupId));
                    if (staffGroup != null) {
                        orderItemDTO.getStaffPickerGroupList().add(staffGroup);
                        pickerNameBuffer.append(staffGroup.getName());
                        pickerNameBuffer.append(",");
                    }
                }
            }

            String pickerIds = orderItemDTO.getPickerIds();
            if (org.apache.commons.lang3.StringUtils.isNotBlank(pickerIds)) {
                String[] pickerIdArray = pickerIds.split(",");
                // 选择的员工
                for (String staffId : pickerIdArray) {
                    Staff staff = epStaffMapper.selectById(NumberUtils.toLong(staffId));
                    if (staff != null) {
                        orderItemDTO.getStaffPickerList().add(staff);
                        pickerNameBuffer.append(staff.getName());
                        pickerNameBuffer.append(",");
                    }
                }
            }

            Long goodsStaffOutId = orderItemDTO.getGoodsOutStaffId();
            if (goodsStaffOutId != null) {
                Staff staff = epStaffMapper.selectById(goodsStaffOutId);
                if (staff != null) {
                    orderItemDTO.setGoodsOutStaffName(staff.getName());
                }
            }
            orderItemDTO.setPickerName(pickerNameBuffer.toString());
        }

        return orderItemDTOList;
    }

    @Override
    public List<OrderItemDTO> queryOrderItemForAutoWork(Long orderId) {
        List<OrderItemDTO> orderItemDTOList = orderItemMapper.queryOrderItemForAutoWork(orderId);
        for (OrderItemDTO orderItemDTO : orderItemDTOList) {
            StringBuffer inspectorStaffBuffer = new StringBuffer();
            String inspectorIds = orderItemDTO.getInspectorIds();
            if (StringUtils.isNotBlank(inspectorIds)) {
                String[] inspectorIdArray = inspectorIds.split(",");
                for (String s : inspectorIdArray) {
                    Staff staff = epStaffMapper.selectById(NumberUtils.toLong(s));
                    if (staff != null) {
                        orderItemDTO.getInspectorStaffList().add(staff);
                        inspectorStaffBuffer.append(staff.getName());
                        inspectorStaffBuffer.append(",");
                    }
                }
                orderItemDTO.setInspectorStaffName(inspectorStaffBuffer.toString());
            }
        }

        return orderItemDTOList;
    }

    @Override
    public boolean validOrderAllDetailAssign(Long orderId) {
        List<OrderItem> orderItems = orderItemMapper.queryOrderItemByOrderId(orderId);

        if (orderItems.size() <= 0) {
            logger.debug("订单无明细 orderId:{}", orderId);
            throw new OrderException("订单无明细");
        }

        for (OrderItem orderItem : orderItems) {
            if (StringUtils.isEmpty(orderItem.getWorkerIds()) && StringUtils.isEmpty(orderItem.getWorkerGroupIds())) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean validOrderGoodsPick(Long orderId) {
        List<OrderItem> orderItems = orderItemMapper.queryOrderItemByOrderId(orderId);

        if (orderItems.size() <= 0) {
            logger.debug("订单无明细 orderId:{}", orderId);
            throw new OrderException("订单无明细");
        }

        for (OrderItem orderItem : orderItems) {
            String type = orderItem.getType();
            if (OrderItemConstant.OrderItemType.isGoods(type)) {
                if (StringUtils.isEmpty(orderItem.getPickerIds()) && StringUtils.isEmpty(orderItem.getPickerGroupIds())) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    @Transactional
    public void assignCheck(Long orderId, List<OrderItem> orderItems) {
        Order order = epOrderMapper.selectById(orderId);
        if (order == null) {
            throw new OrderException("指派质检失败:订单不存在");
        }

        for (OrderItem orderItemDTO : orderItems) {
            OrderItem orderItem = orderItemMapper.selectById(orderItemDTO.getId());
            if (orderItem != null) {
                OrderItem item = new OrderItem();
                item.setId(orderItem.getId());
                item.setInspectorIds(orderItemDTO.getInspectorIds());
                item.setInspectionStatus(OrderItemConstant.InspectionStatus.INSPECTING.code);
                int r = orderItemMapper.updateById(item);
                if (r < 1) {
                    throw new OrderException("指派质检失败:修改质检人和质检状态失败");
                }
            }
        }
    }

    @Override
    public void reduceGoodsStock(List<OrderItem> goodsItemDTOList, Long goodsOutStaffId) {
        for (OrderItem orderItem : goodsItemDTOList) {
            /* 根据订单明细ID查询订单明细信息 */
            OrderItem item = orderItemMapper.selectById(orderItem.getId());

            // 如果非商品,则不做任何处理
            if (!OrderItemConstant.OrderItemType.isGoods(item.getType())) {
                continue;
            }

            if (item == null) {
                throw new OrderException("订单明细不存在");
            }
            //已减过库存无需再减库存
            if (OrderItemConstant.GoodsOutStatus.isHaveOut(item.getGoodsOutStatus())) {
                continue;
            }
            double amount = com.rd.erp.util.NumberUtils.toDouble(item.getAmount());
            if (amount == 0) {
                throw new OrderException("商品数量为空");
            }

            Double orderItemAmount = com.rd.erp.util.NumberUtils.toDouble(orderItem.getAmount());

            if (orderItemAmount != amount) {
                throw new OrderException("商品数量不匹配");
            }

            if (org.apache.commons.lang.StringUtils.isEmpty(orderItem.getPickerIds()) && org.apache.commons.lang.StringUtils.isEmpty(orderItem.getPickerGroupIds())) {
                throw new OrderException("领料人不能为空");
            }

            // 扣减库存
            boolean flag = epGoodsService.reduceStock(item.getItemId(), item.getStoreId(), orderItemAmount);

            if (flag) {
                OrderItem orderMx = new OrderItem();
                orderMx.setId(orderItem.getId());
                orderMx.setPickerIds(orderItem.getPickerIds());
                orderMx.setPickerGroupIds(orderItem.getPickerGroupIds());
                orderMx.setGoodsOutStaffId(goodsOutStaffId);
                orderMx.setGoodsOutStatus(OrderItemConstant.GoodsOutStatus.HAVE_OUT.code);
                int rr = orderItemMapper.updateById(orderMx);
                if (rr < 1) {
                    throw new GoodsException("修改订单明细商品出库状态和领料人失败");
                }
            }

        }
    }
}
