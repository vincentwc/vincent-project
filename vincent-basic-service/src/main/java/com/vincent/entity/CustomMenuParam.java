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
import javax.validation.constraints.Null;

/**
 * @author wang_cheng
 * @desc TODO
 * @date 2024/6/21 11:10
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "菜单项请求体", description = "菜单项请求体数据，用于菜单相关接口请求")

public class CustomMenuParam {

    @ApiModelProperty(value = "菜单id")
    @NotNull(groups = {QueryValidGroup.class, UpdateValidGroup.class}, message = "菜单Id不能为空")
    @Null(groups = {InsertValidGroup.class}, message = "菜单Id需为空")
    private Integer id;

    @ApiModelProperty(value = "菜单标题")
    @NotBlank(groups = {InsertValidGroup.class, UpdateValidGroup.class}, message = "菜单标题不能为空")
    private String title;

    @ApiModelProperty(value = "菜单图标")
    @NotBlank(groups = {InsertValidGroup.class, UpdateValidGroup.class}, message = "菜单图标不能为空")
    private String icon;

    @ApiModelProperty(value = "菜单路径")
    @NotBlank(groups = {InsertValidGroup.class, UpdateValidGroup.class}, message = "菜单路径不能为空")
    private String path;

    @ApiModelProperty(value = "菜单排序")
    @NotNull(groups = {InsertValidGroup.class, UpdateValidGroup.class}, message = "菜单排序不能为空")
    private Integer sort;

    @ApiModelProperty(value = "父级菜单id")
    @NotNull(groups = {InsertValidGroup.class, UpdateValidGroup.class}, message = "父级菜单id不能为空")
    private Integer parentId;

    @ApiModelProperty(value = "是否隐藏菜单")
    @NotNull(groups = {InsertValidGroup.class, UpdateValidGroup.class}, message = "是否隐藏菜单字段不能为空")
    private Integer hidden;


    @ApiModelProperty(value = "菜单描述")
    private String description;

}
