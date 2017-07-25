package com.epoint.book.enums;

/**
 * Created by chiang on 2017/5/18.
 */
public class BookInfoConstant {
    private BookInfoConstant(){}

    //1:首页(我的)预约;2:保养手册预约;3:项目预约;
    public enum BookType {
        INDEX_BOOK(1,"首页(我的)预约"),MAINTENANCE_MANUAL(2,"保养手册预约"),
        SERVICE_BOOK(3,"项目预约");
        private int code;
        private String name;

        BookType(int code,String name){
            this.code = code;
            this.name = name;
        }

        public int getCode() {
            return code;
        }

        public String getName() {
            return name;
        }

        public static boolean isMMBook(int code){
            return code == MAINTENANCE_MANUAL.code;
        }

        public static boolean isIndexBook(int code){
            return code == INDEX_BOOK.code;
        }

        public static boolean isServiceBook(int code){
            return code == SERVICE_BOOK.code;
        }
    }

    // 0:预约失败;1:预约成功;2:取消预约;3:已到店;
    public enum Status {
        FAIL(0,"预约失败"),BOOKING(1,"预约成功"),
        CANCEL(2,"取消预约"),IN_STORE(3,"已到店");
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
    }

    public enum SendMsg {
        NO_SEND(0,"未发送"),SENT(1,"已发送"),
        ;
        private int code;
        private String name;

        SendMsg(int code,String name){
            this.code = code;
            this.name = name;
        }

        public int getCode() {
            return code;
        }

        public String getName() {
            return name;
        }
    }

    public enum ReadStatus {

        NO_READ(0,"未读"),READ(1,"已读");
        private int code;
        private String name;

        ReadStatus(int code,String name){
            this.code = code;
            this.name = name;
        }

        public int getCode() {
            return code;
        }

        public String getName() {
            return name;
        }
    }
}
