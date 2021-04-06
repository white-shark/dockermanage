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
    public List<UserHost> findAllByUserName(String name);
}
