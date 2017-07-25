package com.epoint.coupon.enums;

/**
 * Created by chiang on 2017/4/13.
 */
public class CouponConstant {
    private CouponConstant(){}
    public enum Status {
        OPEN((short) 0,"启用"),CLOSED((short) 1,"停用");
        private short code;
        private String name;

        Status(short code,String name){
            this.code = code;
            this.name = name;
        }

        public short getCode() {
            return code;
        }

        public String getName() {
            return name;
        }

        public static boolean isOpen(short status){
            return status == OPEN.code;
        }

        public static boolean isClosed(short status){
            return status == CLOSED.code;
        }
    }

    public enum UseStatus {
        NOT_USED((short) 0,"未使用"),USING((short)1,"使用中"),USED((short) 2,"已使用");
        private short code;
        private String name;

        UseStatus(short code,String name){
            this.code = code;
            this.name = name;
        }

        public short getCode() {
            return code;
        }

        public String getName() {
            return name;
        }

        public static boolean isNotUsed(short status){
            return status == NOT_USED.code;
        }

        public static boolean isUsing(short status){
            return status == USING.code;
        }

        public static boolean isUsed(short status){
            return status == USED.code;
        }
    }

    public enum TaskStatus {
        NOT_FINISHED((short) 0,"未完成"),FINISHED((short)1,"已完成"),RECEIVED_COUPON((short) 2,"已领取");
        private short code;
        private String name;

        TaskStatus(short code,String name){
            this.code = code;
            this.name = name;
        }

        public short getCode() {
            return code;
        }

        public String getName() {
            return name;
        }

        public static boolean isFinished(short status){
            return status == FINISHED.code;
        }

        public static boolean isReceived(short status){
            return status == RECEIVED_COUPON.code;
        }
    }

    public enum ShareStatus {
        NOT_FINISHED((short) 0,"未完成"),FINISHED((short)1,"已完成"),CANCEL((short)2,"取消分享");
        private short code;
        private String name;

        ShareStatus(short code,String name){
            this.code = code;
            this.name = name;
        }

        public short getCode() {
            return code;
        }

        public String getName() {
            return name;
        }

        public static boolean isFinished(short status){
            return status == FINISHED.code;
        }

        public static boolean isNotFinished(short status){
            return status == NOT_FINISHED.code;
        }
    }


    public enum CouponType {
        CASH((short) 1,"现金券"),
        GOODS((short) 2,"商品券"),
        SERVICE((short) 3,"项目券");
        private short code;
        private String name;

        CouponType(short code,String name){
            this.code = code;
            this.name = name;
        }

        public short getCode() {
            return code;
        }

        public String getName() {
            return name;
        }
    }

    public enum RegAutoSend {
        YES((short) 1,"注册发放"),NO((short) 0,"注册不发放");
        private short code;
        private String name;

        RegAutoSend(short code,String name){
            this.code = code;
            this.name = name;
        }

        public short getCode() {
            return code;
        }

        public String getName() {
            return name;
        }

        public static boolean isAutoSend(Short code){
            return code != null && code == YES.code;
        }
    }

    public enum  Unlimited {
        YES(-1,"不限制");
        private int code;
        private String name;

        Unlimited(int code,String name){
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

    public enum ReceiveType {
        REG((short) 1,"注册领取"),SHARE((short)2,"分享任务完成领取"),ERP_DIRECT_SEND((short)3,"ERP后台直接发放");
        private short code;
        private String name;

        ReceiveType(short code,String name){
            this.code = code;
            this.name = name;
        }

        public short getCode() {
            return code;
        }

        public String getName() {
            return name;
        }

        public static boolean isRegReceive(Short code){
            return code != null && code == REG.code;
        }

        public static boolean isShareReceive(Short code){
            return code != null && code == SHARE.code;
        }

    }
}
