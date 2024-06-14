### [此项目是一个总结性的练习项目](https://github.com/vincentwc/vincent-project.git)

| 模块名称                  | 模块描述                           | 模块功能           |
|:----------------------|:-------------------------------|:---------------|
| vincent-common        | 通用模块                           | 通用模块-定义一些通用的东西 |
| vincent-mbg           | MybatisPlusGenerator生成的数据库操作代码 | 代码生成模块         |
| vincent-custom-field  | 自定义字段项目                        | 可以自定义表字段信息     |
| vincent-basic-service | 基本服务                           | 基本服务           |

### 记录

1. javax.validation.constraints包下NotNull、NotBlank、NotEmpty的区别
    - NotNull: 不为null，但是可以为空(empty)，没有size的约束
    - NotBlank: 只能用于String，不能为null，且trim()之后的size>0
    - NotEmpty: 用于集合类，不能为null，且size>0