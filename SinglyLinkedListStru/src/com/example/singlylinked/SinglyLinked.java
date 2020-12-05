package com.example.singlylinked;

/**
 * 单链表
 */
public class SinglyLinked<T> {

    private int size = 0;//链表中实际存储的数据量
    private Node<T> head;//链表头节点
    private Node<T> foot;//链表尾节点

    /**
     * 判断链表是否为空链表
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 链表中指定位置插入数据
     *
     * @param index
     * @param element
     */
    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> node = new Node<>(element);
        if (index == 0) {//链表头部插入节点
            addHead(element);
        } else if (index == size) {//链表尾部插入节点
            addFoot(element);
        } else {//链表中间插入节点
            Node<T> prevNode = getIndexBeforeNode(index);
            Node<T> nextNode = prevNode.next;
            prevNode.next = node;
            node.next = nextNode;
            size++;
        }
    }

    /**
     * 链表尾部插入数据
     *
     * @param element
     */
    public void addFoot(T element) {
        Node<T> node = new Node<>(element);
        if (isEmpty()) {
            head = foot = node;
        } else {
            foot.next = node;
            foot = node;
        }
        size++;
    }

    /**
     * 链表头部插入数据
     *
     * @param element
     */
    public void addHead(T element) {
        Node<T> node = new Node<>(element);
        if (isEmpty()) {
            head = foot = node;
        } else {
            node.next = head;
            head = node;
        }
        size++;
    }

    /**
     * 获取链表中指定位置的前置节点
     *
     * @param index
     * @return
     */
    private Node<T> getIndexBeforeNode(int index) {
        Node<T> node = head;
        int realIndex = index - 1;
        for (int i = 0; i < realIndex; i++) {
            node = node.next;
        }
        return node;
    }

    /**
     * 移除并返回链表中指定位置上的节点数据
     *
     * @param index
     * @return
     */
    public T remove(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        if (isEmpty()) {//如果链表为空的话，将头节点和为节点都置为空并抛出异常提示用户
            head = foot = null;
            throw new NullPointerException();
        }
        if (index == 0) {//移除链表的头节点
            return removeHead();
        } else if (index == size - 1) {//移除链表的尾节点
            return removeFoot();
        } else {//移除链表中指定位置上的节点
            Node<T> prevNode = getIndexBeforeNode(index);
            Node<T> nextNode = prevNode.next;
            prevNode.next = nextNode.next;
            size--;
            return nextNode.element;
        }
    }

    /**
     * 移除链表的头节点
     *
     * @return
     */
    public T removeHead() {
        if (isEmpty()) {
            head = foot = null;
            throw new NullPointerException();
        }
        Node<T> node = head;
        head = node.next;
        size--;
        return node.element;
    }

    /**
     * 移除链表的尾节点
     *
     * @return
     */
    public T removeFoot() {
        if (isEmpty()) {
            head = foot = null;
            throw new NullPointerException();
        }
        Node<T> node = foot;
        foot = getIndexBeforeNode(size - 1);
        foot.next = null;
        size--;
        return node.element;
    }

    /**
     * 修改链表中指定位置节点上的数据
     *
     * @param index
     * @param element
     */
    public void set(int index, T element) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        if (isEmpty()) {
            throw new NullPointerException();
        }
        if (index == 0) {
            head.element = element;
        } else {
            Node<T> prevNode = getIndexBeforeNode(index);
            prevNode.next.element = element;
        }
    }

    /**
     * 获取链表中指定位置节点上的数据
     *
     * @param index
     * @return
     */
    public T get(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        if (isEmpty()) {
            throw new NullPointerException();
        }
        if (index == 0) {
            return head.element;
        } else {
            return getIndexBeforeNode(index).next.element;
        }
    }

    /**
     * 获取链表中实际存储的数据长度
     *
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * 以 ClassName:[element1 -> element2 -> element3 -> ...]的方式返回链表中存储的所有数据
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(getClass().getName()).append(":");
        if (isEmpty()) {
            builder.append("[ ]");
            return builder.toString();
        }
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
        return builder.toString();
    }

}
