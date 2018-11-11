/*
 * Copyright (c) 2016-2018 fafa.com.cn. All Rights Reserved.
 */

package com.study.factory;

/**
 * SendSmsFactory
 *
 * @author Cll
 * @date 2018/10/16 9:21
 * @since 1.0.0
 */

public class SendSmsFactory implements Provider {
    @Override
    public Sender produce() {
        return new SamSend();
    }
}
