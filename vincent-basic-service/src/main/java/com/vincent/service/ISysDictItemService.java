package com.vincent.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.vincent.entity.SysDictItem;

import java.util.List;

/**
 * @author vincent
 */
public interface ISysDictItemService extends IService<SysDictItem> {

    List<SysDictItem> listDictItems(String dictId);
}
