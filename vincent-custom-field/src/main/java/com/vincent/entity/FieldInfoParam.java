package com.vincent.entity;

import com.vincent.valid.DeleteValidGroup;
import com.vincent.valid.InsertValidGroup;
import com.vincent.valid.UpdateValidGroup;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import java.math.BigDecimal;

@Data
@Accessors(chain = true)
@ApiModel(value = "自定义字段请求体", description = "自定义字段请求体，用于自定义字段相关接口请求")
public class FieldInfoParam {

    @ApiModelProperty(value = "字段id")
    @NotBlank(groups = {UpdateValidGroup.class, DeleteValidGroup.class}, message = "id不能为空")
    @Null(groups = {InsertValidGroup.class}, message = "id需为空")
    private String id;

    @ApiModelProperty(value = "字段所属表名")
    @NotBlank(groups = {InsertValidGroup.class, UpdateValidGroup.class}, message = "表名不能为空")
    private String tableName;

    @ApiModelProperty(value = "字段名称")
    @NotBlank(groups = {InsertValidGroup.class, UpdateValidGroup.class}, message = "字段名称不能为空")
    private String fieldName;

    @ApiModelProperty(value = "字段英文名称")
    @Null(groups = {InsertValidGroup.class, UpdateValidGroup.class}, message = "字段英文名称不能用户定义")
    private String fieldEng;

    @ApiModelProperty(value = "字段类型")
    @NotBlank(groups = {InsertValidGroup.class, UpdateValidGroup.class}, message = "字段类型不能为空")
    private String fieldType;

    @ApiModelProperty(value = "字段单位")
    private String fieldUnit;

    @ApiModelProperty(value = "字段最大值")
    private BigDecimal maxVal;

    @ApiModelProperty(value = "字段最小值")
    private BigDecimal mingVal;

    @ApiModelProperty(value = "字段描述信息")
    private String description;


}
