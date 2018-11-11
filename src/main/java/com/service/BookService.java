/*
 * Copyright (c) 2016-2018 fafa.com.cn. All Rights Reserved.
 */

package com.service;

import com.repository.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 这是Book的接口实现层
 *
 * @author Cll
 * @date 2018/10/11 16:32
 * @since 1.0.0
 */
@Service
public class BookService {
	@Autowired
	private BookMapper book;

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
