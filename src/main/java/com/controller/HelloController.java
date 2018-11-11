/*
 * Copyright (c) 2016-2018 fafa.com.cn. All Rights Reserved.
 */

package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 一个简单的helloController
 *
 * @author Cll
 * @date 2018/10/6 15:14
 * @since 1.0.0
 */

//@RestController
@Controller
@RequestMapping("/HelloController")
public class HelloController {
    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }
}
