package com.vincent.result;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author wang_cheng
 * @desc 返回抽象类对象
 * @date 2024/6/12 17:24
 */
@Data
@ApiModel(description = "全局的统一返回结果")
@JsonPropertyOrder({"code", "desc", "message", "data"})
public class ResultVO<T> implements Serializable {

    public static final long serialVersionUID = 1L;

    /**
     * 错误码.
     */
    @ApiModelProperty(value = "状态码", example = "20000")
    @JSONField(ordinal = 1)
    private Integer code;

    /**
     * 状态码描述.
     */
    @ApiModelProperty(value = "状态码描述", example = "调用成功")
    @JSONField(ordinal = 2)
    private String desc;

    /**
     * 提示信息.
     */
    @ApiModelProperty(value = "返回信息", example = "调用成功")
    @JSONField(ordinal = 3)
    private String message;

    /**
     * 具体内容.
     */
    @ApiModelProperty(value = "返回的数据")
    @JSONField(ordinal = 4)
    private T data;


    public ResultVO() {
    }


}
