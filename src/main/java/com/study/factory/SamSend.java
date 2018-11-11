/*
 * Copyright (c) 2016-2018 fafa.com.cn. All Rights Reserved.
 */

package com.study.factory;

/**
 * 这是短信的实现类
 *
 * @author Cll
 * @date 2018/10/15 16:52
 * @since 1.0.0
 */

public class SamSend implements Sender {
    @Override
    public void send() {
        System.out.println("这是短信的实现类");
    }
}
