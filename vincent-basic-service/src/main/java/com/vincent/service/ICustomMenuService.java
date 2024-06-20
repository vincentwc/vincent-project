package com.vincent.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.vincent.entity.CustomMenu;

import java.util.List;

/**
 * @author vincent
 */
public interface ICustomMenuService extends IService<CustomMenu> {

    List<CustomMenu> getAllMenus();
}
