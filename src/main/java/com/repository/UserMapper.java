/*
 * Copyright (c) 2016-2018 fafa.com.cn. All Rights Reserved.
 */

package com.repository;

import com.common.ExampleCrudMapper;
import com.entity.User;
import com.entity.UserExample;

/**
 * 这是user表相关的接口
 *
 * @author Cll
 * @date 2018/10/11 16:25
 * @since 1.0.0
 */
public interface UserMapper extends ExampleCrudMapper<UserExample, User, Long> {

}
