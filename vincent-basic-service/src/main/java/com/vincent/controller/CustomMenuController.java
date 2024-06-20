package com.vincent.controller;


import com.vincent.api.CommonResult;
import com.vincent.entity.CustomMenu;
import com.vincent.service.ICustomMenuService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author vincent
 */
@RestController
@Slf4j
@Validated
@RequestMapping("/custom-menu")
@Api(value = "菜单", tags = "菜单")
public class CustomMenuController {

    @Resource
    private ICustomMenuService customMenuService;

    /**
     * 获取所有菜单信息
     * @return
     */
    @RequestMapping("/all")
    public CommonResult all() {
        List<CustomMenu> menuList = customMenuService.getAllMenus();
        return CommonResult.success(menuList);
    }
}
