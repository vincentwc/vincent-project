package com.vincent.controller;


import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.vincent.api.CommonResult;
import com.vincent.entity.SysDict;
import com.vincent.entity.SysDictParam;
import com.vincent.service.ISysDictService;
import com.vincent.valid.DeleteValidGroup;
import com.vincent.valid.InsertValidGroup;
import com.vincent.valid.UpdateValidGroup;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author vincent
 */
@Slf4j
@Validated
@RestController
@RequestMapping("/sys-dict")
@Api(value = "字典", tags = "字典")
public class SysDictController {

    @Resource
    private ISysDictService dictService;

    /**
     * 创建字典
     *
     * @param dictParam
     * @return
     */
    @PostMapping("/create")
    @ApiOperation(value = "创建字典", httpMethod = "POST")
    public CommonResult createDict(@RequestBody @Validated(InsertValidGroup.class) SysDictParam dictParam) {
        boolean createFlag = dictService.createDict(dictParam);
        if (createFlag) {
            return CommonResult.success();
        } else {
            return CommonResult.failed("字典保存失败");
        }
    }


    /**
     * 更新字典
     *
     * @param dictParam
     * @return
     */
    @PutMapping("/update")
    @ApiOperation(value = "更新字典", httpMethod = "PUT")
    public CommonResult updateDict(@RequestBody @Validated(UpdateValidGroup.class) SysDictParam dictParam) {
        boolean updateFlag = dictService.updateDict(dictParam);
        if (updateFlag) {
            return CommonResult.success();
        } else {
            return CommonResult.failed("字典跟新失败");
        }
    }


    /**
     * 删除字典
     *
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "删除字典", httpMethod = "DELETE")
    public CommonResult deleteDict(@PathVariable("id") String id) {
        int count = dictService.deleteDict(id);
        if (count > 0) {
            return CommonResult.success();
        } else {
            return CommonResult.failed("字典删除失败");
        }
    }

    /**
     * 查询字典详情
     *
     * @param id
     * @return
     */
    @GetMapping("/detail/{id}")
    @ApiOperation(value = "查询字典详情", httpMethod = "GET")
    public CommonResult detailDict(@PathVariable("id") String id) {
        SysDict dict = dictService.detailDict(id);
        if (ObjectUtil.isNotNull(dict)) {
            return CommonResult.success(dict);
        } else {
            return CommonResult.failed("字典详情查询失败");
        }
    }

    @GetMapping("/list")
    @ApiOperation(value = "查询字典列表", httpMethod = "GET")
    public CommonResult listDict() {
        List<SysDict> list = dictService.listDict();
        return CommonResult.success(list);
    }

    @GetMapping("/page")
    @ApiOperation(value = "分页查询字典", httpMethod = "GET")
    public CommonResult pageDict() {
        IPage<SysDict> pages = dictService.pageDict();

        return CommonResult.success(pages);
    }



}
