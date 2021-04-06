package com.ccut.whiteshark.dockermanage.controller;

import com.ccut.whiteshark.dockermanage.entity.UserInfo;
import com.ccut.whiteshark.dockermanage.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @Author WeiPeng
 * @Date 2021/4/6 9:26
 * @Version 1.0
 */
@RestController
public class UserInfoController {

    @Autowired
    UserInfoRepository userInfoRepository;

    @PostMapping(value = "/user/getDockerHub")
    public String getDockerHub(HttpSession session){
        UserInfo userInfo = userInfoRepository.findByUserName((String) session.getAttribute("userName"));
        return userInfo.getDockerHub();
    }
}
