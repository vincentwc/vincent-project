package com.vincent.service;

import com.vincent.entity.FieldInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.vincent.entity.SysDictItem;

import java.util.List;

/**
 * @author vincent
 */
public interface IFieldInfoService extends IService<FieldInfo> {

    /**
     * @return
     */
    List<SysDictItem> listFieldTableInfos();
}
