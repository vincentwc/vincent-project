package com.vincent.controller;


import com.vincent.api.CommonResult;
import com.vincent.entity.SysDictItem;
import com.vincent.entity.SysDictItemParam;
import com.vincent.service.ISysDictItemService;
import com.vincent.valid.InsertValidGroup;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author vincent
 */
@RestController
@RequestMapping("/sys-dict-item")
public class SysDictItemController {

    @Resource
    private ISysDictItemService dictItemService;


    @GetMapping("/list/{dictId}")
    @ApiOperation(value = "查询字典列表", httpMethod = "GET")
    public CommonResult listDictItems(@PathVariable(value = "dictId") String dictId) {
        List<SysDictItem> list = dictItemService.listDictItems(dictId);
        return CommonResult.success(list);
    }

    @PostMapping("/create")
    @ApiOperation(value = "创建字典项", httpMethod = "POST")
    public CommonResult createDictItems(
            @RequestBody @Validated(InsertValidGroup.class) SysDictItemParam dictItemParam) {
        boolean createFlag = dictItemService.createDictItem(dictItemParam);
        if (createFlag) {
            return CommonResult.success();
        } else {
            return CommonResult.failed("创建字典项失败");
        }
    }
}
