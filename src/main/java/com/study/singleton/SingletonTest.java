/*
 * Copyright (c) 2016-2018 fafa.com.cn. All Rights Reserved.
 */

package com.study.singleton;

import java.util.Vector;

/**
 * 这是采用影子实例
 *
 * @author Cll
 * @date 2018/10/16 9:47
 * @since 1.0.0
 */

public class SingletonTest {

	private static SingletonTest instance = null;
	private Vector properties = null;// Vector 可实现自动增长的对象数组

	public Vector getProperties() {
		return properties;
	}

	public SingletonTest() {
	}

	private static synchronized void syncInit() {
		if (instance == null) {
			instance = new SingletonTest();
		}
	}

	public static SingletonTest getInstance() {
		if (instance == null) {
			syncInit();
		}
		return instance;
	}

	public void updateProperties(){
	    SingletonTest shadow = new SingletonTest();
	    properties = shadow.getProperties();
    }


//    1、单例模式理解起来简单，但是具体实现起来还是有一定的难度。
//    2、synchronized关键字锁定的是对象，在用的时候，一定要在恰当的地方使用
// （注意需要使用锁的对象和过程，可能有的时候并不是整个对象及整个过程都需要锁）。
}
