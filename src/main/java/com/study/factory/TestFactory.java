/*
 * Copyright (c) 2016-2018 fafa.com.cn. All Rights Reserved.
 */

package com.study.factory;

/**
 * 这是用于测试factory的测试类
 *
 * @author Cll
 * @date 2018/10/15 16:53
 * @since 1.0.0
 */

public class TestFactory {
    public static void main(String[] args) {
        //普通的工厂模式
     SenderFactory factory = new SenderFactory();
     Sender sender = factory.senders("mail");
     sender.send();
     factory.senders("sam").send();
//多工厂
      MoreFactory moreFactory = new MoreFactory();
      moreFactory.Mail().send();
      moreFactory.Sam().send();
//静态工厂
       StaticFactory.Mail().send();
       StaticFactory.Sam().send();

//        总体来说，工厂模式适合：凡是出现了大量的产品需要创建，并且具有共同的接口时，
// 可以通过工厂方法模式进行创建。在以上的三种模式中，第一种如果传入的字符串有误，不能正确创建对象，
// 第三种相对于第二种，不需要实例化工厂类，所以，大多数情况下，我们会选用第三种——静态工厂方法模式。

        Provider provider = new SendSmsFactory();
        provider.produce().send();

    }

}
