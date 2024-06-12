/*==============================================================*/
/* Table: sys_dict    字典表                                     */
/*==============================================================*/
drop table if exists sys_dict;
create table sys_dict
(
    `id`          varchar(64)  NOT NULL comment '主键id',
    `dict_name`   VARCHAR(64)  NOT NULL COMMENT '字典名称',
    `dict_code`   VARCHAR(64)  NOT NULL COMMENT '字段编码',
    `dict_type`   int(1) UNSIGNED NULL DEFAULT 0 COMMENT '字典类型0为string,1为number',
    `desc`        VARCHAR(255) NOT NULL COMMENT '字典描述',
    `create_by`   varchar(32) NULL DEFAULT NULL COMMENT '创建人',
    `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
    `update_by`   varchar(32) NULL DEFAULT NULL COMMENT '更新人',
    `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
    `del_flag`    int(1) NULL DEFAULT NULL COMMENT '删除状态',
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
    `desc`        VARCHAR(255) NOT NULL COMMENT '字典项描述',
    `create_by`   varchar(32) NULL DEFAULT NULL COMMENT '创建人',
    `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
    `update_by`   varchar(32) NULL DEFAULT NULL COMMENT '更新人',
    `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
    `del_flag`    int(1) NULL DEFAULT NULL COMMENT '删除状态',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='字典项表';