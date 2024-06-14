package com.vincent.exception;


import com.vincent.api.IErrorCode;

/**
 * 断言处理类，用于抛出各种API异常
 *
 * @author macro
 * @date 2020/2/27
 */
public class Asserts {
    public static void fail(String message) {
        throw new ApiException(message);
    }

    public static void fail(IErrorCode errorCode) {
        throw new ApiException(errorCode);
    }
}
