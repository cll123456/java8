/*
 * Copyright (c) 2016-2018 fafa.com.cn. All Rights Reserved.
 */

package com.study.java8;

import java.util.Optional;
import java.util.function.Consumer;

/**
 * 学习Java8的optional
 *
 * @author Cll
 * @date 2018/10/6 15:52
 * @since 1.0.0
 */

public class Java8Optional {


    public static void main(String[] args)  {
        //    .of传的参数不能是null
        Optional<Integer> optional = Optional.of(2);
        System.out.println(".of传的参数不能是null  " + optional);

        //Optional.ofNullable传的参数可以是null
        Optional<String> optional1 = Optional.ofNullable(null);
        System.out.println("Optional.ofNullable可以输出为null的optional  " + optional1);

        Optional<String> optional2 = Optional.ofNullable("cll");
        System.out.println("Optional.ofNullable也可以输出不为null的值  " + optional2);
//------------------------------------------------------------------------------------------------------
        //Optional.empty()：所有null包装成的Optional对象
        Optional optional3 = Optional.empty();
        Optional optional4 = Optional.ofNullable(null);
        System.out.println(optional3 == optional4);
        System.out.println(optional4 == Optional.<Integer>empty());
        Object o1 = Optional.<Integer>empty();
        Object o2 = Optional.<String>empty();
        System.out.println(o1 == o2);

//        ------------------------------------------------------------------------------------------------------
//        isPresent()：判断值是否存在
        Optional<Integer> optional5 = Optional.ofNullable(null);
        Optional<String> optional6 = Optional.ofNullable("cll is cool");
        System.out.println(optional5.isPresent() == true);
        System.out.println(optional6.isPresent() == true);
        System.out.println(optional6);

        //        ------------------------------------------------------------------------------------------------------
//        ifPresent(Consumer consumer)：如果option对象保存的值不是null，
//        则调用consumer对象，否则不调用
        optional6.ifPresent(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("the value is " + s);
            }
        });

        optional5.ifPresent(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println("the value is" + integer);
            }
        });
//        ------------------------------------------------------------------------------------------------------
//        orElse(value)：如果optional对象保存的值不是null，则返回原来的值，否则返回value
        Optional<Integer> optional7 = Optional.ofNullable(1);
        Optional<Integer> optional8 = Optional.empty();
        System.out.println(optional7.orElse(12) == 1);
        System.out.println(optional8.orElse(100) == 100);

//      ------------------------------------------------------------------------------------------------------
//      orElseGet(Supplier supplier)：功能与orElse一样，只不过orElseGet参数是一个对象
        System.out.println((optional7.orElseGet(() -> {
            return 1000;
        }) == 1) + "我是optional7");
        Optional<String> optional9 = Optional.ofNullable("wer");
        System.out.println((optional9.orElseGet(() -> {
            return "as";
        }).contentEquals("wer")) + "我是optional9");
        System.out.println((optional8.orElseGet(() -> {
            return 100;
        }) == 100) + "我是optional8");

//        ------------------------------------------------------------------------------------------------------
//        orElseThrow()：值不存在则抛出异常，存在则什么不做，有点类似Guava的Precoditions
        Optional<Integer> optional10 = Optional.ofNullable(null);
        Optional<Integer> optional11 = Optional.ofNullable(12);
        optional11.orElseThrow(IllegalStateException::new);
//        try {
//            optional10.orElseThrow(RuntimeException::new);
//        } catch (IllegalStateException e) {
//            e.printStackTrace();
//        }


//        ------------------------------------------------------------------------------------------------------
//        filter(Predicate)：判断Optional对象中保存的值是否满足Predicate，并返回新的Optional。
        Optional<Integer> optional12 = Optional.ofNullable(null);
        Optional<Integer> optional13 = Optional.ofNullable(12);
        System.out.println(optional13.filter((q) -> q == 12).get().intValue()==12);
        System.out.println(optional12.filter((a) -> a == null).isPresent());
        System.out.println(optional13.filter((a) -> a == null).isPresent());

//        ------------------------------------------------------------------------------------------------------
//        map(Function)：对Optional中保存的值进行函数运算，并返回新的Optional(可以是任何类型)
        Optional<Integer> optional14 = Optional.ofNullable(null);
        Optional<Integer> optional15 = Optional.ofNullable(12);
        Optional<String> stringOptional = optional14.map((a) -> ("key"+a));
        Optional<String> strOP= optional15.map((b) ->(b+"key"));
        System.out.println(stringOptional.isPresent());
        System.out.println(strOP.get());
//        ------------------------------------------------------------------------------------------------------
//        flatMap()：功能与map()相似，差别请看如下代码。flatMap方法与map方法类似，
//        区别在于mapping函数的返回值不同。map方法的mapping函数返回值可以是任何类型T，
//        而flatMap方法的mapping函数必须是Optional。
        Optional<Integer> optional16 = Optional.ofNullable(null);
        Optional<Integer> optional17 = Optional.ofNullable(12);
        System.out.println(optional16.flatMap((a) -> {
            return Optional.<String>ofNullable(a + "keys");
        }));
        System.out.println(optional17.flatMap((b) -> {
            return Optional.<Integer>ofNullable(b + 12);
        }));
    }
}
