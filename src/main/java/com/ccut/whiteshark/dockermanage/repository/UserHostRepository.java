package com.ccut.whiteshark.dockermanage.repository;

import com.ccut.whiteshark.dockermanage.entity.UserHost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author WeiPeng
 * @Date 2021/4/6 15:07
 * @Version 1.0
 */
@Repository
public interface UserHostRepository extends JpaRepository<UserHost,Integer> {
    /**
     * 通过用户名查询所有逐句
     * @param name 用户名
     * @return List
     */
    public List<UserHost> findAllByUserName(String name);

    /**
     * 通过用户名和ip查询主机信息
     * @param name 用户名
     * @param host IP
     * @return Userhost
     */
    public UserHost findByUserNameAndHost(String name,String host);
}
