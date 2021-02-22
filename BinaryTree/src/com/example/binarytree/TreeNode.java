package com.example.binarytree;

/**
 * 二叉树节点类
 *
 * @param <T>
 */
public class TreeNode<T> {

    TreeNode<T> leftChild; //根节点的左孩子节点
    TreeNode<T> rightChild; //根节点的右孩子节点
    T data; //节点中实际存储的数据

    public TreeNode(T data) {
        this.data = data;
    }

}
