package com.ccut.whiteshark.dockermanage.service;

import com.ccut.whiteshark.dockermanage.entity.CreatConVO;
import org.json.JSONArray;

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
    public List<String> command(String id, String ip, String userName,String command);
}
