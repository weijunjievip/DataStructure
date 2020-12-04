package com.example.array;

public class MyArray<T> {

    private T[] array;//用来存储数据的底层数组
    private int size;//记录数组中实际存储的数据量

    public MyArray() {
        this(10);
    }

    public MyArray(int capacity) {
        if (capacity >= 0 && capacity < 10) {
            capacity = 10;
        }
        if (capacity > 10000 || capacity < 0) {
            throw new IllegalArgumentException("疯啦？？？！！！");
        }
        //当传入一个0~10之间的初始容量时，底层默认初始化一个长度为10的数组，当大于10的时候，按用户传入的实际容量来初始化底层数组
        array = (T[]) new Object[capacity];
        size = 0;
    }

    /**
     * 向数组中指定位置添加数据
     *
     * @param index
     * @param element
     */
    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("角标不合法，当前数组中可插入数据的有效范围为：[0, " + size + "]");
        }
        //当数组中存储的数据达到数组容量上限时，对数组进行扩容
        if (size >= array.length) {
            resize();
        }
        //从index角标开始，将数组中的数据依次向后移动一个角标位
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = element;
        size++;
    }

    /**
     * 向数组头部添加数据
     *
     * @param element
     */
    public void addFirst(T element) {
        if (size >= array.length) {
            resize();
        }
        System.arraycopy(array, 0, array, 1, size);
        array[0] = element;
        size++;
    }

    /**
     * 向数组尾部添加数据
     */
    public void addLast(T element) {
        if (size >= array.length) {
            resize();
        }
        array[size] = element;
        size++;
    }

    /**
     * 删除并返回数组中指定位置上的数据
     *
     * @param index 删除该位置上的数据
     */
    public T remove(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("角标不合法，当前数组中可删除数据的有效范围为：[0, " + (size - 1) + "]");
        }
        T element = array[index];
        if (size - index >= 0) System.arraycopy(array, index + 1, array, index, size - index);
        size--;
        return element;
    }

    /**
     * 修改数组中指定位置上的数据
     *
     * @param index   修改该位置上的数据
     * @param element 用来替换数组中的旧数据
     */
    public void set(int index, T element) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("角标不合法，当前数组中可修改数组中数据的有效范围为：[0, " + (size - 1) + "]");
        }
        array[index] = element;
    }

    /**
     * 获取数组中指定位置上的数据并返回
     *
     * @param index 将该位置上的数据返回
     * @return 返回指定位置上的数据，如果指定的角标不合法，则抛出异常
     */
    public T get(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("角标不合法，当前数组中可获取数组中数据的有效范围为：[0, " + (size - 1) + "]");
        }
        return array[index];
    }

    /**
     * 当数组容量不足以装载用户存储的数据时，对底层数据进行扩容，将数组容量扩充至原数组长度的1.5倍
     */
    private void resize() {
        int length = array.length;
        T[] newArray = (T[]) new Object[length + length / 2];
        System.arraycopy(array, 0, newArray, 0, length);
        array = newArray;
    }

    /**
     * 获取数组中实际存储的数据量
     */
    public int size() {
        return size;
    }

    /**
     * 获取底层数组的实际容量
     *
     * @return
     */
    public int length() {
        return array.length;
    }

    /**
     * 以ClassName:[element1, element2, element3, ...]这种方式返回数组中存储的所有数据
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(getClass().getSimpleName()).append(":[");
        for (int i = 0; i < size - 1; i++) {
            builder.append(array[i]).append(", ");
        }
        builder.append(array[size - 1]).append("]");
        return builder.toString();
    }
}
