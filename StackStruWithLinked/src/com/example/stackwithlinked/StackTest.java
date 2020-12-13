package com.example.stackwithlinked;

public class StackTest {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        String[] arr = {"Effective Java", "码出高效Java开发手册", "剑指Offer名企面试官精讲典型编程题", "Java多线程编程核心技术",
                "Java并发编程的艺术", "Android开发艺术探索", "Android进阶之光", "Android Jetpack应用指南", "Java核心技术卷一", "Kotlin实战"};
        for (int i = 0; i < arr.length; i++) {
            stack.push(arr[i]);
        }
        System.out.println(stack.toString());
        int len = stack.size();
        for (int i = 0; i < len; i++) {
            System.out.println(stack.pull());
        }

        /*System.out.println(stack.toString());
        stack.push("傲慢与偏见");
        System.out.println(stack.toString());
        stack.push("茶花女");
        System.out.println(stack.toString());
        stack.push("局外人");
        System.out.println(stack.toString());
        System.out.println(stack.pull());
        System.out.println(stack.toString());
        System.out.println(stack.pull());
        System.out.println(stack.toString());
        System.out.println(stack.pull());
        System.out.println(stack.toString());
        System.out.println(stack.pull());
        System.out.println(stack.toString());*/
    }

}
