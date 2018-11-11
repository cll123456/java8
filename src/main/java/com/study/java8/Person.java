/*
 * Copyright (c) 2016-2018 fafa.com.cn. All Rights Reserved.
 */

package com.study.java8;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.IntFunction;

/**
 * 学习Java8的引用
 *
 * @author Cll
 * @date 2018/9/21 8:44
 * @since 1.0.0
 */

public class Person {
    //带两个参数的构造方法
    Person(String name, LocalDate birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    //带一个参数的构造方法
    Person(LocalDate birthday) {
        this.birthday = birthday;
    }

    Person(int age) {
        this.age = age;
    }

    //没有参数的构造方法
    Person() {
        age = 0;
    }

    private String name; //姓名
    private LocalDate birthday; //出生日期
    private int age; //年龄

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                '}';
    }


    public static void main(String[] args) {
        Person person[] = new Person[]{
                new Person("003", LocalDate.of(2016, 9, 28)),
                new Person("001", LocalDate.of(2016, 2, 16)),
                new Person("002", LocalDate.of(2016, 3, 13)),
                new Person("004", LocalDate.of(2016, 12, 1)),
                new Person("cll", LocalDate.of(2018, 11, 9))};

        //使用内部匿名函数排序
        Arrays.sort(person, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getBirthday().compareTo(o2.getBirthday());
            }
        });
        for (int i = 0; i < person.length; i++) {
            System.out.println("最基本的遍历方法" + person[i]);
        }
//使用foreach遍历
        for (Person p : person) {
            System.out.println("使用foreach遍历的结果" + p);
        }
//        使用lambda表达式遍历的结果,使用迭代的方法遍历
        Arrays.asList(person).forEach(a -> System.out.println("使用lambda表达式遍历的结果" + a));

        Arrays.asList(person).stream().forEach(a -> System.out.println("使用stream遍历的结果" + a));


        //使用lambda表达式排序
        Arrays.sort(person, (p1, p2) -> p1.getBirthday().compareTo(p2.getBirthday()));
        Arrays.sort(person, (a, b) -> Person.compareByAge(a, b));

        Person person1[] = new Person[]{
                new Person("003", LocalDate.of(2016, 9, 28)),
                new Person("001", LocalDate.of(2016, 2, 16)),
                new Person("002", LocalDate.of(2016, 3, 13)),
                new Person("004", LocalDate.of(2016, 12, 1)),
                new Person("cll", LocalDate.of(2018, 11, 9))};

        Arrays.sort(person1, Person::compareByAge);
        Arrays.asList(person1).forEach(a -> System.out.println(a));
//---------------------------------------------------------------------------------------------
//        实例上的实例方法引用
        Person p = new Person();
        Arrays.sort(person1, p::compareByName);
        Arrays.asList(person1).stream().forEach(a -> System.out.println("实例上的实例方法引用" + a));
//--------------------------------------------------------------------------------
//静态方法的引用
        String str = "13344 sdf ggfdd 56788fgh ";
        //Person::reverseString 相当于实现了接口方法func()
        // 并在接口方法func()中作了Person.reverseString操作
        String outStr = userReverse(Person::reverseString, str);
        System.out.println("原来得str " + str);
        System.out.println("翻转后得outStr " + outStr);

//实例上的实例方法引用 ,字符串的反转
        String str2 = "cll is a handsome boy";
        Person person2 = new Person();
        String outStr2 = userReverse(person2::reverseStr, str2);
        System.out.println("原来得str2 " + str2);
        System.out.println("翻转后得outStr2 " + outStr2);
//-----------------------------------------------------------------------------
//找到列表中具有最大值的对象
        ArrayList<Person> a1 = new ArrayList<Person>();
        a1.add(new Person(LocalDate.of(2010, 2, 9)));
        a1.add(new Person(LocalDate.of(2000, 3, 19)));
        a1.add(new Person(LocalDate.of(2010, 12, 29)));
        a1.add(new Person(LocalDate.of(2011, 4, 23)));
        a1.add(new Person(LocalDate.of(2001, 3, 21)));
        a1.add(new Person(LocalDate.of(2010, 6, 26)));
        a1.add(new Person(LocalDate.of(2012, 4, 19)));
        a1.add(new Person(LocalDate.of(2013, 2, 21)));
//        Collections.max是求最大值的接口
        Person MaxAge = Collections.max(a1, Person::compareAge);
        System.out.println("最大的年纪为：" + MaxAge.getMaxAge(MaxAge.getBirthday()));

//        -----------------------------------------------------------------------------
        //泛型的引用
        String[] strs = {"1", "2", "3", "1", "3", "4", "5", "6", "3", "4", "3", "5", "7", "9", "7", "2", "4", "2", "1", "4", "0", "6"};
        int count = getFangXing(Person::useFangXing, strs, "1");
        System.out.println("strs里面出现1的个数是" + count);
        String[] ss = {"cca", "asse", "asse", "bbd", "ser", "sde", "wer"};
        System.out.println("该数组中，含有asse的个数是：" + getFangXing(Person::useFangXing, ss, "asse"));

//------------------------------------------------------------------------------------------------------------------
        //构造方法的引用
        functionAboutG pp = Person::new;
        Person ppp = pp.func(100);
        System.out.println("引用构造方法的age的值是：" + ppp.age);

//引用数组的构造方法
        IntFunction<int[]> arrayMake = int[]::new;
        int[] array = arrayMake.apply(10);
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        for (int i : array) {
            System.out.println("数组里面含有的值是："+array[i]);
        }

        //学习function
        IntFunction<String[]> stringArray = String[]::new;
        String[] sArray = stringArray.apply(100);
        String sss = "as,inter,to,offer,on,attend,if,off,no";
        sArray = sss.split(",");
        for (String s : sArray) {
            System.out.println("字符串是"+s + "长度为：" + s.length());
        }
    }

    //-----------------------------------------------------------------------------
    public interface StringFunc {
        //定义反转得方法接口
        String func(String n);
    }

    //字符串得反转 静态方法的引用
    public static String reverseString(String a) {
        String result = "";
        for (int i = a.length() - 1; i >= 0; i--) {
            result += a.charAt(i);
        }
        return result;
    }

    //字符串的反转 实例方法的引用
    public String reverseStr(String b) {
        String re = "";
        String ccc = "";
        char cre[] = b.toCharArray();
        for (char c : cre) {
            re += c;
        }
        for (int i = re.length() - 1; i >= 0; i--) {
            ccc += re.charAt(i);
        }
        return ccc;
    }

    public static String userReverse(StringFunc str, String a) {
        return str.func(a);
    }

    //------------------------------------------------------------------------------------------------------------------
//    计算最大年纪
    public int getMaxAge(LocalDate birthdayDate) {
        LocalDate localDate = LocalDate.now();
        int day = birthdayDate.until(localDate).getYears();
        return day;
    }


    //比较传入两个人的年纪，求最大的年纪
    public static int compareAge(Person a, Person b) {
        return a.getMaxAge(a.getBirthday()) - b.getMaxAge(b.getBirthday());
    }

    //比较人的年龄，方便等一下排序
    static int compareByAge(Person person, Person person1) {
        return person.getBirthday().compareTo(person1.getBirthday());
    }

    public int compareByName(Person a, Person b) {
        return a.getName().compareTo(b.getName());
    }


    //------------------------------------------------------------------------------------------------------------------
//    泛型的方法引用的接口
    public interface MyFunc<T> {
        int funcs(T[] ts, T v);
    }

    //输入一个字符，查找一个数组中重复出现的个数
    public static <T> int useFangXing(T[] values, T value) {
        int count = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] == value) {
                count++;
            }
        }
        return count;
    }

    //调用使用泛型的方法
    public static <T> int getFangXing(MyFunc<T> f, T[] tz, T ts) {
        return f.funcs(tz, ts);
    }

    //------------------------------------------------------------------------------------------------------------------
    ////构造方法的引用
    int getAge(int age) {
        return age;
    }

    public interface functionAboutG {
        Person func(int n);
    }

//    ------------------------------------------------------------------------------------------------------------------
  //计算字符串的长度
   public class  myFunction implements Function<String,Integer> {

    @Override
    public Integer apply(String s) {
        return s.length();
    }
}

}
