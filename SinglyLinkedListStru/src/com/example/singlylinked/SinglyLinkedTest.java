package com.example.singlylinked;

public class SinglyLinkedTest {

    public static void main(String[] args) {
        SinglyLinked<String> linked = new SinglyLinked<>();
        /*linked.add(0, "Kotlin实战");
        linked.add(1, "数据结构与算法分析");
        linked.add(1, "TCP/IP详解");
        linked.add(0, "Android组件化架构");*/
        linked.addHead("Kotlin实战");
        linked.addHead("数据结构与算法分析");
        linked.addHead("TCP/IP详解");
        linked.addHead("Android组件化架构");
        linked.addFoot("疯狂Android讲义");
        linked.addFoot("漫画算法");
        linked.addFoot("第一行代码");
        linked.addFoot("Android Jetpack");
        linked.add(0, "Android进阶之光");
        linked.add(9, "Android开发艺术探索");
        linked.add(3, "Effective Java");
        System.out.println(linked.toString());
        System.out.println(linked.size());
        System.out.println("===================");
        /*System.out.println(linked.removeHead());
        System.out.println(linked.removeHead());
        System.out.println(linked.removeHead());
        System.out.println(linked.removeFoot());
        System.out.println(linked.removeFoot());
        System.out.println(linked.removeFoot());
        System.out.println(linked.remove(0));
        System.out.println(linked.remove(2));
        System.out.println(linked.remove(linked.size() - 1));
        System.out.println(linked.removeHead());
        System.out.println(linked.removeFoot());
        System.out.println(linked.removeFoot());
        System.out.println(linked.removeFoot());
        System.out.println(linked.toString());*/

        /*System.out.println(linked.get(0));
        System.out.println(linked.get(linked.size() - 1));
        System.out.println(linked.get(3));
        System.out.println(linked.get(2));
        System.out.println(linked.get(1));
        System.out.println(linked.get(linked.size() - 2));*/


        linked.set(0, "Java并发编程的艺术");
        linked.set(1, "Java多线程编程核心技术");
        linked.set(2, "码出高效Java开发手册");
        linked.set(linked.size() - 1, "剑指Offer");
        linked.set(linked.size() - 2, "Android自定义控件开发入门与实战");
        linked.set(linked.size() - 3, "傲慢与偏见");
        System.out.println(linked.toString());

    }

}
