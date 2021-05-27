package com.ccut.whiteshark.dockermanage.controller;

import com.ccut.whiteshark.dockermanage.entity.ServiceControl;
import com.ccut.whiteshark.dockermanage.entity.UserInfo;
import com.ccut.whiteshark.dockermanage.entity.UserLogin;
import com.ccut.whiteshark.dockermanage.repository.ServiceControlRepository;
import com.ccut.whiteshark.dockermanage.repository.UserInfoRepository;
import com.ccut.whiteshark.dockermanage.repository.UserLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WhiteShark
 * @version 1.0
 * @date 2021/4/3 2:07 上午
 */
@RestController
public class SignUpController {

    @Autowired
    UserLoginRepository userLoginRepository;
    @Autowired
    UserInfoRepository userInfoRepository;

    @Autowired
    ServiceControlRepository serviceControlRepository;

    @PostMapping(value = "/user/signup")
    public String signUp(@RequestParam String name,@RequestParam String email,@RequestParam String password){
        ServiceControl serviceControl = serviceControlRepository.findByName("zckz");
        if (serviceControl.getValue() == 1){
            ArrayList<UserLogin> list = userLoginRepository.findAllByUserName(name);
            for (UserLogin userLogin : list) {
                if (userLogin.getUserName().equals(name)) {
                    return "exists";
                }
            }
            UserLogin login = new UserLogin();
            login.setUserName(name);
            login.setEmail(email);
            login.setPassword(password);
            login.setAuthority("user");
            userLoginRepository.save(login);
            UserInfo userInfo = new UserInfo();
            userInfo.setUserName(name);
            userInfo.setEmail(email);
            userInfo.setAuthority("user");
            userInfo.setDockerHub("https://index.docker.io/v1/");
            userInfoRepository.save(userInfo);
            return "index";
        }
        else {
            return "close";
        }

    }

}
