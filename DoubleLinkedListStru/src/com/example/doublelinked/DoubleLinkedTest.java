package com.example.doublelinked;

public class DoubleLinkedTest {

    public static void main(String[] args) {
        DoubleLinked<Integer> linked = new DoubleLinked<>();
        /*linked.addFoot(1);
        linked.add(linked.size(), 8);
        linked.add(1, 9);
        linked.addFoot(3);
        linked.addHead(2);
        linked.add(0, 6);
        System.out.println(linked.toString());
        linked.removeFoot();
        System.out.println(linked.toString());
        linked.removeHead();
        System.out.println(linked.toString());
        linked.remove(2);
        System.out.println(linked.toString());
        linked.remove(0);
        System.out.println(linked.toString());
        linked.remove(1);
        System.out.println(linked.toString());
        linked.remove(0);
        System.out.println(linked.toString());
        linked.remove(0);
        System.out.println(linked.toString());

        linked.addHead(0);
        linked.addHead(8);
        System.out.println(linked.toString());
        linked.remove(1);
        System.out.println(linked.toString());
        linked.remove(0);
        System.out.println(linked.toString());*/

        linked.addFoot(2);
        linked.addFoot(3);
        linked.addFoot(4);
        linked.addHead(5);
        linked.addHead(6);
        linked.addHead(7);
        linked.addHead(8);
        linked.add(1, 9);
        linked.add(0, 99);
        linked.add(linked.size() - 1, 9);
        System.out.println(linked.toString());

        linked.add(0, 1);
        linked.addHead(2);
        linked.addFoot(3);
        System.out.println(linked.toString());
        System.out.println(linked.get(0));
        linked.set(0, 2);
        System.out.println(linked.toString());
        linked.set(6, 100);
        linked.set(10, 999);
        System.out.println(linked.toString());
        linked.remove(7);
        System.out.println(linked.toString());
        linked.remove(4);
        System.out.println(linked.toString());
        linked.set(6, 100);
        linked.set(10, 999);
        System.out.println(linked.toString());
    }

}
