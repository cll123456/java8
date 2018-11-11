/*
 * Copyright (c) 2016-2018 fafa.com.cn. All Rights Reserved.
 */

package com.study.java8;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 这是关于Lambda表达式的学习
 *
 * @author Cll
 * @date 2018/9/19 15:00
 * @since 1.0.0
 */

public class Java8Lambda {

    final static String info = "Hello,World!";

    public static void main(String[] args) {
        Java8Lambda tester = new Java8Lambda();

        //声明函数传入值 int类型
        MathOperation addition = (int a, int b) -> a + b;
        //没有声明传入值的类型
        MathOperation operation = (a, b) -> a - b;
        //返回值是大括号
        MathOperation mathOperation = (int a, int b) -> {
            return a * b;
        };
        // 没有大括号及返回语句
        MathOperation mathOperation1 = (int a, int b) -> a / b;

        System.out.println("a+b=" + tester.operative(10, 5, addition));
        System.out.println("a-b=" + tester.operative(10, 5, operation));
        System.out.println("a*b=" + tester.operative(10, 5, mathOperation));
        System.out.println("a/b=" + tester.operative(10, 5, mathOperation1));


        GreetService greetService = sayHello -> sayHello;
        GreetService greetService1 = (hello) -> hello;

        System.out.println("sayHello输出的是：" + tester.clikeMe("亮亮好帅", greetService));
        System.out.println("hello输出的是：" + tester.clikeMe("only handsome boy", greetService1));

        System.out.println(info + tester.clikeMe("Nice to meet you", greetService));

        //        greetService.sayHello("亮亮好帅");
//        greetService1.sayHello("only handsome boy");


        MathOperation1 addResults = (int a, int b) -> a + b;
        System.out.println("第二个 a+b=" + addResults.operative(10, 5));

//---------------------------------------------------------------------------

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello,创建了一个新的线程");
            }
        }).start();


        new Thread(() -> System.out.println("我也创建了一个线程")).start();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("这是最基本的Runnable");
            }
        };

        Runnable runnable1 = () -> System.out.println("这是第二个的Runnable");
        runnable.run();
        runnable1.run();

//---------------------------------------------------------------------------

        //定义一个数组，里面含有所有人的名字
        String players[] = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka", "David Ferrer",
                "Roger Federer", "Andy Murray",
                "Tomas Berdych", "Juan Martin Del Potro",
                "Richard Gasquet", "John Isner"};
        for (int i=0;i<players.length;i++){
            System.out.println("第"+(i+1)+"个"+players[i]);
        }
        Arrays.sort(players, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1.compareTo(o2));
            }
        });
        //foreach排序
        for (String x:players) {
            System.out.println("第二种方法遍历的数组"+x);
        }
       //迭代排序
        List list = Arrays.asList(players);
        list.forEach(a->{
            System.out.println("使用迭代排序的结果"+a.toString());
        });
      //使用stream遍历
        Arrays.asList(players).stream().forEach(x-> System.out.println("使用stream遍历的结果"+x.toString()));
//---------------------------------------------------------------------------
        //使用lambda表达式进行排序和遍历
        String player[] = {"亮亮", "Novak Djokovic",
                "Stanislas Wawrinka", "晓斌",
                "Roger Federer", "Andy Murray",
                "12344534", "Juan Martin Del Potro",
                "Richard Gasquet", "John Isner","0973"};
        Arrays.sort(player,(s1,s2)->s1.compareTo(s2));
        Arrays.asList(player).forEach(a-> System.out.println(a.toString()));


    }


    //就算a,b的值
    private interface MathOperation {
        int operation(int a, int b);
    }

    //返回值为字符串的接口
    private interface GreetService {
        String sayHello(String greetService);
    }

    //    直接计算a+b的值
    interface MathOperation1 {
        int operative(int a, int b);

        default int addResult(int a, int b) {
            return a + b;
        }
    }



    //让main函数直接能够调用MathOperation 从而返回相应的结果
    private int operative(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }

    //调用GreetService，返回字符串
    private String clikeMe(String a, GreetService greetService) {
        return greetService.sayHello(a);
    }
}
