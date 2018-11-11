/*
 * Copyright (c) 2016-2018 fafa.com.cn. All Rights Reserved.
 */

package com.study.adapter;

/**
 * 这是用于实现接口的适配器的类
 *
 * @author Cll
 * @date 2018/10/16 13:57
 * @since 1.0.0
 */

public class Adapter1 extends AbstractWrapper {
    @Override
    public void method1() {
        System.out.println("这是接口适配器的method1");
    }
}
