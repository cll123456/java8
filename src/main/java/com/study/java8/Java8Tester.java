/*
 * Copyright (c) 2016-2018 fafa.com.cn. All Rights Reserved.
 */

package com.study.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 开始学习Java8
 *
 * @author Cll
 * @date 2018/9/19 14:14
 * @since 1.0.0
 */

public class Java8Tester {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("陈亮亮");
        list.add("这是怎么了");
        list.add("郭晓斌");
        list.add("我的卡");
        list.add("1234");
        list.add("9998");
        list.add("cll");
        list.add("get");
        list.add("王庆");

        List<String> list1 = new ArrayList<>();
        list1.add("airCondition");
        list1.add("computer");
        list1.add("mouse");

        Java8Tester tester = new Java8Tester();
        System.out.println("这里用的是java7");
        tester.sortUsingJava7(list);
        System.out.println(list);



        Java8Tester tester1 = new Java8Tester();
        System.out.println("这里使用的Java8");
        tester1.sortUsingJava8(list1);
        System.out.println(list1);
    }

    //使用java7排序
    private void sortUsingJava7(List<String> list) {
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
    }

    //使用Java8排序
    private void sortUsingJava8(List<String> list){
        Collections.sort(list,(s1,s2)->s1.compareTo(s2));
    }

}
