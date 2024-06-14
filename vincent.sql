/*==============================================================*/
/* Table: user_info    用户表                                    */
/*==============================================================*/
drop table if exists user_info;
create table user_info
(
    id           varchar(64) NOT NULL comment '主键id',
    user_name    varchar(64) comment '名称',
    user_age     smallint comment '年龄',
    address      varchar(64) comment '地址',
    custom_field json comment '自定义字段',
    PRIMARY KEY (id) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='用户表';



/*==============================================================*/
/* Table: sys_dict    字典表                                     */
/*==============================================================*/
drop table if exists sys_dict;
create table sys_dict
(
    `id`          varchar(64) NOT NULL comment '主键id',
    `dict_name`   VARCHAR(64) NOT NULL COMMENT '字典名称',
    `dict_code`   VARCHAR(64) NOT NULL COMMENT '字典编码',
    `dict_type`   int(1) UNSIGNED NULL DEFAULT 0 COMMENT '字典类型0为string,1为number',
    `description` VARCHAR(255) NULL COMMENT '字典描述',
    `create_by`   varchar(32) NULL DEFAULT NULL COMMENT '创建人',
    `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
    `update_by`   varchar(32) NULL DEFAULT NULL COMMENT '更新人',
    `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
    `del_flag`    int(1) NOT NULL DEFAULT 0 COMMENT '删除状态',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='字典表';


/*==============================================================*/
/* Table: sys_dict_item    字典项表                               */
/*==============================================================*/
drop table if exists sys_dict_item;
create table sys_dict_item
(
    `id`          varchar(64)  NOT NULL comment '主键id',
    `dict_id`     VARCHAR(64)  NOT NULL COMMENT '字典id',
    `item_text`   VARCHAR(128) NULL COMMENT '字典项文本',
    `item_val`    VARCHAR(128) NULL COMMENT '字典项值',
    `item_sort`   int(11) NULL DEFAULT NULL COMMENT '字典项排序',
    `status`      int(11) NULL DEFAULT NULL COMMENT '状态（1启用 0不启用）',
    `is_default`  int(11) NULL DEFAULT NULL COMMENT '默认字典项（1是 0否）',
    `description` VARCHAR(255) NOT NULL COMMENT '字典项描述',
    `create_by`   varchar(32) NULL DEFAULT NULL COMMENT '创建人',
    `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
    `update_by`   varchar(32) NULL DEFAULT NULL COMMENT '更新人',
    `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
    `del_flag`    int(1) NOT NULL DEFAULT 0 COMMENT '删除状态',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='字典项表';

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
    `description`  TEXT COMMENT '字段描述信息',
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
