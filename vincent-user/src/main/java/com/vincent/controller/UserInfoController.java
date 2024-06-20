package com.vincent.controller;


import cn.hutool.core.util.ObjectUtil;
import com.vincent.api.CommonResult;
import com.vincent.entity.UserInfo;
import com.vincent.entity.UserInfoParam;
import com.vincent.service.IUserInfoService;
import com.vincent.valid.InsertValidGroup;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author vincent
 */
@Slf4j
@Validated
@RestController
@RequestMapping("/user-info")
@Api(value = "字典", tags = "字典")
public class UserInfoController {

    @Resource
    private IUserInfoService userInfoService;

    /**
     * 用户登录
     *
     * @param userInfoParam
     * @return
     */
    @PostMapping("/login")
    @ApiOperation(value = "用户登录", httpMethod = "POST")
    public CommonResult login(@RequestBody @Validated(InsertValidGroup.class) UserInfoParam userInfoParam) {
        UserInfo userInfo = userInfoService.login(userInfoParam);
        if (ObjectUtil.isNotNull(userInfo)) {
            return CommonResult.success(userInfo);
        } else {
            return CommonResult.failed("用户登录失败了");
        }
    }

    /**
     * 用户退出
     *
     * @param token
     * @return
     */
    @GetMapping("/logout")
    @ApiOperation(value = "用户登录", httpMethod = "GET")
    public CommonResult logout(@RequestHeader(name = HttpHeaders.AUTHORIZATION) String token) {
            return CommonResult.success();
    }

    /**
     * 获取用户信息
     *
     * @param token
     * @return
     */
    @GetMapping("/info")
    @ApiOperation(value = "用户登录", httpMethod = "GET")
    public CommonResult userInfo(@RequestHeader(name = HttpHeaders.AUTHORIZATION) String token) {
        UserInfo userInfo = userInfoService.info(token);
        if (ObjectUtil.isNotNull(userInfo)) {
            return CommonResult.success(userInfo);
        } else {
            return CommonResult.failed("用户信息获取失败");
        }
    }
}
