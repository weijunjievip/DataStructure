package com.example.stackwitharray;

/**
 * 数组作为底层数据结构实现的栈
 */
public class Stack<T> {

    private T[] array = (T[]) new Object[10];//存储栈中数据的底层数据
    private int size = 0;//记录栈中实际存储的数据量

    /**
     * 判断栈中是否有数据
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 新的数据入栈
     *
     * @param element 将新的数据添加到栈顶
     */
    public void push(T element) {
        if (size == array.length) {
            resize();
        }
        array[size] = element;
        size++;
    }

    /**
     * 栈顶数据出栈
     *
     * @return 获取栈顶数据并返回
     */
    public T pull() {
        if (isEmpty()) {
            throw new NullPointerException("栈为空，没有可以出栈的数据");
        }
        T element = array[size - 1];
        size--;
        return element;
    }

    /**
     * 当栈满时，对作为底层数据结构的数组进行扩容，将其容量扩充至原先容量的1.5倍
     */
    private void resize() {
        int len = array.length;
        T[] newArray = (T[]) new Object[len + len / 2];
        System.arraycopy(array, 0, newArray, 0, len);
        array = newArray;
    }

    /**
     * 以[(栈底) element1 -> element2 -> element3 -> ... (栈顶)]的形式返回栈中所有数据
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(getClass().getName()).append(":[(栈底) ");
        if (isEmpty()) {
            builder.append(" (栈顶)]");
        } else {
            for (int i = 0; i < size - 1; i++) {
                builder.append(array[i]).append(" -> ");
            }
            builder.append(array[size - 1]).append(" (栈顶)]");
        }
        return builder.toString();
    }
}
