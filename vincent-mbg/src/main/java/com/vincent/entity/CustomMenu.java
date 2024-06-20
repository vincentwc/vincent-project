package com.vincent.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 菜单表
 *
 * @author vincent
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CustomMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
            @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 菜单名称
     */
    private String title;

    /**
     * 菜单图标
     */
    private String icon;

    /**
     * 菜单路径
     */
    private String path;

    /**
     * 菜单排序
     */
    private Integer sort;

    /**
     * 菜单层级
     */
    private Integer level;

    /**
     * 父级菜单id
     */
    private Integer parentId;

    /**
     * 是否隐藏菜单
     */
    private Integer hidden;

    /**
     * 描述
     */
    private String description;


}
