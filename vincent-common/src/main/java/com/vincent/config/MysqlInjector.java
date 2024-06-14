package com.vincent.config;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.baomidou.mybatisplus.extension.injector.methods.InsertBatchSomeColumn;
import com.google.common.collect.ImmutableList;

import java.util.List;

/**
 * @Author gjc
 * @Date 2022/9/19
 */
public class MysqlInjector extends DefaultSqlInjector {

    private static final ImmutableList<String> IGNORE_PROPERTY = ImmutableList.of(
            "delFlag"
    );

    @Override
    public List<AbstractMethod> getMethodList(Class<?> mapperClass) {
        List<AbstractMethod> methodList = super.getMethodList(mapperClass);
        // 表示批量插入的时候， 不处理delFlag属性， 直接取表中字段的默认值
        methodList.add(new InsertBatchSomeColumn(t ->
                !IGNORE_PROPERTY.contains(t.getProperty())));
        return methodList;
    }
}
