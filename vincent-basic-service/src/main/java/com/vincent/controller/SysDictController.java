package com.vincent.controller;


import com.vincent.api.CommonResult;
import com.vincent.entity.SysDictParam;
import com.vincent.service.ISysDictService;
import com.vincent.valid.InsertValidGroup;
import com.vincent.valid.UpdateValidGroup;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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
    @PostMapping("/update")
    @ApiOperation(value = "更新字典", httpMethod = "POST")
    public CommonResult updateDict(@RequestBody @Validated(UpdateValidGroup.class) SysDictParam dictParam) {
        boolean updateFlag = dictService.update(dictParam);
        if (updateFlag) {
            return CommonResult.success();
        } else {
            return CommonResult.failed("字典跟新失败");
        }
    }

}
