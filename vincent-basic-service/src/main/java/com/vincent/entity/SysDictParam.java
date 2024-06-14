package com.vincent.entity;

import com.vincent.valid.DeleteValidGroup;
import com.vincent.valid.InsertValidGroup;
import com.vincent.valid.QueryValidGroup;
import com.vincent.valid.UpdateValidGroup;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

/**
 * @author wang_cheng
 * @desc TODO
 * @date 2024/6/14 10:29
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "字典请求体", description = "字典请求体数据，用于字典相关接口请求")
public class SysDictParam {

    @ApiModelProperty(value = "字典id")
    @NotBlank(groups = {QueryValidGroup.class, UpdateValidGroup.class}, message = "字典Id不能为空")
    private String id;

    /**
     * 字典名称
     */
    @ApiModelProperty(value = "字典名称")
    @NotBlank(groups = {InsertValidGroup.class, UpdateValidGroup.class}, message = "字典名称不能为空")
    private String dictName;

    /**
     * 字典编码
     */
    @ApiModelProperty(value = "字典编码")
    @NotBlank(groups = {InsertValidGroup.class, UpdateValidGroup.class}, message = "字典编码不能为空")
    private String dictCode;

    /**
     * 字典类型0为string,1为number
     */
    @ApiModelProperty(value = "字典类型0为string,1为number,默认为0")
    private Integer dictType;

    /**
     * 字典描述
     */
    @ApiModelProperty(value = "字典描述信息")
    private String description;

}
