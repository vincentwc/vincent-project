package com.vincent.controller;


import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author vincent
 */
@Slf4j
@Validated
@RestController
@RequestMapping("/user-info")
@Api(value = "字典", tags = "字典")
public class UserInfoController {


}
