/*
 * Copyright (c) 2016-2018 fafa.com.cn. All Rights Reserved.
 */

package com.service;

import com.entity.User;
import com.entity.UserExample;
import com.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 这是User的接口实现层
 *
 * @author Cll
 * @date 2018/10/11 16:31
 * @since 1.0.0
 */
@Service
public class UserService  {
    @Autowired
    private UserMapper user;
    public int deleteByPrimaryKey(Long userId) {
        return user.deleteByPrimaryKey(userId);
    }


    public int insert(User users) {
        return user.insert(users);
    }


    public int insertSelective(User record) {
        return user.insertSelective(record);
    }


    public Object selectByPrimaryKey(Long userId) {
        return user.selectByPrimaryKey(userId);
    }


    public int updateByPrimaryKeySelective(User users) {
        return user.updateByPrimaryKeySelective(users);
    }


    public int updateByPrimaryKey(User users) {
        return user.updateByPrimaryKey(users);
    }

   public List<User> selectByExample(UserExample params){
        return user.selectByExample(params);
   }

    public   List<User> selectByExampleWithBLOBs(UserExample params){
        return user.selectByExampleWithBLOBs(params);
    }

    public  Long countByExample(UserExample params){
      return user.countByExample(params);
    }

    public  void deleteByExample(UserExample params){
         user.deleteByExample(params);
    }
}
