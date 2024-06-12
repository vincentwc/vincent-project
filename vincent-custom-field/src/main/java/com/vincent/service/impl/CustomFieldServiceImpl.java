package com.vincent.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vincent.entity.CustomField;
import com.vincent.mapper.CustomFieldMapper;
import com.vincent.service.ICustomFieldService;
import org.springframework.stereotype.Service;

/**
 * @author vincent
 */
@Service
public class CustomFieldServiceImpl extends ServiceImpl<CustomFieldMapper, CustomField> implements ICustomFieldService {

}
