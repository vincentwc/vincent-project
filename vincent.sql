/*==============================================================*/
/* Table: user_info    用户表                                    */
/*==============================================================*/
drop table if exists user_info;
create table user_info
(
    `id`           varchar(64) NOT NULL comment '主键id',
    `user_name`    varchar(64) comment '名称',
    `user_age`     smallint comment '年龄',
    `password`     varchar(64) comment '密码',
    `token`        varchar(256) comment '秘钥',
    `phone`        varchar(32) comment '电话号码',
    `address`      varchar(64) comment '地址',
    `portrait`     varchar(256) comment '图像url',
    `custom_field` json comment '自定义字段',
    PRIMARY KEY (id) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='用户表';

/*==============================================================*/
/* Table: custom_menu   菜单表                                    */
/*==============================================================*/
drop table if exists custom_menu;
create table custom_menu
(
    `id`          int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `title`       varchar(64) NOT NULL COMMENT '菜单名称',
    `icon`        varchar(64) NULL COMMENT '菜单图标',
    `path`        varchar(64) NOT NULL COMMENT '菜单路径',
    `sort`        int(2) NOT NULL COMMENT '菜单排序',
    `level`       int(2) NOT NULL DEFAULT 0 COMMENT '菜单层级',
    `parent_id`   int(11) COMMENT '父级菜单id',
    `hidden`      tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否隐藏菜单，默认是0不隐藏',
    `description` varchar(256) COMMENT '菜单描述',
    PRIMARY KEY (id) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='菜单表';



/*==============================================================*/
/* Table: sys_dict    字典表                                     */
/*==============================================================*/
drop table if exists sys_dict;
create table sys_dict
(
    `id`          int(11) NOT NULL AUTO_INCREMENT COMMENT '字典id',
    `dict_name`   VARCHAR(64) NOT NULL COMMENT '字典名称',
    `dict_code`   VARCHAR(64) NOT NULL COMMENT '字典编码',
    `dict_type`   int(1) UNSIGNED NULL DEFAULT 0 COMMENT '字典类型0为string,1为number',
    `description` VARCHAR(255) NULL COMMENT '字典描述',
    `create_by`   varchar(32) NULL DEFAULT NULL COMMENT '创建人',
    `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
    `update_by`   varchar(32) NULL DEFAULT NULL COMMENT '更新人',
    `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
    `del_flag`    int(1) NOT NULL DEFAULT 0 COMMENT '删除状态',
    PRIMARY KEY (`id`) USING BTREE,
--     字典编码唯一
    UNIQUE INDEX `unique_dict_code` (`dict_code`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='字典表';


/*==============================================================*/
/* Table: sys_dict_item    字典项表                               */
/*==============================================================*/
drop table if exists sys_dict_item;
create table sys_dict_item
(
    `id`          int(11) NOT NULL AUTO_INCREMENT COMMENT '字典id',
    `dict_id`     int(11) NOT NULL COMMENT '字典id',
    `item_text`   VARCHAR(128) NULL COMMENT '字典项文本',
    `item_val`    VARCHAR(128) NULL COMMENT '字典项值',
    `item_sort`   int(11) NULL DEFAULT NULL COMMENT '字典项排序',
    `status`      int(11) NULL DEFAULT 1 NULL COMMENT '状态（1启用 0不启用）',
    `is_default`  int(11) NULL DEFAULT 0 COMMENT '默认字典项（1是 0否）',
    `description` VARCHAR(255) NOT NULL COMMENT '字典项描述',
    `create_by`   varchar(32) NULL DEFAULT NULL COMMENT '创建人',
    `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
    `update_by`   varchar(32) NULL DEFAULT NULL COMMENT '更新人',
    `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
    `del_flag`    int(1) NOT NULL DEFAULT 0 COMMENT '删除状态',
    PRIMARY KEY (`id`) USING BTREE,
    --     字典项值唯一
    UNIQUE INDEX `unique_dict_item_val` (`dict_id`,`item_val`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='字典项表';

/*=================字典|字典项的数据初始化==========================*/
-- 1.1 字段类型字典
insert into `sys_dict`(`dict_name`, `dict_code`, `description`)
values ('字段类型', 'field_type', '用来记录字段类型的字典信息');
-- 1.2 字段类型字典项
select `id`
from `sys_dict`
where `dict_code` = 'field_type' into @fieldTypeDictId;
SET
@textSingle = 'text_single';
SET
@textMulti = 'text_multi';
SET
@textRich = 'text_rich';
SET
@dateDate = 'date_date';
SET
@dataTime = 'data_time';
SET
@dateFull = 'date_full';
SET
@numberInt = 'int';
SET
@numberFloat = 'float';
SET
@selectSingle = 'select_single';
SET
@selectMulti = 'select_multi';
insert into `sys_dict_item`(`dict_id`, `item_text`, `item_val`, `item_sort`, `is_default`, `description`)
values (@fieldTypeDictId, '单行文本', @textSingle, 101, 1, '字段类型---单行文本'),
       (@fieldTypeDictId, '多行文本', @textMulti, 106, 1, '字段类型---多行文本'),
       (@fieldTypeDictId, '富文本', @textRich, 111, 1, '字段类型---富文本'),
       (@fieldTypeDictId, '日期', @dateDate, 116, 1, '字段类型---日期'),
       (@fieldTypeDictId, '时间', @dataTime, 121, 1, '字段类型---时间'),
       (@fieldTypeDictId, '日期时间', @dateFull, 126, 1, '字段类型---日期时间'),
       (@fieldTypeDictId, '整数', @numberInt, 131, 1, '字段类型---整数'),
       (@fieldTypeDictId, '浮点数', @numberFloat, 136, 1, '字段类型---浮点数'),
       (@fieldTypeDictId, '单选', @selectSingle, 131, 1, '字段类型---单选'),
       (@fieldTypeDictId, '多选', @selectMulti, 136, 1, '字段类型---多选');

-- 2. 表字典
insert into `sys_dict`(`dict_name`, `dict_code`, `description`)
values ('表名称', 'table_name', '用来记录表名称字典信息');
/*==============================================================*/


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
    PRIMARY KEY (`id`) USING BTREE,
    --     同一个表里面的字段需要唯一
    UNIQUE INDEX `unique_table_name_eng` (`table_name`,`field_eng`) USING BTREE
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
