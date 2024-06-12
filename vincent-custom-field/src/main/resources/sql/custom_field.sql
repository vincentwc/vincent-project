/*==============================================================*/
/* Table: field_info    字段信息表                                */
/*==============================================================*/
drop table if exists field_info;
create table field_info
(
    `id`           varchar(64)  NOT NULL comment '主键id',
    `table_name`   VARCHAR(64)  NOT NULL COMMENT '表名称',
    `field_name`   VARCHAR(64)  NOT NULL COMMENT '字段名称',
    `field_eng`    VARCHAR(128) NOT NULL COMMENT '字段英文名',
    `field_type`   INT(11) NOT NULL COMMENT '字段类型：对应字典项表的主键id',
    `field_unit`   VARCHAR(255) COMMENT '字段单位',
    `max_val`      DECIMAL(10, 2) COMMENT '字段最大值',
    `min_val`      DECIMAL(10, 2) COMMENT '字段最小值',
    `created_by`   VARCHAR(64) COMMENT '创建人',
    `created_time` DATETIME COMMENT '创建时间',
    `updated_by`   VARCHAR(64) COMMENT '更新人',
    `updated_time` DATETIME COMMENT '更新时间',
    `desc`         TEXT COMMENT '字段描述信息',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='自定义字段表';



/*==============================================================*/
/* Table: custom_field    自定义字段表                            */
/*==============================================================*/
drop table if exists custom_field;
create table custom_field
(
    `id`           varchar(64) NOT NULL comment '主键id',
    `core_field_1` varchar(64) comment '核心字段1',
    `core_field_2` varchar(64) comment '核心字段2',
    `core_field_3` varchar(64) comment '核心字段3',
    `custom_field` json comment '自定义字段',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='自定义字段表';
