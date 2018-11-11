/*
 * Copyright (c) 2016-2018 fafa.com.cn. All Rights Reserved.
 */

package com.study.adapter;

/**
 * 这是测试适配器模式的测试类
 *
 * @author Cll
 * @date 2018/10/16 11:56
 * @since 1.0.0
 */

public class TestAdapter {

    public static void main(String[] args) {
        //类的适配器模式
        Targetable targetable = new Adapter();
        targetable.method1();
        targetable.method2();

        //对象的适配器模式
        Source source = new Source();
        Targetable targetable1 = new Wrapper(source);
        targetable1.method2();
        targetable1.method1();

        //接口的适配器模式
        Adapter1 adapter1 = new Adapter1();
        Adapter2 adapter2 = new Adapter2();
        adapter1.method1();
        adapter2.method2();
    }
}
