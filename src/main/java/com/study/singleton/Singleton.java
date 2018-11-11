/*
 * Copyright (c) 2016-2018 fafa.com.cn. All Rights Reserved.
 */

package com.study.singleton;

/**
 * 这个是单列类，实例化一个类
 *
 * @author Cll
 * @date 2018/10/16 9:40
 * @since 1.0.0
 */

public class Singleton {
    public Singleton() {
    }

    public static class SingletonFactory{
        private static  Singleton instance = new Singleton();
    }

    public static Singleton getInstance(){
        return SingletonFactory.instance;
    }

    public Object ReadReslove(){
        return getInstance();
    }
}
