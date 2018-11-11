/*
 * Copyright (c) 2016-2018 fafa.com.cn. All Rights Reserved.
 */

package com.study.java8;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 初级学习nashorn
 *
 * @author Cll
 * @date 2018/10/7 9:21
 * @since 1.0.0
 */

public class Java8Nashorn {
    public static void main(String[] args) {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        try {
            engine.eval("print('hello,nashorn');");
        } catch (ScriptException e) {
            e.printStackTrace();
        }

        try {
            engine.eval(new FileReader("src/main/resources/js/script.js"));
            Invocable invocable = (Invocable) engine;
            Object result = invocable.invokeFunction("fun1","Cll is cool");
            System.out.println("这是调用script.js的fun1： " + result);
            System.out.println(result.getClass());
            invocable.invokeFunction("fun2",new Date());
            invocable.invokeFunction("fun2", LocalDateTime.now());
            invocable.invokeFunction("fun2",new Person());
        } catch (ScriptException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

     static String fun(String name){
        System.out.format("Hi,here are java place ,%s", name);
        return "greeting ,here are java place";
    }
}
