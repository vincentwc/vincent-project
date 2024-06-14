package com.vincent.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.vincent.entity.SysDict;
import com.vincent.entity.SysDictParam;

/**
 * @author vincent
 */
public interface ISysDictService extends IService<SysDict> {

    boolean createDict(SysDictParam dictParam);

    boolean update(SysDictParam dictParam);
}
