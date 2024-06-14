package com.vincent.entity;

import com.vincent.valid.InsertValidGroup;
import com.vincent.valid.QueryValidGroup;
import com.vincent.valid.UpdateValidGroup;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author wang_cheng
 * @desc TODO
 * @date 2024/6/14 10:29
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "字典项请求体", description = "字典项请求体数据，用于字典相关接口请求")
public class SysDictItemParam {

    @ApiModelProperty(value = "字典项id")
    @NotNull(groups = {QueryValidGroup.class, UpdateValidGroup.class}, message = "字典项Id不能为空")
    private Integer id;

    @ApiModelProperty(value = "字典id")
    @NotNull(groups = {QueryValidGroup.class, UpdateValidGroup.class, InsertValidGroup.class}, message = "字典Id不能为空")
    private Integer dictId;

    /**
     * 字典项文本
     */
    @ApiModelProperty(value = "字典项文本")
    @NotBlank(groups = {InsertValidGroup.class, UpdateValidGroup.class}, message = "字典项文本不能为空")
    private String itemText;

    /**
     * 字典项值
     */
    @ApiModelProperty(value = "字典项值")
    @NotBlank(groups = {InsertValidGroup.class, UpdateValidGroup.class}, message = "字典项值不能为空")
    private String itemVal;

    /**
     * 字典项描述
     */
    @ApiModelProperty(value = "字典项描述信息")
    private String description;

}
