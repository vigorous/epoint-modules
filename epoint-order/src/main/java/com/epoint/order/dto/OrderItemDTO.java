package com.epoint.order.dto;

import com.epoint.order.entity.OrderItem;
import com.epoint.staff.entity.Staff;
import com.epoint.staff.entity.StaffGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * package:com.epoint.order.dto
 *
 * @Author smallc on 2017/5/31.
 */
public class OrderItemDTO extends OrderItem {
    //项目或者商品名称
    private String itemName;

    /**
     * 质检员
     */
    private List<Staff> inspectorStaffList = new ArrayList<>();

    /**
     * 质检员姓名
     */
    private String inspectorStaffName;



    /**
     * 领料人
     */
    private List<Staff> staffPickerList = new ArrayList<>();

    /**
     * 领料组
     */
    private List<StaffGroup> staffPickerGroupList = new ArrayList<>();

    /**
     * 出库人
     */
    private String goodsOutStaffName;

    /**
     * 领料人及领料组的名称
     */
    public String pickerName;

    public String getItemName() {
        return itemName;
    }

    public List<Staff> getInspectorStaffList() {
        return inspectorStaffList;
    }

    public void setInspectorStaffList(List<Staff> inspectorStaffList) {
        this.inspectorStaffList = inspectorStaffList;
    }

    public String getInspectorStaffName() {
        return inspectorStaffName;
    }

    public void setInspectorStaffName(String inspectorStaffName) {
        this.inspectorStaffName = inspectorStaffName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public List<Staff> getStaffPickerList() {
        return staffPickerList;
    }

    public void setStaffPickerList(List<Staff> staffPickerList) {
        this.staffPickerList = staffPickerList;
    }

    public List<StaffGroup> getStaffPickerGroupList() {
        return staffPickerGroupList;
    }

    public void setStaffPickerGroupList(List<StaffGroup> staffPickerGroupList) {
        this.staffPickerGroupList = staffPickerGroupList;
    }

    public String getPickerName() {
        return pickerName;
    }

    public void setPickerName(String pickerName) {
        this.pickerName = pickerName;
    }

    public String getGoodsOutStaffName() {
        return goodsOutStaffName;
    }

    public void setGoodsOutStaffName(String goodsOutStaffName) {
        this.goodsOutStaffName = goodsOutStaffName;
    }
}
