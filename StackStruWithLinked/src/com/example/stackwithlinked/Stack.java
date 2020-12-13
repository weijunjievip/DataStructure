package com.example.stackwithlinked;

/**
 * 双向链表作为底层数据结构实现的栈
 * <p>
 * 当使用链表作为栈的底层数据结构时，使用双向链表要比使用单向链表更为妥帖。因为当栈顶元素出栈，
 * 也就是需要获取底层链表的尾节点时还需要查找到当前尾节点的前置节点。如果使用单向链表的话，
 * 寻找尾节点的前置节点需要从前往后依次遍历，此时的时间复杂度退化为O(n)。而使用双向链表的话，
 * 可以直接通过当前尾节点的prev指针获取到当前尾节点的前置节点，时间复杂度进化为O(1)常量。
 * 所以，比起单向链表，双向链表更适合作为实现栈的底层数据结构。
 */
public class Stack<T> {

    private int size = 0;//记录栈中实际存储的数据量
    private Node<T> head;//底层链表的头节点
    private Node<T> foot;//底层链表的尾节点

    /**
     * 判断栈中是否有数据
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 将新数据添加到栈顶
     *
     * @param element
     */
    public void push(T element) {
        Node<T> insertNode = new Node<>(element);
        if (isEmpty()) {
            head = foot = insertNode;
            head.next = foot.prev = insertNode;
            head.prev = null;
        } else {
            Node<T> lastNode = foot;
            foot.next = insertNode;
            foot = insertNode;
            foot.prev = lastNode;
        }
        foot.next = null;
        size++;
    }

    /**
     * 栈顶数据出栈
     *
     * @return 获取并返回栈顶数据
     */
    public T pull() {
        if (isEmpty()) {
            throw new NullPointerException("栈为空，没有数据可以被出战");
        }
        T element;
        if (size == 1) {
            element = head.element;
            head = foot = null;
        } else {
            element = foot.element;
            foot = foot.prev;
            foot.next = null;
        }
        size--;
        return element;
    }

    /**
     * 获取栈中实际存储的数据量
     *
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * 以[(栈底) element1 ~ element2 ~ element3 ~ ... (栈顶)]的形式返回栈中的所有数据
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[(栈底) ");
        if (isEmpty()) {
            builder.append(" (栈顶)]");
        } else {
            Node<T> node = head;
            do {
                builder.append(node.element);
                if (node.next != null) {
                    builder.append(" ~ ");
                } else {
                    builder.append(" (栈顶)]");
                }
                node = node.next;
            } while (node != null);
        }
        return builder.toString();
    }
}
