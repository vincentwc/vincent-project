package com.vincent.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.vincent.entity.SysDict;
import com.vincent.entity.SysDictParam;

import java.util.List;

/**
 * @author vincent
 */
public interface ISysDictService extends IService<SysDict> {

    boolean createDict(SysDictParam dictParam);

    boolean updateDict(SysDictParam dictParam);

    int deleteDict(String id);

    SysDict detailDict(String id);

    List<SysDict> listDict();

    IPage<SysDict> pageDict();

    /**
     * @param dictId
     * @return true-存在；false-不存在
     */
    boolean existsDict(Integer dictId);
}
