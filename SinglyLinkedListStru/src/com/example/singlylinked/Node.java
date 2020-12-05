package com.example.singlylinked;

/**
 * 单链表节点类
 */
public class Node<T> {

    public T element;//节点中实际存储的数据
    public Node<T> next;//记录当前节点的下一个节点的指针

    public Node(T element) {
        this.element = element;
    }

}

