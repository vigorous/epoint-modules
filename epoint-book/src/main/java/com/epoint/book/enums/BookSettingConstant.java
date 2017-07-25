package com.epoint.book.enums;

/**
 * Created by chiang on 2017/5/18.
 */
public class BookSettingConstant {
    private BookSettingConstant(){}

    //1:周设置;0:具体设置
    public enum IsWeek {//默认1;设置具体日期上预约人数后变为0
        YES(1,"按周设置"),NO(0,"按天设置");
        private int code;
        private String name;

        IsWeek(int code,String name){
            this.code = code;
            this.name = name;
        }

        public int getCode() {
            return code;
        }

        public String getName() {
            return name;
        }

        public static boolean isWeek(int code){
            return code == YES.code;
        }

        public static boolean isDay(int code){
            return code == NO.code;
        }
    }

}
