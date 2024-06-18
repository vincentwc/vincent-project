package com.vincent.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.vincent.entity.UserInfo;
import com.vincent.entity.UserInfoParam;

/**
 * @author vincent
 */
public interface IUserInfoService extends IService<UserInfo> {

    UserInfo login(UserInfoParam userInfoParam);
}
