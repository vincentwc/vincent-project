package com.vincent.result;

/**
 * @author Vincent
 */
public enum ResultCodeEnum {

    SUCCESS(20000, "响应成功"),
    ;

    private final int code;
    private final String desc;


    ResultCodeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static ResultCodeEnum getResultCodeEnum(Integer code) {
        if (code == null) {
            return null;
        }
        for (ResultCodeEnum value : values()) {
            if (value.getCode() == (code)) {
                return value;
            }
        }
        return null;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
