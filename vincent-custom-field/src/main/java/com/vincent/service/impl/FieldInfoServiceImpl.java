package com.vincent.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vincent.entity.FieldInfo;
import com.vincent.entity.FieldInfoParam;
import com.vincent.entity.SysDictItem;
import com.vincent.mapper.FieldInfoMapper;
import com.vincent.service.IFieldInfoService;
import com.vincent.service.ISysDictItemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author vincent
 */
@Service
public class FieldInfoServiceImpl extends ServiceImpl<FieldInfoMapper, FieldInfo> implements IFieldInfoService {


    public static final String TABLE_DICT_CODE = "table_name";

    @Resource
    private ISysDictItemService dictItemService;

    @Override
    public List<SysDictItem> listTableInfos() {
        // 1. 获取所有表信息
        return dictItemService.listDictItemsByCode(TABLE_DICT_CODE);
    }

    @Override
    public List<FieldInfo> listFieldInfos(String tableName) {
        return lambdaQuery()
                .eq(FieldInfo::getFieldName, tableName)
                .list();
    }

    @Override
    public boolean createFieldInfo(FieldInfoParam fieldInfoParam) {
        // 1. 判断有没有同名的字段
        return false;
    }

    @Override
    public boolean updateFieldInfo(FieldInfoParam fieldInfoParam) {
        return false;
    }

    @Override
    public int deleteFieldInfo(FieldInfoParam fieldInfoParam) {
        return 0;
    }
}
