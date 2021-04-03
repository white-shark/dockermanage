package com.ccut.whiteshark.dockermanage.controller;

import com.ccut.whiteshark.dockermanage.entity.UserLogin;
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

    @PostMapping(value = "/user/signup")
    public String signUp(@RequestParam String name,@RequestParam String email,@RequestParam String password){
        ArrayList<UserLogin> list = userLoginRepository.findAllByUserName(name);
        for (UserLogin userLogin : list) {
            if (userLogin.getUserName().equals(name)) {
                return "用户名已存在";
            }
        }
        UserLogin login = new UserLogin();
        login.setUserName(name);
        login.setEmail(email);
        login.setPassword(password);
        userLoginRepository.save(login);
        return "index";
    }

}
