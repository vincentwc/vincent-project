package com.vincent.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.vincent.entity.SysDictItem;
import com.vincent.entity.SysDictItemParam;

import java.util.List;

/**
 * @author vincent
 */
public interface ISysDictItemService extends IService<SysDictItem> {

    List<SysDictItem> listDictItems(String dictId);

    List<SysDictItem> listDictItemsByType(String dictType);

    boolean createDictItem(SysDictItemParam dictItemParam);
}
