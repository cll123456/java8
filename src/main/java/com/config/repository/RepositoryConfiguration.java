/*
 * Copyright (c) 2016-2018 fafa.com.cn. All Rights Reserved.
 */

package com.config.repository;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Cll
 * @date 2018/10/12 10:20
 * @since 1.0.0
 */
@Configuration
@MapperScan("com.repository")
public class RepositoryConfiguration {
}
