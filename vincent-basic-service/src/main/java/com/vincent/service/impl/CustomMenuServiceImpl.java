package com.vincent.service.impl;

import com.vincent.entity.CustomMenu;
import com.vincent.mapper.CustomMenuMapper;
import com.vincent.service.ICustomMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author vincent
 */
@Service
public class CustomMenuServiceImpl extends ServiceImpl<CustomMenuMapper, CustomMenu> implements ICustomMenuService {

    @Override
    public List<CustomMenu> getAllMenus() {
        return lambdaQuery()
                .list();
    }
}
