/*
 * Copyright (c) 2016-2018 fafa.com.cn. All Rights Reserved.
 */

package com.study.java8;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

/**
 * 这是用于Java8的测试
 *
 * @author Cll
 * @date 2018/10/8 11:46
 * @since 1.0.0
 */

public class Animal {
    private String species;
    private int num;

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Animal() {
    }

    public Animal(int num) {
        this.num = num;
    }

    public Animal(String species) {
        this.species = species;
    }

    public Animal(String species, int num) {
        this.species = species;
        this.num = num;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "species='" + species + '\'' +
                ", num=" + num +
                '}';
    }

    public static void main(String[] args) {
//        1. 方法引用有几种？分别给出相应的列子
        //引用静态方法  类：：静态方法
        String str = "123 cool,very good";
        System.out.println("反转后的str "+useReverse(Animal::reverse, str)+"-----------------引用静态方法-------------------------");

        //对象引用实例方法  ClassName::methodName
        Animal animal[]={
             new Animal("狗",2),
             new Animal("猫",3),
             new Animal("pig",1),
     };
     Animal animals = new Animal();
     Arrays.sort(animal,animals::compareBySpecies);
     Arrays.asList(animal).forEach(a->System.out.println("对象引用实例方法的输出"+a));

     //引用构造方法Class::new
        FunctionGouZhao fun = Animal::new;
        Animal a =  fun.func(100);
        System.out.println("引用构造方法的结果是："+a.getNum());
        //引用数组构造方法
        IntFunction<int[]> makeIntArr = int[]::new;
        int aa[] = makeIntArr.apply(10);
        System.out.println("数组构造方法创建数组的长度是："+aa.length);

        //任意对象（属于同一个类）的实例方法引用
        String string[] ={"cll","As","two","for","The"};
        Arrays.sort(string,String::compareToIgnoreCase);
        for (String s : string) {
            System.out.println("任意对象（属于同一个类）的实例方法引用输出的s: "+s);
        }

        //流实现聚合
        int [] streamInt = {1,2,4,6,8,9,0};
        System.out.println("reduce实现求和"+Arrays.stream(streamInt).reduce((c, b) -> c + b).getAsInt());
        System.out.println(Arrays.stream(streamInt).sum());
        String [] strings = {"we","are","family","!"};
        System.out.println("collectors.join连接字符串： "+Arrays.stream(strings).collect(Collectors.joining(",")).replace(",", " "));

        //流操作如何求最大值？给出2种方法
        System.out.println("使用.max求数组最大值"+Arrays.stream(streamInt).max());
        System.out.println(Arrays.stream(streamInt).reduce(Integer::max));
        List<Integer> list = Arrays.asList(1,2,4,6,3,6,9);
        System.out.println("遍历list里面最大的值 "+list.stream().reduce(Integer::max).get());

        //最小值？2种方法
        System.out.println("使用。min求数组的最小值"+Arrays.stream(streamInt).min());
        System.out.println("使用排序求最小值："+Arrays.stream(streamInt).distinct().sorted().findFirst());
        System.out.println("遍历list里面最小的值 "+list.stream().reduce(Integer::min).get());

        //流转换成map
        List<Animal> l = new ArrayList<>();
        l.add(new Animal("pig",4));
        l.add(new Animal("dog",4));
        l.add(new Animal("bird",2));
        l.add(new Animal("lions",2));
        l.add(new Animal("cow",1));
        Map<String,Animal> map = l.stream().collect(Collectors.toMap(Animal::getSpecies,d->d,(k1,k2)->k1));//可以用 (k1,k2)->k1 来设置，如果有重复的key,则保留key1,舍弃key2
        System.out.println(map);
        System.out.println("------------------------下面是根据流来分组------------------------");

        //list根据字段分组
        Map<Integer,List<Animal>> groupByNum = l.stream().collect(Collectors.groupingBy(Animal::getNum));
        System.out.println(groupByNum);

        //说说你对Optional的理解

        //流操作计算集合的数量
        System.out.println("用流来计算list里面的个数是："+l.stream().count());

        //9.流操作取集合第一个对象
        System.out.println("9.流操作取集合第一个对象是： "+l.stream().findFirst());

        //10.流操作根据对象的字段排序。写一个类，然后创建一个该类的list，然后对其进行排序。
        System.out.println("---------------------------下面是根据species排序------------------");
       l.stream().sorted(Comparator.comparing(Animal::getSpecies)).distinct().forEach(System.out::println);

       //10.什么是函数接口？列举你知道的java8 常用的函数接口。
//       Predicate（断言函数，test）
        List<String> string1 = Arrays.asList("wer","she","wa","two","if");
        findSomeAboutArr(string1,s -> s.contains("e")).forEach(System.out::println);

        //Function（功能函数 ，apply）
        String stringss = "congruations,you win";
        System.out.println("//用断言函数写一个符合字符串的方法 变大写"+changeUp(stringss, s -> s.toUpperCase()));
//        Supplier （供给函数，get）
        System.out.println("---------------------------下面是根据供给函数------------------");
        getNum(10,()->(int)(Math.random()*100)).forEach(System.out::println);

        //   //Consumer<T>  (消费型接口,accept)
        hobby(100,m-> System.out.println("消费函数输出的是： "+m));

//        11.写一个2个参数没有返回值的函数接口

//        13.有一个类A，对于List<List<A>>如何通过流操作转化成List<A>?
        System.out.println("---------------------------对于List<List<A>>如何通过流操作转化成List<A>------------------");
        List<List<Animal>> lists = Arrays.asList(Arrays.asList(new Animal("pig",9),new Animal("dog",3)),
                Arrays.asList(new Animal("cow",2),new Animal("snake",1)));
        lists.stream().distinct().collect(Collectors.toList()).forEach(g->g.forEach(System.out::println));
        lists.stream().distinct().collect(Collectors.toList()).forEach(System.out::println);

        //14.有一个类A，其有一个属性String b。对于List<A>, 如何通过流操作获取所有属性b的list
        List<Animal> ll = new ArrayList<>();
        ll.add(new Animal("pig",4));
        ll.add(new Animal("dog",4));
        ll.add(new Animal("bird",2));
        ll.add(new Animal("lions",2));
        ll.add(new Animal("cow",1));
        System.out.println("如何通过流操作获取所有属性b的list"+ll.stream().map(Animal::getSpecies).collect(Collectors.toList()));

        List<List<Animal>> lll = new ArrayList<>();
        lll.add(l);
        lll.add(ll);
        System.out.println(lll.stream().flatMap(List::stream).collect(Collectors.toList()));

        //15 .对于List<A>, 如何通过流操作将所有b设置为“test”。(不用foreach)
        ll.stream().map(Animal::getSpecies).distinct().forEach(h-> System.out.println(h.replace(h,"test")));



        //16.流操作如何进行过滤
        System.out.println(ll.stream().map(Animal::getNum).filter(num -> num > 3).collect(Collectors.toList()));
    }

   //定义静态方法
    public interface StringFunc{
        String reverseStr(String str);
   }

   public static String reverse(String s){
        String result = "";
        for (int i=s.length()-1;i>=0;i--){
            result+=s.charAt(i);
        }
        return result;
   }
   public static String useReverse(StringFunc str,String s){
        return str.reverseStr(s);
   }
//引用某个对象的实例方法
public int compareBySpecies(Animal a,Animal b){
        return a.getSpecies().compareTo(b.getSpecies());
}

//引用构造方法
    interface FunctionGouZhao{
        Animal func (int num);
    }

    //定义断言函数
   public static List<String> findSomeAboutArr(List<String> list,Predicate<String> predicate){
       List<String> list1 = new ArrayList<>();
        for (String s : list) {
           if (predicate.test(s)){
               list1.add(s);
           }
       }
       return list1;
   }
   //用功能函数写一个字符串改为大写的方法
    public static String changeUp(String original, Function<String,String> fun){
        return fun.apply(original);
    }
    //用供给函数写一个需要几个整数
    public static List<Integer> getNum(int num,Supplier<Integer> sup){
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<num;i++){
            list.add(sup.get());
        }
        return list;
    }

    //Consumer<T> 消费型接口

    public static void hobby(double money, Consumer<Double> consumer){
        consumer.accept(money);
    }
//  11  写一个2个参数没有返回值的函数接口
    public interface Cost{
      void inter(int a,String b);
}
//12.写一个2个参数，1个返回值的函数接口
    public interface Abs{
        String inter(int c,List<String> list);
}
}
