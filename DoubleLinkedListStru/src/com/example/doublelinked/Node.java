package com.example.doublelinked;

/**
 * 双向链表节点类
 *
 * @param <T>
 */
public class Node<T> {

    public T element;//当前节点中实际存储的数据
    public Node<T> prev;//记录当前节点的前置节点
    public Node<T> next;//记录当前节点的后置节点

    public Node(T element) {
        this.element = element;
    }

}
