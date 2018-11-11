/*
 * Copyright (c) 2016-2018 fafa.com.cn. All Rights Reserved.
 */

package com.repository;

import com.common.ExampleCrudMapper;
import com.entity.Teacher;
import com.entity.TeacherExample;

/**
 * 这是teacher表的相关的实体
 *
 * @author Cll
 * @date 2018/10/11 16:29
 * @since 1.0.0
 */
public interface TeacherMapper
		extends ExampleCrudMapper<TeacherExample, Teacher, Integer> {

}
