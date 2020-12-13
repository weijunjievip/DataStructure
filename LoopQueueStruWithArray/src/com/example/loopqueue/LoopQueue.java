package com.example.loopqueue;

/**
 * 数组作为底层数据结构实现的循环队列
 * <p>
 * 数组作为底层数据结构实现普通队列时，有极大的局限性，因为数组占用的是一片连续的内存空间，而且在不进行扩容的前提下，数组的容量是恒定的，
 * 因此当队头数据出队后，队头左边的空间就失去了作用，这也就导致了队列的容量会变得越来越小。而那些失去作用的空间也不能被其他程序使用。
 * 所以，如果要使用数组作为底层数据结构来实现队列时，最好将队列实现为循环队列，这样就可以维持队列容量的恒定。
 */
public class LoopQueue<T> {

    private final T[] array;
    private int head = 0;
    private int foot = 0;

    public LoopQueue() {
        this(10);//用户未指定队列容量的前提下，初始化一个容量为10的队列。
    }


    public LoopQueue(int capacity) {
        if (capacity < 0 || capacity > 100000) {
            throw new IllegalArgumentException("疯啦？？？！！！");
        }
        array = (T[]) new Object[capacity + 1];//根据用户指定的容量来初始化队列的容量，因为队尾指针指向的位置永远空出一位，所以队列的实际容量需要加1，才能达到用户指定的真正的初始容量
    }

    /**
     * 判断队列中是否有数据
     *
     * @return
     */
    private boolean isEmpty() {
        return head == foot;
    }

    /**
     * 判断队列是否已满
     *
     * @return
     */
    private boolean isFull() {
        return (foot + 1) % array.length == head;
    }

    /**
     * 将新数据添加到队尾
     *
     * @param element
     * @throws Exception
     */
    public void enQueue(T element) throws Exception {
        if (isEmpty()) {
            array[head] = element;
        } else {
            if (isFull()) {
                throw new Exception("队列已满，新数据无法入队");
            }
            array[foot] = element;
        }
        foot = (foot + 1) % array.length;
    }

    /**
     * 队头数据出队
     *
     * @return 获取并返回队头数据
     */
    public T deQueue() {
        if (isEmpty()) {
            throw new NullPointerException("队列为空，没有数据可以被出队");
        }
        T element = array[head];
        head = (head + 1) % array.length;
        return element;
    }

    /**
     * 获取队列中实际存储的数据量
     *
     * @return
     */
    public int size() {
        if (head < foot) {
            return foot;
        } else {
            return array.length - head + foot;
        }
    }

    /**
     * 以 [(队头) element1 element2 element3 ... (队尾)] 的形式返回队列中的所有数据
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[(队头) ");
        for (int i = head; i != foot; i = (i + 1) % array.length) {
            builder.append(array[i]).append(" ");
        }
        builder.append("(队尾)]");
        return builder.toString();
    }
}
