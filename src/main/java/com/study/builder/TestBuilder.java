/*
 * Copyright (c) 2016-2018 fafa.com.cn. All Rights Reserved.
 */

package com.study.builder;

import java.util.List;

/**
 * 这是用于测试建造者模式的类
 *
 * @author Cll
 * @date 2018/10/16 10:08
 * @since 1.0.0
 */

public class TestBuilder {
    public static void main(String[] args) {
        Builder builder = new Builder();
        builder.produceEmail(10);
        builder.produceSam(2);
        builder.list.forEach(a->a.send());
    }
}
