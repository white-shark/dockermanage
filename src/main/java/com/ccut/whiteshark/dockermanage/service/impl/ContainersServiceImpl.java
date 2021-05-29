package com.ccut.whiteshark.dockermanage.service.impl;

import com.ccut.whiteshark.dockermanage.api.ContainerUtils;
import com.ccut.whiteshark.dockermanage.client.docker.DockerConfig;
import com.ccut.whiteshark.dockermanage.client.docker.HttpClient;
import com.ccut.whiteshark.dockermanage.entity.ContainerEntity;
import com.ccut.whiteshark.dockermanage.entity.CreatConVO;
import com.ccut.whiteshark.dockermanage.entity.UserHost;
import com.ccut.whiteshark.dockermanage.entity.UserInfo;
import com.ccut.whiteshark.dockermanage.exception.MinimesosException;
import com.ccut.whiteshark.dockermanage.repository.UserHostRepository;
import com.ccut.whiteshark.dockermanage.repository.UserInfoRepository;
import com.ccut.whiteshark.dockermanage.service.ContainersService;
import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.CreateContainerResponse;
import com.github.dockerjava.api.command.ExecCreateCmdResponse;
import com.github.dockerjava.api.command.LogContainerCmd;
import com.github.dockerjava.api.exception.InternalServerErrorException;
import com.github.dockerjava.api.model.*;
import com.github.dockerjava.core.command.ExecStartResultCallback;
import com.github.dockerjava.core.command.LogContainerResultCallback;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author WhiteShark
 * @version 1.0
 * @date 2021/4/30 11:00 下午
 */
@Service
public class ContainersServiceImpl implements ContainersService {

    @Autowired
    UserHostRepository userHostRepository;

    @Autowired
    UserInfoRepository userInfoRepository;

    private static final Logger logger = LoggerFactory.getLogger(ImageServiceImpl.class);


    @Override
    public JSONArray getList(String userName){
        logger.info("获取容器列表");
        List<UserHost> list = userHostRepository.findAllByUserName(userName);
        JSONArray result = new JSONArray();
        for (UserHost userHost : list){
            JSONArray array = new JSONArray(ContainerUtils.getList(userHost.getHost(),userHost.getPort()));
            JSONArray jsonArray = new JSONArray();
            for (int i = 0; i < array.length(); i++){
                JSONObject jsonObject = array.getJSONObject(i);
                ContainerEntity entity = new ContainerEntity();
                entity.setIp(userHost.getHost());
                entity.setId(jsonObject.getString("Id"));
                JSONArray array1 = jsonObject.getJSONArray("Names");
                entity.setName(array1.getString(0));
                entity.setImageName(jsonObject.getString("Image"));
                entity.setState(jsonObject.getString("State"));
                entity.setStatus(jsonObject.getString("Status"));
                jsonArray.put(entity);
            }
            result.put(jsonArray);
        }
        return result;
    }

    @Override
    public String creatContainer(String userName, CreatConVO creatConVO){
        UserInfo userInfo = userInfoRepository.findByUserName(userName);
        UserHost userHost = userHostRepository.findByUserNameAndHost(userName,creatConVO.getIp());
        DockerConfig config = new DockerConfig();
        config.setRegistryUser(userInfo.getRegistryUser());
        config.setRegistryPass(userInfo.getRegistryPass());
        config.setRegistryMail(userInfo.getRegistryMail());
        config.setRegistryUrl(userInfo.getDockerHub());
        config.setHost("tcp://"+ userHost.getHost()  + ":" + userHost.getPort());
        HttpClient httpClient = new HttpClient();
        DockerClient dockerClient = httpClient.client(config);

        String[] conPorts = creatConVO.getConPort().split(",");
        String[] hostPorts = creatConVO.getHostPort().split(",");
        String[] conPaths = creatConVO.getConPath().split(",");
        String[] hostPaths = creatConVO.getHostPath().split(",");

        List<PortBinding> portBindings = new ArrayList<>();
        List<Bind> binds = new ArrayList<>();
        List<ExposedPort> exposedPorts = new ArrayList<>();
        for (int i = 0; i < conPorts.length; i++){
            portBindings.add(PortBinding.parse(conPorts[i] + ":" + hostPorts[i]));
            exposedPorts.add(ExposedPort.parse(conPorts[i] + "/tcp"));
        }
        for (int i = 0; i < conPaths.length ; i++){
            binds.add(new Bind(conPaths[i],new Volume(hostPaths[i])));
        }
        HostConfig hostConfig = HostConfig.newHostConfig()
                .withPortBindings(portBindings)
                .withBinds(binds);
        try {
            CreateContainerResponse response = dockerClient.createContainerCmd("tomcat")
                    .withName("tomcat")
                    .withHostConfig(hostConfig)
                    .withExposedPorts(exposedPorts)
                    .exec();
            return response.getId() + "创建成功！";
        }catch (InternalServerErrorException e){
            return "创建失败，请检查配置和镜像";
        }
    }

    @Override
    public String startContainer(String id,String ip,String userName){
        UserHost userHost = userHostRepository.findByUserNameAndHost(userName,ip);
        String res = ContainerUtils.startContainer(userHost.getHost(),userHost.getPort(),id);
        if (res == ""){
            return "success";
        }
        else {
            JSONObject jsonObject = new JSONObject(res);
            return jsonObject.getString("message");
        }
    }

    @Override
    public String stopContainer(String id,String ip,String userName){
        UserHost userHost = userHostRepository.findByUserNameAndHost(userName,ip);
        String res = ContainerUtils.stopContainer(userHost.getHost(),userHost.getPort(),id);
        if (res.equals("")){
            return "success";
        }
        else {
            JSONObject jsonObject = new JSONObject(res);
            return jsonObject.getString("message");
        }
    }

    @Override
    public String deleteContainer(String id,String ip,String userName){
        UserHost userHost = userHostRepository.findByUserNameAndHost(userName,ip);
        JSONObject res = ContainerUtils.deleteContainer(userHost.getHost(),userHost.getPort(),id);
        System.out.println(res.toString());
        if (res.getInt("code") == 204 || res.getInt("code") == 200){
            return "success";
        }
        else {
            return res.getString("data");
        }
    }

    @Override
    public List<String> ContainerLog(String id, String ip, String userName) {
        UserHost userHost = userHostRepository.findByUserNameAndHost(userName,ip);
        UserInfo userInfo = userInfoRepository.findByUserName(userName);

        DockerConfig config = new DockerConfig();
        config.setRegistryUser(userInfo.getRegistryUser());
        config.setRegistryPass(userInfo.getRegistryPass());
        config.setRegistryMail(userInfo.getRegistryMail());
        config.setRegistryUrl(userInfo.getDockerHub());
        config.setHost("tcp://"+ userHost.getHost()  + ":" + userHost.getPort());
        HttpClient httpClient = new HttpClient();
        DockerClient dockerClient = httpClient.client(config);
        List<String> logs = new ArrayList<>();

        LogContainerCmd logContainerCmd = dockerClient.logContainerCmd(id);
        logContainerCmd.withStdOut(true).withStdErr(true);
        try {
            logContainerCmd.exec(new LogContainerResultCallback() {
                @Override
                public void onNext(Frame item) {
                    logs.add(item.toString());
                }
            }).awaitCompletion();
        } catch (InterruptedException e) {
            throw new MinimesosException("Failed to retrieve logs of container " + id, e);
        }

        return logs;
    }

    @Override
    public List<String> command(String id, String ip, String userName,String command) {
        UserHost userHost = userHostRepository.findByUserNameAndHost(userName,ip);
        UserInfo userInfo = userInfoRepository.findByUserName(userName);

        DockerConfig config = new DockerConfig();
        config.setRegistryUser(userInfo.getRegistryUser());
        config.setRegistryPass(userInfo.getRegistryPass());
        config.setRegistryMail(userInfo.getRegistryMail());
        config.setRegistryUrl(userInfo.getDockerHub());
        config.setHost("tcp://"+ userHost.getHost()  + ":" + userHost.getPort());
        HttpClient httpClient = new HttpClient();
        DockerClient dockerClient = httpClient.client(config);
        ExecCreateCmdResponse execCreateCmdResponse = dockerClient.execCreateCmd(id)
                .withAttachStdout(true)
                .withAttachStderr(true)
                .withCmd("bash", "-c", command)
                .exec();
// 执行命令
        ByteArrayOutputStream stdout = new ByteArrayOutputStream();
        ByteArrayOutputStream stderr = new ByteArrayOutputStream();
        try {
            dockerClient.execStartCmd(execCreateCmdResponse.getId()).exec(
                    new ExecStartResultCallback(stdout, stderr)).awaitCompletion();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String res = stdout.toString();
        String[] ress = res.split("\\n");
        return Arrays.asList(ress);
    }
}
