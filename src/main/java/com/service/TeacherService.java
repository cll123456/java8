/*
 * Copyright (c) 2016-2018 fafa.com.cn. All Rights Reserved.
 */

package com.service;

import com.repository.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 这是Teacher的接口实现层
 *
 * @author Cll
 * @date 2018/10/11 16:33
 * @since 1.0.0
 */
@Service
public class TeacherService  {
    @Autowired
    private TeacherMapper teacher;
    public int deleteByPrimaryKey(Object o) {
        return 0;
    }


    public int insert(Object record) {
        return 0;
    }


    public int insertSelective(Object record) {
        return 0;
    }


    public Object selectByPrimaryKey(Object o) {
        return null;
    }


    public int updateByPrimaryKeySelective(Object record) {
        return 0;
    }


    public int updateByPrimaryKey(Object record) {
        return 0;
    }
}
