package com.ccut.whiteshark.dockermanage.service;

import com.ccut.whiteshark.dockermanage.api.ContainerUtils;
import com.ccut.whiteshark.dockermanage.client.docker.DockerConfig;
import com.ccut.whiteshark.dockermanage.client.docker.HttpClient;
import com.ccut.whiteshark.dockermanage.entity.ContainerEntity;
import com.ccut.whiteshark.dockermanage.entity.CreatConVO;
import com.ccut.whiteshark.dockermanage.entity.UserHost;
import com.ccut.whiteshark.dockermanage.entity.UserInfo;
import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.CreateContainerResponse;
import com.github.dockerjava.api.exception.InternalServerErrorException;
import com.github.dockerjava.api.model.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WhiteShark
 * @version 1.0
 * @date 2021/5/3 11:38 下午
 */
public interface ContainersService {

    public JSONArray getList(String userName);

    public String creatContainer(String userName, CreatConVO creatConVO);

    public String startContainer(String id,String ip,String userName);

    public String stopContainer(String id,String ip,String userName);

    public String deleteContainer(String id,String ip,String userName);
    public List<String> ContainerLog(String id,String ip,String userName);
}
