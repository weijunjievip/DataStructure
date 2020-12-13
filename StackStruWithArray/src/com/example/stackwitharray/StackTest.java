package com.example.stackwitharray;

public class StackTest {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("第一行代码");
//        stack.push("Android Jetpack应用指南");
//        stack.push("Java核心技术卷一");
        System.out.println(stack.toString());
        System.out.println(stack.pull());
        System.out.println(stack.toString());
    }

}
