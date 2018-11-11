/*
 * Copyright (c) 2016-2018 fafa.com.cn. All Rights Reserved.
 */

package com.common;

/**
 * 基本的增删改查操作的共有的接口
 *
 * @author Cll
 * @date 2018/10/11 16:17
 * @since 1.0.0
 */

public interface CrudMapper<T, ID> {
    int deleteByPrimaryKey(ID id);

    int insert(T record);

    int insertSelective(T record);

    T selectByPrimaryKey(ID id);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);

}
