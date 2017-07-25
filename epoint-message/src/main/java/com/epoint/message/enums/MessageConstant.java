package com.epoint.message.enums;

/**
 * @author xishengchun on 2017-05-27.
 */
public class MessageConstant {

    /**
     * 消息类型
     */
    public enum MessageType {
        DISPATCH(1, "派工通知", "2030"),
        PICK(2, "领料通知", "3000"),
        @Deprecated
        CANCEL_DISPATCH(3, "取消派工", "2031"),
        CHECK_CAR(4, "验车通知", "4000"),
        CREATE_ORDER(5, "验车单的开单通知", "5000"),
        RECEPTION_CREATE_ORDER(6, "接车单的开单通知", "5100"),
        INSPECT(7, "质检通知", "6000"),
        PAY(8, "待收银", "7000"),
        LEAVE(9, "请假", "8000"),
        PURCHASE(10, "采购审批", "8100"),
        OTHER(11, "其他审批", "9000"),
        ;
        public int code;
        public String name, eventCode;

        /**
         *
         * @param code
         * @param name
         * @param eventCode
         * 推送的时候使用
         */
        MessageType(int code, String name, String eventCode) {
            this.code = code;
            this.name = name;
            this.eventCode = eventCode;
        }

        public static boolean validMessageType(short type) {
            MessageType[] values = MessageType.values();
            for (MessageType value : values) {
                if (value.code == type) {
                    return true;
                }
            }
            return false;
        }

        public static MessageType get(int type) {
            MessageType[] values = MessageType.values();
            for (MessageType value : values) {
                if (value.code == type) {
                    return value;
                }
            }
            return null;
        }

    }

    /**
     * 消息状态
     */
    public enum MessageStatus {
        UNREAD(0, "未读取"),
        READED(1, "已读取"),
        DELETE(2, "已删除"),
        ;

        public int code;
        public String name;
        MessageStatus(int code, String name) {
            this.code = code;
            this.name = name;
        }
    }

}
