package com.example.array;

public class MyArray {

    /*
    初始化一个长度为10的数组
     */
    private static final int[] array = new int[10];
    private int size = 0;//记录数组中实际存储的数据量

    /**
     * 向数组中添加元素
     */
    public static void add(int element) {

    }

    /**
     * 删除数组中指定位置上的数据
     *
     * @param index 删除该位置上的数据
     */
    public static void remove(int index) {

    }

    /**
     * 修改数组中指定位置上的数据
     *
     * @param index   修改该位置上的数据
     * @param element 用来替换数组中的旧数据
     */
    public static void set(int index, int element) {

    }

    /**
     * 获取数组中指定位置上的数据并返回
     *
     * @param index 将该位置上的数据返回
     * @return 返回指定位置上的数据，如果指定的角标不合法，则抛出异常
     */
    public static int get(int index) {
        return -1;
    }

    /**
     * 当数组容量不足以装载用户存储的数据时，对底层数据进行扩容，将数组容量扩充至原数组长度的1.5倍
     */
    private static void resize() {

    }

    /**
     * 获取数组中实际存储的数据量
     */
    public static int size() {
        return size();
    }

}
