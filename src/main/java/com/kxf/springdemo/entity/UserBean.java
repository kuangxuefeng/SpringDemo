package com.kxf.springdemo.entity;

import javax.annotation.Generated;

public class UserBean {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String name;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String pw;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String info;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getId() {
        return id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getName() {
        return name;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setName(String name) {
        this.name = name;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getPw() {
        return pw;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setPw(String pw) {
        this.pw = pw;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getInfo() {
        return info;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setInfo(String info) {
        this.info = info;
    }
}