package com.example.priorityqueue;

/**
 * 最大优先队列：
 * 最大优先队列无论元素的入队顺序如何，都是当前队列中最大的元素优先出队。
 * 最大优先队列的堆顶是整个堆中的最大元素。
 */
public class MaximalPriorityQueue implements PriorityQueue {

    private final int[] array;
    private int size;

    public MaximalPriorityQueue() {
        array = new int[32];
        size = 0;
    }

    @Override
    public void enQueue(int key) {
        if (isFull()) {
            throw new RuntimeException("队列已满，元素无法入队。");
        }
        array[size] = key;
        size++;
        upAdjust();
    }

    /**
     * 新入队的元素（也就是二叉堆中的最后一个叶子节点）做上浮调整，直至上浮到适合自己的位置。
     */
    private void upAdjust() {
        int childIndex = size - 1;
        int parentIndex = (childIndex - 1) / 2;
        int temp = array[childIndex];
        while (childIndex > 0 && temp > array[parentIndex]) {
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = (parentIndex - 1) / 2;
        }
        array[childIndex] = temp;
    }

    @Override
    public int deQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列已空，没有元素可以出队。");
        }
        int head = array[0];
        array[0] = array[size - 1];
        size--;
        downAdjust();
        return head;
    }

    /**
     * 二叉堆的堆顶元素做下沉调整，直至下沉到适合自己的位置
     */
    private void downAdjust() {
        int parentIndex = 0;
        int childIndex = 1;
        int temp = array[parentIndex];
        while (childIndex < size) {
            if (childIndex + 1 < size && array[childIndex + 1] > array[childIndex]) {
                childIndex++;
            }
            if (temp >= array[childIndex]) {
                break;
            }
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = childIndex * 2 + 1;
        }
        array[parentIndex] = temp;
    }

    /**
     * 判断队列是否为空
     *
     * @return 队列为空返回true，否则返回false
     */
    private boolean isEmpty() {
        return size == 0;
    }

    /**
     * 判断队列是否已满
     *
     * @return 当队列中无法再存储数据时返回true，否则返回false
     */
    private boolean isFull() {
        return size == array.length;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[ ]";
        }
        StringBuilder builder = new StringBuilder();
        builder.append("[ ");
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                builder.append(", ");
            }
            builder.append(array[i]);
        }
        builder.append(" ]");
        return builder.toString();
    }
}
