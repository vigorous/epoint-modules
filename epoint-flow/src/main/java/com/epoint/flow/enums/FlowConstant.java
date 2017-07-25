package com.epoint.flow.enums;

/**
 * @author xishengchun on 2017-05-18.
 */
public class FlowConstant {

    /**
     * 业务流程的状态
     */
    public enum FlowProcessStatus {
        CLOSED(0, "关闭"), START(1, "开启"), DELETE(2, "删除");
        public int code;
        public String name;

        FlowProcessStatus(int code, String name) {
            this.code = code;
            this.name = name;
        }

        public static boolean isClosed(Integer code) {
            if (code == null) {
                return false;
            }
            return FlowProcessStatus.CLOSED.code == code.intValue();
        }

        public static boolean isStart(Integer code) {
            if (code == null) {
                return false;
            }
            return FlowProcessStatus.START.code == code.intValue();
        }

        public static boolean isDelete(Integer code) {
            if (code == null) {
                return false;
            }
            return FlowProcessStatus.DELETE.code == code.intValue();
        }
    }

    /**
     * 业务流程类型
     */
    public enum FlowType {
        QUICK(0, "快速开单"), REPAIR(1, "维修开单");
        public int code;
        public String name;

        FlowType(int code, String name) {
            this.code = code;
            this.name = name;
        }

        public static String getName(Integer code) {
            if (code == null) {
                return "";
            }

            FlowType[] values = FlowType.values();
            for (FlowType value : values) {
                if (code.intValue() == value.code) {
                    return value.name;
                }
            }
            return "";
        }

        public static boolean isQuick(Integer code) {
            if (code == null) {
                return false;
            }
            return FlowType.QUICK.code == code.intValue();
        }

        public static boolean isRepair(Integer code) {
            if (code == null) {
                return false;
            }
            return FlowType.REPAIR.code == code.intValue();
        }

    }

    /**
     * 库存扣减方式
     */
    public enum DeductStockWay {
        WHEN_GET(0, "仓管出库减库存"),
        WHEN_PAY(1, "结算扣库存");

        public int code;
        public String name;

        DeductStockWay(int code, String name) {
            this.code = code;
            this.name = name;
        }

        public static boolean isWhenGet(Integer code) {
            if (code == null) {
                return false;
            }
            return DeductStockWay.WHEN_GET.code == code.intValue();
        }

        public static boolean isWhenPay(Integer code) {
            if (code == null) {
                return false;
            }
            return DeductStockWay.WHEN_PAY.code == code.intValue();
        }
    }

    /**
     * 节点状态
     */
    public enum NodeStatus {
        CLOSED(0, "关闭"), START(1, "开启");
        public int code;
        public String name;

        NodeStatus(int code, String name) {
            this.code = code;
            this.name = name;
        }

        public static boolean isStart(Integer code) {
            if (code == null) {
                return false;
            }
            return NodeStatus.START.code == code.intValue();
        }

        public static boolean isClosed(Integer code) {
            if (code == null) {
                return false;
            }
            return NodeStatus.CLOSED.code == code.intValue();
        }
    }

    /**
     * 节点是否可以关闭
     */
    public enum CanClose {
        NO(0, "不可关闭"), YES(1, "可关闭");
        public int code;
        public String name;

        CanClose(int code, String name) {
            this.code = code;
            this.name = name;
        }
    }

    /**
     * 门店类型
     * 1 - 总店
     * 2 - 子店或者加盟店
     */
    public enum StoreType {
        MAIN_STORE(1, "总店"),
        CHILD_STORE(2, "子店或者加盟店");

        public int code;
        public String name;

        StoreType(int code, String name) {
            this.code = code;
            this.name = name;
        }

        public static boolean isMainStore(Integer code) {
            if (code == null) {
                return false;
            }
            return StoreType.MAIN_STORE.code == code.intValue();
        }

        public static boolean isChildStore(Integer code) {
            if (code == null) {
                return false;
            }
            return StoreType.CHILD_STORE.code == code.intValue();
        }
    }

    /**
     * 节点编码
     */
    public enum NodeCode {
        RECEPT_CAR("1000", "接车"),
        CHECK_CAR("2000", "验车"),
        BILLING("3000", "开单"),
        DISPATCH("4000", "派工"),
        DISPATCH_PICKING("5000", "派工领料"),
        WORKS("6000", "施工"),
        QUALITY_CONTROL("7000", "质检"),
        ACCOUT("8000", "结算");

        public String code;
        public String name;

        NodeCode(String code, String name) {
            this.code = code;
            this.name = name;
        }

        public static boolean isQualityControl(String code) {
            return QUALITY_CONTROL.code.equals(code);
        }

        public static boolean isReceptCar(String code) {
            return RECEPT_CAR.code.equals(code);
        }

        public static boolean isCheckCar(String code) {
            return CHECK_CAR.code.equals(code);
        }


    }
}
