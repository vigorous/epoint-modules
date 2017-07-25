package com.epoint.reception.enums;

/**
 * package:com.epoint.reception.enums
 *
 * @Author smallc on 2017/6/16.
 */
public class ReceptionConstant {

    public enum Status {
        NO_ORDER(0,"未开单"),
        IS_ORDER(1,"已开单");

        public int code;
        public String name;
        Status(int code, String name) {
            this.code = code;
            this.name = name;
        }
    }
}
