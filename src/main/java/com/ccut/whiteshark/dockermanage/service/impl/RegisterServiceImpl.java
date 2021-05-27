package com.ccut.whiteshark.dockermanage.service.impl;

import com.ccut.whiteshark.dockermanage.entity.UserInfo;
import com.ccut.whiteshark.dockermanage.repository.UserInfoRepository;
import com.ccut.whiteshark.dockermanage.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author WhiteShark
 * @version 1.0
 * @date 2021/5/18 1:57 下午
 */
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    UserInfoRepository userInfoRepository;

    @Override
    public String getInfo(String userName) {
        UserInfo userInfo = userInfoRepository.findByUserName(userName);
        return null;
    }
}
