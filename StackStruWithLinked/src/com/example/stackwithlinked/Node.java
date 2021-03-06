package com.example.stackwithlinked;

/**
 * 链表节点类
 *
 * @param <T>
 */
public class Node<T> {

    Node<T> next;//当前节点的后置节点
    Node<T> prev;//当前节点的前置节点
    T element;//当前节点中存储的数据

    public Node(T element) {
        this.element = element;
    }

}
