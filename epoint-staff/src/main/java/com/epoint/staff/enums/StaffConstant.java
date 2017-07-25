package com.epoint.staff.enums;

import org.apache.commons.lang3.StringUtils;

/**
 * package:com.epoint.staff.enums
 *
 * @Author smallc on 2017/5/26.
 */
public class StaffConstant {

    public enum RoleType {
        SALE_STAFF(0, "销售人员"),
        WORK_STAFF(1, "施工人员"),
        OTHER_STAFF(2, "其他"),;
        public int code;
        public String name;

        RoleType(int code, String name) {
            this.code = code;
            this.name = name;
        }

        public static String getName(int code) {
            RoleType[] values = RoleType.values();
            for (RoleType v : values) {
                if (v.code == code) {
                    return v.name;
                }
            }
            return StringUtils.EMPTY;
        }

        public static boolean isSaleStaff(Integer code) {
            if (code == null) {
                return false;
            }
            return RoleType.SALE_STAFF.code == code.intValue();
        }

        public static boolean isWorkStaff(Integer code) {
            if (code == null) {
                return false;
            }
            return RoleType.WORK_STAFF.code == code.intValue();
        }
    }
}
