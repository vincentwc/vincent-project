package com.vincent.controller;


import com.vincent.api.CommonResult;
import com.vincent.entity.FieldInfo;
import com.vincent.entity.FieldInfoParam;
import com.vincent.entity.SysDictItem;
import com.vincent.service.IFieldInfoService;
import com.vincent.valid.InsertValidGroup;
import com.vincent.valid.UpdateValidGroup;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author vincent
 */
@Slf4j
@Validated
@RestController
@RequestMapping("/field-info")
@Api(value = "字典-自定义字段信息", tags = "字典-自定义字段信息")
public class FieldInfoController {

    @Resource
    private IFieldInfoService fieldInfoService;

    /**
     * 获取表的列表信息
     *
     * @return
     */
    @GetMapping("/list")
    @ApiOperation(value = "表集合信息", httpMethod = "GET")
    public CommonResult listTableInfos() {
        List<SysDictItem> list = fieldInfoService.listTableInfos();
        return CommonResult.success(list);
    }

    /**
     * 获取选中表的自定义字段信息
     *
     * @param tableName
     * @return
     */
    @GetMapping("/list/field")
    @ApiOperation(value = "表的自定义字段信息", httpMethod = "GET")
    public CommonResult listFieldInfos(@RequestParam(name = "tableName") String tableName) {
        List<FieldInfo> list = fieldInfoService.listFieldInfos(tableName);
        return CommonResult.success(list);
    }


    /**
     * 给选中表添加自定义字段
     *
     * @param fieldInfoParam
     * @return
     */
    @PostMapping("/list/field/create")
    @ApiOperation(value = "创建自定义字段", httpMethod = "POST")
    public CommonResult createFieldInfo(@RequestBody @Validated(InsertValidGroup.class) FieldInfoParam fieldInfoParam) {
        boolean createFlag = fieldInfoService.createFieldInfo(fieldInfoParam);
        if (createFlag) {
            return CommonResult.success();
        } else {
            return CommonResult.failed();
        }
    }

    /**
     * 更新自定义字段
     *
     * @param fieldInfoParam
     * @return
     */
    @PutMapping("/list/field/update")
    @ApiOperation(value = "更新自定义字段", httpMethod = "PUT")
    public CommonResult updateFieldInfo(@RequestBody @Validated(UpdateValidGroup.class) FieldInfoParam fieldInfoParam) {
        boolean update = fieldInfoService.updateFieldInfo(fieldInfoParam);
        if (update) {
            return CommonResult.success();
        } else {
            return CommonResult.failed();
        }
    }


    /**
     * 删除自定义字段
     *
     * @param fieldInfoParam
     * @return
     */
    @DeleteMapping("/list/field/delete")
    @ApiOperation(value = "删除自定义字段", httpMethod = "DELETE")
    public CommonResult deleteFieldInfo(@RequestBody @Validated(UpdateValidGroup.class) FieldInfoParam fieldInfoParam) {
        int count = fieldInfoService.deleteFieldInfo(fieldInfoParam);
        if (count > 0) {
            return CommonResult.success();
        } else {
            return CommonResult.failed("字段删除失败");
        }
    }

}
