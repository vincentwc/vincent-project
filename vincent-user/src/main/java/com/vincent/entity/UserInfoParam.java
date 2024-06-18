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
 * @date 2024/6/18 19:17
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "用户请求体", description = "用户请求体数据，用于用户相关接口请求")
public class UserInfoParam {

    @ApiModelProperty(value = "用户id")
    @NotNull(groups = {QueryValidGroup.class, UpdateValidGroup.class}, message = "用户id不能为空")
    @Null(groups = {InsertValidGroup.class}, message = "用户id需为空")
    private Integer id;


    @ApiModelProperty(value = "电话号码")
    @NotBlank(groups = {InsertValidGroup.class, UpdateValidGroup.class}, message = "电话号码不能为空")
    private String phone;




    @ApiModelProperty(value = "密码")
    @NotBlank(groups = {InsertValidGroup.class, UpdateValidGroup.class}, message = "密码不能为空")
    private String password;
}
