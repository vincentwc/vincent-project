package com.vincent.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vincent.entity.CustomMenu;
import com.vincent.entity.CustomMenuParam;
import com.vincent.mapper.CustomMenuMapper;
import com.vincent.service.ICustomMenuService;
import org.springframework.beans.BeanUtils;
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

    @Override
    public boolean saveOrUpdateMenu(CustomMenuParam menuParam) {
        CustomMenu customMenu = new CustomMenu();
        BeanUtils.copyProperties(menuParam, customMenu);
        Integer parentId = menuParam.getParentId();
        if (null != parentId && -1 != parentId) {
            // 层级参数处理
            customMenu.setLevel(2);
        } else {
            customMenu.setLevel(1);
        }
        return saveOrUpdate(customMenu);
    }
}
