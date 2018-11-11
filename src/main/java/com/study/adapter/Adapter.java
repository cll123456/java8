/*
 * Copyright (c) 2016-2018 fafa.com.cn. All Rights Reserved.
 */

package com.study.adapter;

/**
 * 通过Adapter类，将Source的功能扩展到Targetable里
 *
 * @author Cll
 * @date 2018/10/16 11:54
 * @since 1.0.0
 */

public class Adapter extends Source implements Targetable {
    @Override
    public void method2() {
        System.out.println("这是method2的方法");
    }
}
