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
    public UserLogin findByUserName(String name);
    public ArrayList<UserLogin> findAllByUserName(String name);
}
