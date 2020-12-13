package com.example.queue;

/**
 * 单向链表作为底层数据结构实现的队列
 */
public class Queue<T> {

    private Node<T> head;//链表头节点
    private Node<T> foot;//链表尾节点
    private int size;//队列中实际存储的数据量

    /**
     * 判断队列中是否有数据
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 将新数据添加到队尾
     *
     * @param element
     */
    public void enQueue(T element) {
        Node<T> insertNode = new Node<>(element);
        if (isEmpty()) {
            head = foot = insertNode;
            head.next = foot;
        } else {
            foot.next = insertNode;
            foot = insertNode;
        }
        foot.next = null;
        size++;
    }

    /**
     * 队头数据出队
     *
     * @return 获取并返回队头数据
     */
    public T deQueue() {
        if (isEmpty()) {
            throw new NullPointerException("队列为空，没有数据可以被出栈");
        }
        T element = head.element;
        head = head.next;
        size--;
        return element;
    }

    /**
     * 获取队列中实际存储的数据量
     *
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * 以 className:[(队头) element1 <~ element2 <~ element3 <~ ... (队尾)] 的形式返回队列中的所有数据
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(getClass().getSimpleName()).append(":[(队头) ");
        if (isEmpty()) {
            builder.append(" (队尾)]");
        } else {
            Node<T> node = head;
            do {
                builder.append(node.element);
                if (null == node.next) {
                    builder.append(" (队尾)]");
                } else {
                    builder.append(" <~ ");
                }
                node = node.next;
            } while (node != null);
        }
        return builder.toString();
    }
}
