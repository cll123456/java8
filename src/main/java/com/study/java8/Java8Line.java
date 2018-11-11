/*
 * Copyright (c) 2016-2018 fafa.com.cn. All Rights Reserved.
 */

package com.study.java8;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 学习Java8的线程和线程并发器
 *
 * @author Cll
 * @date 2018/10/8 10:14
 * @since 1.0.0
 */

public class Java8Line {
    public static void main(String[] args) {
//        简单的单个线程，会重复的开启
        Runnable task = () ->{
            String threadName = Thread.currentThread().getName();//获取当前执行这段代码的线程的名字
            System.out.println("Hello ,"+threadName);
        };
        task.run();
        Thread thread = new Thread(task);
        thread.start();
        System.out.println("Done ------------------------ ");

        Runnable test = () ->{
        String name = Thread.currentThread().getName();
        System.out.println("before " + name);
            try {
                TimeUnit.SECONDS.sleep(5);   //TimeUnit在处理单位时间时一个有用的枚举类
                System.out.println("after "+ name);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread thread1 = new Thread(test);
        thread1.start();



//        ExecutorService来创建线程池
//        Executors类提供了便利的工厂方法来创建不同类型的 executor services。
//        在这个示例中我们使用了一个单线程线程池的 executor。
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(() ->{
          String name = Thread.currentThread().getName();
            System.out.println("这是executor创建的  " + name);
        });
//        executor要手动自己关闭线程
        executorService.shutdown();
        System.out.println("I will shutdown the executor");
        try {
//            awaitTermination等待超出时间后关闭
            executorService.awaitTermination(100,TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.err.println("tasks interrupted");
        }finally {
            if (!executorService.isTerminated()){
                System.out.println("cancel non-finished tasks");
            }
            executorService.shutdownNow();
            System.out.println("success shutdown the tasks");
        }

    }

}
