package com.ccut.whiteshark.dockermanage.entity;

import javax.persistence.*;

/**
 * @author WhiteShark
 * @version 1.0
 * @date 2021/5/27 9:14 下午
 */
@Entity
@Table
public class ServiceControl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自增主键
    private Integer id;
    @Column
    private String name;
    @Column
    private Integer value;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public ServiceControl() {
    }

    public ServiceControl(Integer id, String name, Integer value) {
        this.id = id;
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return "ServiceControl{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
