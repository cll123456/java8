/*
 * Copyright (c) 2016-2018 fafa.com.cn. All Rights Reserved.
 */

package com.study.factory;

/**
 * 这是发送的工厂类
 *
 * @author Cll
 * @date 2018/10/15 16:59
 * @since 1.0.0
 */
public class SenderFactory {
    public Sender senders(String type) {
        if ("mail".equals(type)) {
            return new MailSend();
        } else if ("sam".equals(type)) {
            return new SamSend();
        } else {
            System.out.println("请输入正确的格式");
            return null;
        }
    }
}
