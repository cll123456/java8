/*
 * Copyright (c) 2016-2018 fafa.com.cn. All Rights Reserved.
 */

package com.study.adapter;

/**
 * 这是对象的适配器模式
 *
 * @author Cll
 * @date 2018/10/16 13:46
 * @since 1.0.0
 */

public class Wrapper implements Targetable {

    private Source source;
    public Wrapper(Source source){
        super();
        this.source = source;
    }
    @Override
    public void method1() {
     source.method1();
    }

    @Override
    public void method2() {
        System.out.println("这是对象的适配器的method2");
    }
}
