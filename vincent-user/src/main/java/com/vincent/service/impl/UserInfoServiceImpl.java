package com.vincent.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vincent.entity.UserInfo;
import com.vincent.entity.UserInfoParam;
import com.vincent.mapper.UserInfoMapper;
import com.vincent.service.IUserInfoService;
import org.springframework.stereotype.Service;

/**
 * @author vincent
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {

    @Override
    public UserInfo login(UserInfoParam userInfoParam) {
        return lambdaQuery()
                .eq(UserInfo::getPassword, userInfoParam.getPassword())
                .eq(UserInfo::getPhone, userInfoParam.getPhone())
                .one();
    }

    @Override
    public UserInfo info(String token) {
        return lambdaQuery()
                .eq(UserInfo::getToken, token)
                .one();
    }
}
