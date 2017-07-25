package com.epoint.role.app.enums;

/**
 * @author xishengchun on 2017-06-12.
 */
public class AppRoleConstant {
    public enum DefType {

        NOT_DEFAULT(0, "非内置"),
        WORKER(1, "技师"),
        SALE(2, "销售员"),
        CASHIER(3, "前台"),
        BOSS(4, "老板"),
        ;
        public int code;
        public String name;
        DefType(int code, String name) {
            this.code = code;
            this.name = name;
        }

        public static boolean isWorker(Integer code) {
            return code != null && WORKER.code == code.intValue();
        }

        public static boolean isSale(Integer code) {
            return code != null && SALE.code == code.intValue();
        }

        public static boolean isCashier(Integer code) {
            return code != null && CASHIER.code == code.intValue();
        }

        public static boolean isBoss(Integer code) {
            return code != null && BOSS.code == code.intValue();
        }

    }
}
