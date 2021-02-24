package com.example.priorityqueue;

/**
 * 最小优先队列：
 * 最小优先队列无论元素入队顺序如何，都是当前队列中最小的元素优先出队。
 * 最小优先队列的堆顶是整个堆中的最小元素。
 */
public class SmallestPriorityQueue implements PriorityQueue {

    private final int[] array;
    private int size;

    public SmallestPriorityQueue() {
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

    private void upAdjust() {
        int childIndex = size - 1;
        int parentIndex = (childIndex - 1) / 2;
        int temp = array[childIndex];
        while (childIndex > 0 && temp < array[parentIndex]) {
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

    private void downAdjust() {
        int parentIndex = 0;
        int childIndex = 1;
        int temp = array[parentIndex];
        while (childIndex < size) {
            if (childIndex + 1 < size && array[childIndex + 1] < array[childIndex]) {
                childIndex++;
            }
            if (temp <= array[childIndex]) {
                break;
            }
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = childIndex * 2 + 1;
        }
        array[parentIndex] = temp;
    }

    private boolean isEmpty() {
        return size == 0;
    }

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
