package com.nowcoder.community.service;

import com.nowcoder.community.dao.AlapherDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
//@Scope("prototype")
public class AlapherService {

    public AlapherService () {
        System.out.println("构造器");
    }

    @PostConstruct
    public void init() {
        System.out.println("init");
    }

    @Autowired
    public AlapherDao alapherDao;


    public String find() {
        return alapherDao.select();
    }

    @PreDestroy
    public void destory() {
        System.out.println("destory");
    }
}
