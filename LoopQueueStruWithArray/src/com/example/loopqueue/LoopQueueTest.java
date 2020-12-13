package com.example.loopqueue;

public class LoopQueueTest {

    public static void main(String[] args) {
        LoopQueue<Integer> queue = new LoopQueue<>();
        try {
            for (int i = 0; i < 10; i++) {
                queue.enQueue(i);
                System.out.println(queue.toString());
            }
            System.out.println(queue.size());
            for (int i = 0; i < 6; i++) {
                System.out.println(queue.deQueue());
            }
            System.out.println(queue.toString());
            for (int i = 0; i < 3; i++) {
                queue.enQueue(i + 10);
            }
            System.out.println(queue.toString());
            System.out.println(queue.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
