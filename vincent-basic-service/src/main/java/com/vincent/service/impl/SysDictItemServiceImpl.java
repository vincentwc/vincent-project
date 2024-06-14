package com.vincent.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vincent.entity.SysDictItem;
import com.vincent.entity.SysDictItemParam;
import com.vincent.mapper.SysDictItemMapper;
import com.vincent.service.ISysDictItemService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author vincent
 */
@Service
public class SysDictItemServiceImpl extends ServiceImpl<SysDictItemMapper, SysDictItem> implements ISysDictItemService {

    @Override
    public List<SysDictItem> listDictItems(String dictId) {
        return lambdaQuery()
                .eq(SysDictItem::getDictId, dictId)
                .orderByAsc(SysDictItem::getItemSort)
                .list();
    }

    @Override
    public List<SysDictItem> listDictItemsByType(String dictType) {
        return lambdaQuery()
                .inSql(SysDictItem::getDictId, "select id from sys_dict where dict_type = " + dictType)
                .orderByAsc(SysDictItem::getItemSort)
                .eq(SysDictItem::getStatus, 1)
                .list();
    }

    @Override
    public boolean createDictItem(SysDictItemParam dictItemParam) {
        // 1. 判断字典是否存在
        return false;
    }
}
