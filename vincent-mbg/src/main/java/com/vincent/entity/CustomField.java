package com.vincent.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 自定义字段表
 *
 * @author vincent
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CustomField implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    /**
     * 核心字段1
     */
    private String coreField1;

    /**
     * 核心字段2
     */
    private String coreField2;

    /**
     * 核心字段3
     */
    private String coreField3;

    /**
     * 自定义字段
     */
    private String customField;


}
