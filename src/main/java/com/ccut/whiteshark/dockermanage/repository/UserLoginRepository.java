package com.ccut.whiteshark.dockermanage.repository;

import com.ccut.whiteshark.dockermanage.entity.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * @author WhiteShark
 * @version 1.0
 * @date 2021/4/3 3:19 下午
 */
@Repository
public interface UserLoginRepository extends JpaRepository<UserLogin,Integer> {
    /**
     * 通过用户名查询用户登陆信息
     * @param name 用户名
     * @return UserLogin
     */
    public UserLogin findByUserName(String name);

    /**
     * 通过用户名查询所有用户登陆信息
     * @param name 用户名
     * @return ArrayList
     */
    public ArrayList<UserLogin> findAllByUserName(String name);
}
