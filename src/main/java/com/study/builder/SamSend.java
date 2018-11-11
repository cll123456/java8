/*
 * Copyright (c) 2016-2018 fafa.com.cn. All Rights Reserved.
 */

package com.study.builder;

/**
 * 短信发送类
 *
 * @author Cll
 * @date 2018/10/16 10:06
 * @since 1.0.0
 */

public class SamSend implements Sender {
    @Override
    public void send() {
        System.out.println("我是短信发送类");
    }
}
