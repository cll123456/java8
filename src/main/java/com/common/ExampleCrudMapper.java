/*
 * Copyright (c) 2016-2018 fafa.com.cn. All Rights Reserved.
 */

package com.common;

import java.util.List;

/**
 * 这是测试生成的example的接口
 *
 * @author Cll
 * @date 2018/10/11 16:20
 * @since 1.0.0
 */

public interface ExampleCrudMapper<P,T,ID> extends CrudMapper<T,ID> {

    List<T> selectByExample(P params);

    List<T> selectByExampleWithBLOBs(P params);

    Long countByExample(P params);

    void deleteByExample(P params);
}
