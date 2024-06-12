package com.vincent.api;

/**
 * API返回码接口
 *
 * @author macro
 * @date 2019/4/19
 */
public interface IErrorCode {
    /**
     * 返回码
     */
    long getCode();

    /**
     * 返回信息
     */
    String getMessage();
}
