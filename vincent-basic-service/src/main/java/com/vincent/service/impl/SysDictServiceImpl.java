package com.vincent.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vincent.entity.SysDict;
import com.vincent.entity.SysDictParam;
import com.vincent.mapper.SysDictMapper;
import com.vincent.service.ISysDictService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

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
                .setCreateTime(LocalDateTime.now())
                .setCreateBy("vincent");
        return save(sysDict);
    }
}
