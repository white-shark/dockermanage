package com.ccut.whiteshark.dockermanage.controller;

import com.ccut.whiteshark.dockermanage.entity.UserLogin;
import com.ccut.whiteshark.dockermanage.repository.UserLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author WhiteShark
 * @version 1.0
 * @date 2021/4/3 11:03 下午
 */
@RestController
public class SignInController {

    @Autowired
    UserLoginRepository userLoginRepository;

    @PostMapping(value = "/user/signin")
    public String signIn(@RequestParam String name, @RequestParam String password, HttpSession session){
        UserLogin login = userLoginRepository.findByUserName(name);
        if (login.getPassword().equals(password)){
            session.setAttribute("userName",login.getUserName());
            session.setAttribute("authority",login.getAuthority());
            return "index";
        }
        else {
            return "error";
        }
    }
}
