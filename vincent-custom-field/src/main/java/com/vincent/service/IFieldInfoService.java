package com.vincent.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.vincent.entity.FieldInfo;
import com.vincent.entity.FieldInfoParam;
import com.vincent.entity.SysDictItem;

import java.util.List;

/**
 * @author vincent
 */
public interface IFieldInfoService extends IService<FieldInfo> {

    /**
     * @return
     */
    List<SysDictItem> listTableInfos();

    List<FieldInfo> listFieldInfos(String tableName);

    boolean createFieldInfo(FieldInfoParam fieldInfoParam);

    boolean updateFieldInfo(FieldInfoParam fieldInfoParam);

    int deleteFieldInfo(FieldInfoParam fieldInfoParam);
}
