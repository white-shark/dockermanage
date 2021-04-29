package com.ccut.whiteshark.dockermanage.controller;

import com.ccut.whiteshark.dockermanage.entity.UserHost;
import com.ccut.whiteshark.dockermanage.repository.UserHostRepository;
import com.ccut.whiteshark.dockermanage.service.HostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * @author WhiteShark
 * @version 1.0
 * @date 2021/4/29 12:08 上午
 */
@RestController
@RequestMapping(value = "/host")
public class HostController {

    @Autowired
    HostService service;

    @PostMapping(value = "/getIpList")
    public String getIpList(HttpSession session){
        return service.getIpList(String.valueOf(session.getAttribute("userName"))).toString();
    }
}
