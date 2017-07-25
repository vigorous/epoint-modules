package com.epoint.order.enums;

import org.apache.commons.lang3.StringUtils;

/**
 * @author xishengchun on 2017-06-05.
 */
public class OrderItemConstant {
    /**
     * 商品出库状态
     * 该状态主要用于手动出库
     */
    public enum GoodsOutStatus {
        NO_OUT(0, "未出库"),
        HAVE_OUT(1, "已出库"),
        ;
        public int code;
        public String name;
        GoodsOutStatus(int code, String name) {
            this.code = code;
            this.name = name;
        }

        public static boolean isNoOut(Integer code) {
            if (code == null) {
                return false;
            }
            return NO_OUT.code == code.intValue();
        }

        public static boolean isHaveOut(Integer code) {
            if (code == null) {
                return false;
            }
            return HAVE_OUT.code == code.intValue();
        }
    }

    public enum OrderItemStatus {
        WAIT("0","等待中"),
        WORKING("1","施工中"),
        FINISHED("2","施工完成");

        public String code;
        public String name;

        OrderItemStatus(String code,String name){
            this.code = code;
            this.name = name;
        }

        public static boolean isFinished(String code) {
            return FINISHED.code.equals(code);
        }
    }

    public enum Rework {
        ISREWORK(1, "返工"),
        NOREWORK(0, "未返工"),
        QUALITY_PASS(3, "质检通过"),
        ;


        public int code;
        public String name;

        Rework(int code, String name) {
            this.code = code;
            this.name = name;
        }

        public static String getName(int code) {
            Rework[] values = Rework.values();
            for (Rework v : values) {
                if (v.code == code) {
                    return v.name;
                }
            }
            return StringUtils.EMPTY;
        }

        @Override
        public String toString() {
            return String.valueOf(code);
        }

    }

    /**
     * 订单明细的质检3个阶段
     */
    public enum InspectionStatus {
        INSPECTION_NO(0, "未质检"),
        INSPECTING(1, "质检中"),
        INSPECTED(2, "质检结束");

        public int code;
        public String name;
        InspectionStatus(int code, String name) {
            this.code = code;
            this.name = name;
        }

        /**
         * 未开始质检
         * @param code
         * @return
         */
        public static boolean noInspection(Integer code) {
            if (code == null) {
                return false;
            }
            return INSPECTION_NO.code == code.intValue();
        }

        /**
         * 质检中
         * @param code
         * @return
         */
        public static boolean inspecting(Integer code) {
            if (code == null) {
                return false;
            }
            return INSPECTING.code == code.intValue();
        }

        /**
         * 质检结束
         * @param code
         * @return
         */
        public static boolean inspected(Integer code) {
            if (code == null) {
                return false;
            }
            return INSPECTED.code == code.intValue();
        }

    }

    public enum OrderItemType {
        //    1： 2： A: B: C:
        SERVICES("1", "项目"),
        GOODS("2", "商品"),
        INSURANCE("3", "保险"),//item_id保存的是erp_insurance的id
        BUY_CARD("D", "购买会员卡"),// item_id保存的是erp_card的id
        CHARGE_SERVICE_CARD("E", "充值项目"),// item_id保存的是项目id
        CHARGE_GOODS_CARD("F", "充值商品"),// item_id保存的是商品的id
        CHARGE_CASH_CARD("G", "充值金额"),// item_id=erp_member_card的id

        CHARGE_CASH_PRESENT("H", "充值赠送金额"),
        CHARGE_GOODS_PRESENT("I", "充值赠送商品"),
        CHARGE_SERVICE_PRESENT("J", "充值赠送项目"),

        //**注意 订单项是会员卡项删除的标记 同时需要判断amount字段 amount为0,删除该项.amount>0,表示将余额更新为[amount] **
        REMOVE_CASH_CARD("K", "删除金额"),
        REMOVE_GOODS_CARD("L", "删除商品"),
        REMOVE_SERVICE_CARD("M", "删除项目"),
        ;

        public String code, name;
        OrderItemType(String code, String name) {
            this.code = code;
            this.name = name;
        }

        public static String getName(String code) {
            OrderItemType[] values = OrderItemType.values();
            for (OrderItemType v : values) {
                if (v.code.equals(code)) {
                    return v.name;
                }
            }
            return StringUtils.EMPTY;
        }

        public static boolean isGoods(String code) {
            return GOODS.code.equals(code);
        }

        @Override
        public String toString(){
            return code;
        }
    }
}
