package com.ccut.whiteshark.dockermanage.repository;

import com.ccut.whiteshark.dockermanage.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author WhiteShark
 * @version 1.0
 * @date 2021/4/3 11:13 下午
 */
@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo,Integer> {
    public UserInfo findByUserName(String name);
}
