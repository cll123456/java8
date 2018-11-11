/*
 * Copyright (c) 2016-2018 fafa.com.cn. All Rights Reserved.
 */

package com.study.builder;

/**
 * 邮件发送的类
 *
 * @author Cll
 * @date 2018/10/16 10:05
 * @since 1.0.0
 */

public class MailSend implements Sender {
    @Override
    public void send() {
        System.out.println("我是邮件发送类");
    }
}
