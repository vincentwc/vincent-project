package com.vincent.controller;


import com.vincent.api.CommonResult;
import com.vincent.entity.CustomMenu;
import com.vincent.entity.CustomMenuParam;
import com.vincent.service.ICustomMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
     *
     * @return
     */
    @GetMapping("/all")
    @ApiOperation(value = "获取所有菜单信息", httpMethod = "POST")
    public CommonResult all() {
        List<CustomMenu> menuList = customMenuService.getAllMenus();
        return CommonResult.success(menuList);
    }

    /**
     * 保存或新增菜单
     *
     * @return
     */
    @PostMapping("/saveOrUpdate")
    @ApiOperation(value = "保存或新增菜单", httpMethod = "POST")
    public CommonResult saveOrUpdateMenu(@RequestBody CustomMenuParam menuParam) {
        boolean flag = customMenuService.saveOrUpdateMenu(menuParam);
        if (flag) {
            return CommonResult.success();
        } else {
            return CommonResult.failed();
        }
    }

    /**
     * 删除菜单
     *
     * @return
     */
    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "保存或新增菜单", httpMethod = "delete")
    public CommonResult deleteMenu(@PathVariable(name = "id") Integer id) {
        boolean flag = customMenuService.removeById(id);
        if (flag) {
            return CommonResult.success();
        } else {
            return CommonResult.failed();
        }
    }
}
