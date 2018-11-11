/*
 * Copyright (c) 2016-2018 fafa.com.cn. All Rights Reserved.
 */

package com.study.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 学习Java8的新功能的函数
 *
 * @author Cll
 * @date 2018/9/27 8:21
 * @since 1.0.0
 */

public class Java8Function {

    public static void main(String[] args) {
      //-------------------------声明异常--------------------------------------------------------
//       函数式接口的抽象方法可以声明 可检查异常(checked exception)。
// 在调用目标对象的这个方法时必须catch这个异常。
        ThrowException target = i ->{
            System.out.println("这个值是"+i);
        };
        try {
            target.apply(10);
        } catch (Exception e) {
            e.printStackTrace();
        }

//-------------------------调用静态方法--------------------------------------------------------
       int[] intArray = {2,3,5,88,4,9,877};
        int counts = StaticMethods.sum(intArray);
        System.out.println("输出整个数组的和"+counts);
        StaticMethods f = ()->{};

        System.out.println("输出的f的地址"+f);


//-------------------------调用静态方法--------------------------------------------------------
        DefaultMethods defaultMethods = (o) ->{};
        defaultMethods.apply(null);
        defaultMethods.sayHello("hello,word");

// Predicate<T>: 断言型接口:
        List<String> list = Arrays.asList("as","of","to","two");
       List<String> result = findSomeString(list,s->s.contains("o"));
        result.forEach( System.out::println);


        //需求用于处理字符串
      String str=  strHandle("cll is cool",s->s.toUpperCase());
        System.out.println(str);


        //Supplier<T>供给型接口:取随机数
     List<Integer> list1 = getNum(10,()->(int)(Math.random()*100));
     list1.forEach( a-> System.out.println("list1输出的值是：" + a));


        //Consumer<T> 消费型接口
        hobby(10000,m-> System.out.println("Consumer类型输出的m的值是： "+m));
    }

    @FunctionalInterface
    //声明异常的接口
    public interface ThrowException{
        void apply(int i) throws Exception;
    }
//声明静态方法的接口
    public interface StaticMethods{
        static int sum(int[] array){
            return Arrays.stream(array).reduce((a,b)->a+b).getAsInt();
        };
        void apply();
    }

    //声明默认的方法
    public interface DefaultMethods{
        void apply(Object o);

        default void sayHello(String str){
            System.out.println("我就不说："+str);
        }
    }

    //用断言函数写一个符合字符串的方法
    public static List<String> findSomeString(List<String> list,Predicate<String> predicate){
        List<String> list1 = new ArrayList<>();
        for (String s : list) {
            if (predicate.test(s)){
                list1.add(s);
            }
        }
        return list1;
    }
//需求用于处理字符串
    public static String strHandle(String string, Function<String,String> fun){
        return fun.apply(string);
    }

//Supplier<T>供给型接口:查找有几个整数
    public static List<Integer> getNum(int num, Supplier<Integer> sup){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
           list.add(sup.get()) ;
        }
        return list;
    }

    //Consumer<T> 消费型接口

    public static void hobby(double money, Consumer<Double> consumer){
        consumer.accept(money);
    }
}
