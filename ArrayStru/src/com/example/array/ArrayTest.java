package com.example.array;

public class ArrayTest {

    public static void main(String[] args) {
        MyArray<String> array = new MyArray<>();
        array.addLast("Kotlin实战");
        array.addLast("数据结构与算法分析");
        array.addLast("TCP/IP详解");
        array.addLast("Android组件化架构");
        array.add(3, "java核心技术卷一");
        array.add(2, "漫画算法");
        array.addFirst("第一行代码");
        array.addFirst("Android Jetpack");
        array.addFirst("Android进阶之光");
        array.addFirst("Android开发艺术探索");
        array.add(1, "Effective Java");
        System.out.println(array.toString());
        System.out.println(array.size());
        System.out.println(array.length());

        System.out.println();
        String element = array.remove(1);
        System.out.println(element);
        System.out.println(array.toString());
        System.out.println(array.size());
        System.out.println(array.length());

        System.out.println();
        array.set(0, "码出高效 Java开发手册");
        System.out.println(array.toString());
        System.out.println(array.size());
        System.out.println(array.length());

        System.out.println(array.get(0));
        System.out.println(array.get(1));
        System.out.println(array.get(2));

    }

}
