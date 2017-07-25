package com.epoint.tmsg.enums;

/**
 * Created by chiang on 2017/4/13.
 */
public class StoreMsgTemplateConstant {
    private StoreMsgTemplateConstant(){}
    public enum Status {
        OPEN(1,"启用"),CLOSED(0,"停用");
        private int code;
        private String name;

        Status(int code,String name){
            this.code = code;
            this.name = name;
        }

        public int getCode() {
            return code;
        }

        public String getName() {
            return name;
        }

        public static boolean isOpen(int status){
            return status == OPEN.code;
        }

        public static boolean isClosed(int status){
            return status == CLOSED.code;
        }
    }

}
