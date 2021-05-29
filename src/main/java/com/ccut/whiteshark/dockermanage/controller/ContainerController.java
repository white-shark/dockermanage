package com.ccut.whiteshark.dockermanage.controller;

import com.ccut.whiteshark.dockermanage.entity.CreatConVO;
import com.ccut.whiteshark.dockermanage.service.ContainersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author WhiteShark
 * @version 1.0
 * @date 2021/4/30 11:36 下午
 */
@RestController
@RequestMapping(value = "/containers")
public class ContainerController {

    @Autowired
    ContainersService service;

    @PostMapping(value = "/getList")
    public List<Object> getList(HttpSession session){
        return service.getList(String.valueOf(session.getAttribute("userName"))).toList();
    }

    @PostMapping(value = "/creatCon")
    public String creat(CreatConVO creatConVO, HttpSession session){
        return service.creatContainer(String.valueOf(session.getAttribute("userName")),creatConVO);
    }

    @PostMapping(value = "/start")
    public String start(String id,String ip,HttpSession session){
        return service.startContainer(id,ip,String.valueOf(session.getAttribute("userName")));
    }

    @PostMapping(value = "/stop")
    public String stop(String id,String ip,HttpSession session){
        return service.stopContainer(id,ip,String.valueOf(session.getAttribute("userName")));
    }

    @PostMapping(value = "/delete")
    public String delete(String id,String ip,HttpSession session){
        return service.deleteContainer(id,ip,String.valueOf(session.getAttribute("userName")));
    }

    @PostMapping(value = "/getLogs")
    public List<String> getLog(String id,String ip,HttpSession session){
        return service.ContainerLog(id,ip,String.valueOf(session.getAttribute("userName")));
    }

    @PostMapping(value = "/command")
    public List<String> command(String ip, String id, String command, HttpSession session){
        return service.command(id,ip,String.valueOf(session.getAttribute("userName")),command);
    }

}
