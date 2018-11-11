/*
 * Copyright (c) 2016-2018 fafa.com.cn. All Rights Reserved.
 */

package com.repository;

import com.common.ExampleCrudMapper;
import com.entity.Book;
import com.entity.BookExample;

/**
 * 这是book表相关的接口
 *
 * @author Cll
 * @date 2018/10/11 16:28
 * @since 1.0.0
 */
public interface BookMapper
		extends ExampleCrudMapper<BookExample, Book, Integer> {
}
