/*
 * Copyright (c) 2016-2018 fafa.com.cn. All Rights Reserved.
 */

package com.study.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * 这是建造者模式的建造的类，把单个类集合起来统一管理
 *
 * @author Cll
 * @date 2018/10/16 10:02
 * @since 1.0.0
 */

public class Builder {
	List<Sender> list = new ArrayList<>();

	public void produceEmail(int count) {
		for (int i = 0; i < count; i++) {
			list.add(new MailSend());
		}
	}

	public void produceSam(int count) {
		for (int i = 0; i < count; i++) {
			list.add(new SamSend());
		}
	}
}
