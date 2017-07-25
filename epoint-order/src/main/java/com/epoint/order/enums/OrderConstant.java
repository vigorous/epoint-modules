package com.epoint.order.enums;

import org.apache.commons.lang3.StringUtils;

/**
 * @author xishengchun on 2017-05-31.
 */
public class OrderConstant {

    public enum PayStatus {
        NO_PAY(0, "未支付"),
        DELAY_PAY(1, "挂账"),
        PAYING(2, "支付中"),
        PAY_FAIL(3, "支付失败"),
        PAY_SUCCESS(4, "支付成功")
        ;
        public int code;
        public String name;
        PayStatus(int code, String name) {
            this.code = code;
            this.name = name;
        }

        public static String getName(int code) {
            PayStatus[] values = PayStatus.values();
            for (PayStatus v : values) {
                if (v.code == code) {
                    return v.name;
                }
            }
            return StringUtils.EMPTY;
        }

        public static boolean isPaySuccess(int code ) {
            return PayStatus.PAY_SUCCESS.code == code;
        }

        @Override
        public String toString() {
            return String.valueOf(code);
        }
    }
}
