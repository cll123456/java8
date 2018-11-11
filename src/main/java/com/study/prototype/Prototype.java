/*
 * Copyright (c) 2016-2018 fafa.com.cn. All Rights Reserved.
 */

package com.study.prototype;

/**
 * 创建一个最基本的原型对象
 *
 * @author Cll
 * @date 2018/10/16 10:23
 * @since 1.0.0
 */

public class Prototype implements Cloneable {
	public Object clone() {
		Prototype prototype = null;
		try {
			prototype = (Prototype) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return prototype;
	}
}
