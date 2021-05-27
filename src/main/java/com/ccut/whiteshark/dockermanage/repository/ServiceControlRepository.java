package com.ccut.whiteshark.dockermanage.repository;

import com.ccut.whiteshark.dockermanage.entity.ServiceControl;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author WhiteShark
 * @version 1.0
 * @date 2021/5/27 9:28 下午
 */
public interface ServiceControlRepository extends JpaRepository<ServiceControl,Integer> {
    ServiceControl findByName(String name);
}
