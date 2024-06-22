package com.vincent.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vincent.entity.SysDictItem;
import com.vincent.entity.SysDictItemParam;
import com.vincent.mapper.SysDictItemMapper;
import com.vincent.service.ISysDictItemService;
import com.vincent.service.ISysDictService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author vincent
 */
@Service
public class SysDictItemServiceImpl extends ServiceImpl<SysDictItemMapper, SysDictItem> implements ISysDictItemService {

    @Resource
    private ISysDictService dictService;

    @Override
    public List<SysDictItem> listDictItems(String dictId) {
        return lambdaQuery()
                .eq(SysDictItem::getDictId, dictId)
                .orderByAsc(SysDictItem::getItemSort)
                .list();
    }

    @Override
    public List<SysDictItem> listDictItemsByCode(String dictCode) {
        return lambdaQuery()
                .inSql(SysDictItem::getDictId, "select id from sÏys_dict where dict_code = '"+dictCode+"'" )
                .orderByAsc(SysDictItem::getItemSort)
                .eq(SysDictItem::getStatus, 1)
                .list();
    }

    @Override
    public boolean createDictItem(SysDictItemParam dictItemParam) {
        // 1. 判断字典是否存在
        boolean existsFlag = dictService.existsDict(dictItemParam.getDictId());
        if (existsFlag) {
            // 2. 获取该字典对应的排序最大的一个值
            SysDictItem oldDictItem = lambdaQuery()
                    .eq(SysDictItem::getDictId, dictItemParam.getDictId())
                    .eq(SysDictItem::getStatus, 1)
                    .orderByDesc(SysDictItem::getItemSort)
                    .last("limit 1")
                    .one();
            SysDictItem sysDictItem = new SysDictItem();
            BeanUtils.copyProperties(dictItemParam, sysDictItem);
            sysDictItem.setItemSort(ObjectUtil.isNotNull(oldDictItem) ? oldDictItem.getItemSort() + 1 : 1);
            return save(sysDictItem);
        }
        return false;
    }
}
