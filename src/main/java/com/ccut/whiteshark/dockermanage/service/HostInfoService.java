package com.ccut.whiteshark.dockermanage.service;

import com.ccut.whiteshark.dockermanage.api.HostInfo;
import com.ccut.whiteshark.dockermanage.entity.HostEntity;
import com.ccut.whiteshark.dockermanage.entity.UserHost;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.List;

/**
 * @Author WeiPeng
 * @Date 2021/4/2 16:47
 * @Version 1.0
 */
@Service
public class HostInfoService {
    private static final Logger logger = LoggerFactory.getLogger(HostInfoService.class);
    public JSONArray getHostInfo(List<UserHost> list){
        HostInfo hostInfo = new HostInfo();
        JSONArray result = new JSONArray();
        for (int i = 0;i < list.size();i++){
            UserHost userHost = list.get(i);
            try {
                String res = hostInfo.getHostInfo(userHost.getHost(),userHost.getPort());
                JSONObject jsonObject = new JSONObject(res);
                HostEntity entity = new HostEntity();
                //CPU架构
                entity.setArchitecture(jsonObject.getString("Architecture"));
                //运行的容器数量
                entity.setContainersRunning(jsonObject.getInt("ContainersRunning"));
                //主机ID
                entity.setId(jsonObject.getString("ID"));
                DecimalFormat df = new DecimalFormat("0.00");
                //内存总数
                entity.setMemTotal(df.format(jsonObject.getInt("MemTotal")/1024));
                //CPU数量
                entity.setCpu(jsonObject.getInt("NCPU"));
                //系统时间
                entity.setSystemTime(jsonObject.getString("SystemTime").split("\\.")[0]);
                //操作系统
                entity.setOperatingSystem(jsonObject.getString("OperatingSystem"));
                //docker版本
                entity.setServerVersion(jsonObject.getString("ServerVersion"));
                JSONObject jsonObject1;
                jsonObject1 = new JSONObject(entity);
                result.put(jsonObject1);
            }catch (Exception e){
                logger.warn("主机:" + userHost.getHost() + ",请求失败");
            }

        }
        return result;
    }
}
