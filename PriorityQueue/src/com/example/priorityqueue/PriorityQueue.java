package com.example.priorityqueue;

/**
 * 优先队列：
 * 优先队列主要包括最大优先队列和最小优先队列两种。优先队列不同于普通队列，
 * 普通队列遵循先进先出的原则，而优先队列则不同。
 * 最大优先队列无论入队顺序如何，都是当前队列中最大的元素优先出队。
 * 最小优先队列无论入队顺序如何，都是当前队列中最小的元素优先出队。
 */
public interface PriorityQueue {

    /**
     * 新元素key入队
     *
     * @param key 要入对的元素
     */
    void enQueue(int key);

    /**
     * 出队
     *
     * @return 获取并返回优先队列中的最大/最小元素
     */
    int deQueue();

}
