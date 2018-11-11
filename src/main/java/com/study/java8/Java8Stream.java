/*
 * Copyright (c) 2016-2018 fafa.com.cn. All Rights Reserved.
 */

package com.study.java8;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * 学习Java8的stream流
 *
 * @author Cll
 * @date 2018/9/29 9:28
 * @since 1.0.0
 */
//生成流
public class Java8Stream {
    public static void main(String[] args) {

//        stream() − 为集合创建串行流。
//        parallelStream() − 为集合创建并行流。

        List<String> strings = Arrays.asList("wer", "as", "of", "two", "ver", "");
        List<String> filter = strings.stream().filter(s -> s.contains("o")).collect(Collectors.toList());
        filter.forEach(s -> System.out.println(s));
//   Stream 提供了新的方法 'forEach' 来迭代流中的每个数据。以下代码片段使用 forEach 输出了10个随机数：
        Random random = new Random();
        random.ints(3, 100).limit(3).forEach(System.out::println);

        //map 方法用于映射每个元素到对应的结果,以下代码片段使用 map 输出了元素对应的平方数：
        List<Integer> numbers = Arrays.asList(13, 4, 2, 5, 2, 6, 2);
        List<Integer> list = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
        list.forEach(a -> System.out.println(" List<Integer>的值是" + a));

//        filter
//filter 方法用于通过设置的条件过滤出元素。以下代码片段使用 filter 方法过滤出空字符串：
        List<String> string = Arrays.asList("wer","","as","","cll");
        long count = string.stream().filter(s->s.isEmpty()).count();
        System.out.println("string包含空的字符串的个数是："+count);
//limit
//limit 方法用于获取指定数量的流。 以下代码片段使用 limit 方法打印出 10 条数据：
     Random randoms = new Random();
     random.ints(1,40).limit(3).distinct().forEachOrdered(System.out::println);


//        sorted
//        sorted 方法用于对流进行排序。以下代码片段使用 sorted 方法对输出的 10 个随机数进行排序：

        Random randomss = new Random();
        randomss.ints(1,20).limit(3).sorted().forEach(System.out::println);


//        Collectors
//        Collectors 类实现了很多归约操作，例如将流转换成集合和聚合元素。Collectors 可用于返回列表或字符串：
        List<String> singleString = Arrays.asList("cll","will","get","an","apple","");
        List<String> str=  singleString.stream().filter(a->!a.isEmpty()).collect(Collectors.toList());
        System.out.println("singleString的不为空的单个字符串有"+str);
        System.out.println(str.stream().filter(b -> !b.isEmpty()).collect(Collectors.joining(",")).replace(","," "));

//        统计
//        另外，一些产生统计结果的收集器也非常有用。它们主要用于int、double、long等基本类型上，它们可以用来产生类似如下的统计结果。

        List<Integer> integers = Arrays.asList(1,3,56,3,5,62,63,6,2,6,2);
        IntSummaryStatistics statistics = integers.stream().mapToInt((x) ->x).summaryStatistics();
        System.out.println("平均值"+statistics.getAverage());
        System.out.println("个数"+statistics.getCount());
        System.out.println("最大值"+statistics.getMax());
        System.out.println("总和"+statistics.getSum());

    }


}
