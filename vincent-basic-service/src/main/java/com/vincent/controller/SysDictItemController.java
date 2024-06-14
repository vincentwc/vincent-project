package com.vincent.controller;


import com.vincent.api.CommonResult;
import com.vincent.entity.SysDictItem;
import com.vincent.service.ISysDictItemService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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

    /**
     *
     * @return
     */
    public CommonResult createDictItem() {
        return null;
    }

    @GetMapping("/list/{dictId}")
    @ApiOperation(value = "查询字典列表", httpMethod = "GET")
    public CommonResult listDictItems(@PathVariable(value = "dictId") String dictId) {
        List<SysDictItem> list = dictItemService.listDictItems(dictId);
        return CommonResult.success(list);
    }
}
