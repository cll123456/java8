/*
 * Copyright (c) 2016-2018 fafa.com.cn. All Rights Reserved.
 */

package com.study.factory;

/**
 * 这是静态的工厂类
 *
 * @author Cll
 * @date 2018/10/16 9:06
 * @since 1.0.0
 */

public class StaticFactory {
    public static Sender Mail(){
        return new MailSend();
    }
    public static Sender Sam(){
        return new SamSend();
    }
}
