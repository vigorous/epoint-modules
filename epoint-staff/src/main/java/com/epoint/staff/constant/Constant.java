package com.epoint.staff.constant;

/**
 * package:com.epoint.staff.constant
 *
 * @Author smallc on 2017/6/2.
 */
public class Constant {
    /**
     * 快速开单常量
     */
    //开单权限
    public static final String QUICK_ORDER_PRIVILEGE = "quickOrderPrivilege";
    //派工权限
    public static final String QUICK_ORDER_ASSIGN_PRIVILEGE = "quickOrderAssignPrivilege";
    //派发领料权限
    public static final String QUICK_ORDER_PICK_PRIVILEGE = "quickOrderPickPrivilege";

    /**
     * 维修开单
     */
    //开单权限
    public static final String REPAIR_ORDER_PRIVILEGE = "repairOrderPrivilege";
    //派工权限
    public static final String REPAIR_ORDER_ASSIGN_PRIVILEGE = "repairOrderAssignPrivilege";
    //派发领料权限
    public static final String REPAIR_ORDER_PICK_PRIVILEGE = "repairOrderPickPrivilege";

    //付款权限
    public static final String CASH_PAY_PRIVILEGE = "cashPayPrivilege";

    //出库权限
    public static final String GOODS_OUT_PRIVILEGE = "goodsOutPrivilege";


    public static final Long CASH_BILLING = 1000L;
    public static final Long CASH_PAY = 1003L;

    public static final Long QUICK_BILLING = 19L;
    public static final Long QUICK_ASSIGN = 194L;
    public static final Long QUICK_PICK = 195L;

    public static final Long REPAIR_BILLING = 20045L;
    public static final Long REPAIR_ASSIGN = 200454L;
    public static final Long REPAIR_PICK = 200455L;

    public static final Long GOODS_OUT = 201030L;

    public static final Long ORDER_LIST_PAY = 133L;

}
