package com.vincent.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.io.Serializable;
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
public class FieldInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private String id;

    /**
     * 表名称
     */
    private String tableName;

    /**
     * 字段名称
     */
    private String fieldName;

    /**
     * 字段英文名
     */
    private String fieldEng;

    /**
     * 字段类型：对应字典项表的主键id
     */
    private Integer fieldType;

    /**
     * 字段单位
     */
    private String fieldUnit;

    /**
     * 字段最大值
     */
    private BigDecimal maxVal;

    /**
     * 字段最小值
     */
    private BigDecimal minVal;

    /**
     * 创建人
     */
    private String createdBy;

    /**
     * 创建时间
     */
    private LocalDateTime createdTime;

    /**
     * 更新人
     */
    private String updatedBy;

    /**
     * 更新时间
     */
    private LocalDateTime updatedTime;

    /**
     * 字段描述信息
     */
    private String description;


}
