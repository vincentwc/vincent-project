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

