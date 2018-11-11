/*
 * Copyright (c) 2016-2018 fafa.com.cn. All Rights Reserved.
 */

package com.study.factory;

/**
 * 这是多工厂的类
 *
 * @author Cll
 * @date 2018/10/15 17:10
 * @since 1.0.0
 */

public class MoreFactory {
    public Sender Mail(){
        return new MailSend();
    }
    public Sender Sam(){
        return new SamSend();
    }
}
