package com.ccut.whiteshark.dockermanage.controller;

import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author WhiteShark
 * @version 1.0
 * @date 2021/4/3 2:07 上午
 */
@RestController
public class SignUpController {

    @PostMapping(value = "/user/signup")
    public String signUp(@RequestParam String name,@RequestParam String email,@RequestParam String password){
        return "";
    }

}
