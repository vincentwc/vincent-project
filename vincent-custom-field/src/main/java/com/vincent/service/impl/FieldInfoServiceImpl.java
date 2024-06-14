package com.vincent.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vincent.entity.FieldInfo;
import com.vincent.entity.SysDictItem;
import com.vincent.mapper.FieldInfoMapper;
import com.vincent.service.IFieldInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author vincent
 */
@Service
public class FieldInfoServiceImpl extends ServiceImpl<FieldInfoMapper, FieldInfo> implements IFieldInfoService {

    @Override
    public List<SysDictItem> listFieldTableInfos() {
        return null;
    }
}
