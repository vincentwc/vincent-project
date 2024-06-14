package com.vincent.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vincent.entity.SysDict;
import com.vincent.entity.SysDictParam;
import com.vincent.mapper.SysDictMapper;
import com.vincent.service.ISysDictService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author vincent
 */
@Service
public class SysDictServiceImpl extends ServiceImpl<SysDictMapper, SysDict> implements ISysDictService {


    @Override
    public boolean createDict(SysDictParam dictParam) {
        SysDict sysDict = new SysDict();
        BeanUtils.copyProperties(dictParam, sysDict);
        sysDict
                .setCreateBy("vincent")
                .setCreateTime(LocalDateTime.now());
        return save(sysDict);
    }

    @Override
    public boolean updateDict(SysDictParam dictParam) {
        return lambdaUpdate()
                .set(SysDict::getDictName, dictParam.getDictName())
                .set(SysDict::getDictCode, dictParam.getDictCode())
                .set(SysDict::getUpdateBy, "vincent")
                .set(SysDict::getDescription, dictParam.getDescription())
                .set(SysDict::getUpdateTime, LocalDateTime.now())
                .eq(SysDict::getId, dictParam.getId())
                .update();
    }

    @Override
    public int deleteDict(String id) {
        return baseMapper.deleteById(id);
    }

    @Override
    public SysDict detailDict(String id) {
        return lambdaQuery()
                .eq(SysDict::getId, id)
                .one();
    }

    @Override
    public List<SysDict> listDict() {
        return lambdaQuery().list();
    }

    @Override
    public IPage<SysDict> pageDict() {
        IPage<SysDict> pages = new Page<>();
        return lambdaQuery()
                .page(pages);
    }


}
