package com.vincent.controller;


import com.vincent.api.CommonResult;
import com.vincent.entity.SysDictItem;
import com.vincent.service.IFieldInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("/field-info")
@Api(value = "字段", tags = "字段")
public class FieldInfoController {

    @Resource
    private IFieldInfoService fieldInfoService;

    @GetMapping("/list")
    @ApiOperation(value = "自定义字段的表信息", httpMethod = "GET")
    public CommonResult listFieldTableInfos() {
        List<SysDictItem> list = fieldInfoService.listFieldTableInfos();
        return CommonResult.success(list);
    }
}
