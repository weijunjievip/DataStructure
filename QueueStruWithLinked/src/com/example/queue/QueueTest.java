package com.example.queue;

public class QueueTest {

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        /*for (int i = 0; i < 10; i++) {
            queue.enQueue(i);
            System.out.println(queue);
        }
        int len = queue.size();
        for (int i = 0; i < len; i++) {
            System.out.println(queue.toString());
            System.out.println(queue.deQueue());
        }*/
//        queue.deQueue();
        System.out.println(queue.toString());
        queue.enQueue(999);
        System.out.println(queue.toString());
        System.out.println(queue.deQueue());
        System.out.println(queue.toString());
    }

}
