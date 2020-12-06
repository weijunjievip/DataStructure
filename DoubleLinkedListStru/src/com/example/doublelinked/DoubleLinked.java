package com.example.doublelinked;

/**
 * 双向链表
 *
 * @param <T>
 */
public class DoubleLinked<T> {

    private int size = 0;//记录链表中实际存储的数据量
    private Node<T> head;//链表头节点
    private Node<T> foot;//链表尾节点

    /**
     * 判断链表是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向链表的头部插入节点
     *
     * @param element
     */
    public void addHead(T element) {
        Node<T> insertNode = new Node<>(element);
        if (isEmpty()) {//如果是空链表，则让头节点和尾节点都指向新插入的节点，让后让头节点的前置节点和尾节点的后置节点都指向空
            head = foot = insertNode;
            head.prev = foot.next = null;
        } else {
            head.prev = insertNode;
            insertNode.next = head;
            head = insertNode;
            head.prev = null;
        }
        size++;
    }

    /**
     * 向链表的尾部插入节点
     *
     * @param element
     */
    public void addFoot(T element) {
        Node<T> insertNode = new Node<>(element);
        if (isEmpty()) {
            head = foot = insertNode;
            head.prev = foot.next = null;
        } else {
            foot.next = insertNode;
            insertNode.prev = foot;
            insertNode.next = null;
            foot = insertNode;
        }
        size++;
    }

    /**
     * 向链表中插入节点
     *
     * @param index
     * @param element
     */
    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("角标不合法，当前链表中可插入数据的有效范围为：[0~" + size + "]");
        }
        if (isEmpty() || index == 0) {//向链表头部插入节点
            addHead(element);
        } else if (index == size) {//向链表尾部插入节点
            addFoot(element);
        } else {//向链表中间位置插入节点
            Node<T> insertNode = new Node<>(element);//准备插入的新节点
            Node<T> prevNode = getIndexPrevNode(index);//index位置的前置节点
            Node<T> nextNode = prevNode.next;//index位置的后置节点
            prevNode.next = insertNode;
            insertNode.next = nextNode;
            insertNode.prev = prevNode;
            nextNode.prev = insertNode;
            size++;
        }
    }

    /**
     * 移除链表的头节点，并返回头节点中的数据
     *
     * @return
     */
    public T removeHead() {
        if (isEmpty()) {
            throw new NullPointerException("当前链表为空，没有数据可以被移除");
        }
        Node<T> node = head;
        if (size == 1) {
            head = foot = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
        return node.element;
    }

    /**
     * 移除链表的尾节点，并返回尾节点中的数据
     *
     * @return
     */
    public T removeFoot() {
        if (isEmpty()) {
            throw new NullPointerException("当前链表为空，没有数据可以被移除");
        }
        Node<T> node = foot;
        if (size == 1) {
            head = foot = null;
        } else {
            foot = foot.prev;
            foot.next = null;
        }
        size--;
        return node.element;
    }

    /**
     * 移除链表中指定位置上的节点，并返回该节点中的数据
     *
     * @param index
     * @return
     */
    public T remove(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("角标不合法，当前链表中可以移除数据的角标范围为：[0~" + (size - 1) + "]");
        }
        if (isEmpty()) {
            throw new NullPointerException("当前链表为空，没有数据可以被移除");
        }
        if (index == 0) {//移除链表头节点
            return removeHead();
        } else if (index == size - 1) {//移除链表尾节点
            return removeFoot();
        } else {//移除链表中间节点
            Node<T> prevNode = getIndexPrevNode(index);
            Node<T> removeNode = prevNode.next;
            prevNode.next = removeNode.next;
            removeNode.next.prev = prevNode;
            size--;
            return removeNode.element;
        }
    }

    /**
     * 修改链表中指定位置上的节点数据
     *
     * @param index
     * @param element
     */
    public void set(int index, T element) {
        if (index < 0 || index > size - 1 || isEmpty()) {
            throw new IndexOutOfBoundsException("角标不合法，当前链表中可以修改数据的角标范围为：[0~" + (size - 1) + "]");
        }
        if (size == 1 || index == 0) {
            head.element = element;
        } else {
            getIndexPrevNode(index).next.element = element;
        }
    }

    /**
     * 获取链表中指定位置上的节点数据
     *
     * @param index
     * @return
     */
    public T get(int index) {
        if (index < 0 || index > size - 1 || isEmpty()) {
            throw new IndexOutOfBoundsException("角标不合法，当前链表中可以获取数据的角标范围为：[0~" + (size - 1) + "]");
        }
        if (size == 1 || index == 0) {
            return head.element;
        }
        return getIndexPrevNode(index).next.element;
    }

    /**
     * 获取链表中实际存储的节点数量
     *
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * 获取链表中指定位置的前置节点
     *
     * @param index
     * @return
     */
    private Node<T> getIndexPrevNode(int index) {
        if (size == 1) {//如果链表中只有一个头节点，则直接返回头节点
            return head;
        }
        int middleIndex = size / 2;//计算链表的中间节点位置
        Node<T> node;
        int realIndex = index - 1;
        if (index > middleIndex) {//如果要查找的节点在链表中间节点的右边，则从后向前找
            node = foot;
            int lastIndex = size - 1;
            for (int i = lastIndex; i > realIndex; i--) {
                node = node.prev;
            }
        } else {//如果要查找的节点在链表中间节点的左边，则从前向后找
            node = head;
            for (int i = 0; i < realIndex; i++) {
                node = node.next;
            }
        }
        return node;
    }

    /**
     * 以ClassName:[element1 -> element2 -> element3 -> ...]的形式打印链表中所有的数据
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(getClass().getName()).append(":");
        if (isEmpty()) {
            builder.append("[ ]");
        } else {
            Node<T> node = head;
            builder.append("[");
            do {
                builder.append(node.element);
                if (node.next != null) {
                    builder.append(" -> ");
                } else {
                    builder.append("]");
                }
                node = node.next;
            } while (node != null);
        }
        return builder.toString();
    }

}
