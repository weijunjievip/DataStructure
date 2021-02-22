package com.example.binarytree;

import java.util.LinkedList;

public class BinaryTree<T> {

    /**
     * 创建二叉树
     *
     * @param linkedList 使用LinkedList集合中的元素创建二叉树
     * @return 返回创建好的二叉树
     */
    public TreeNode<T> createTree(LinkedList<T> linkedList) {
        if (linkedList == null || linkedList.isEmpty()) {
            return null;
        }
        TreeNode<T> treeNode = null;
        T node = linkedList.removeFirst();
        if (node != null) {
            treeNode = new TreeNode<>(node);
            treeNode.leftChild = createTree(linkedList);
            treeNode.rightChild = createTree(linkedList);
        }
        return treeNode;
    }

    /**
     * 使用递归的方式前序遍历二叉树
     *
     * @param treeNode 要被遍历的二叉树
     */
    public void preOrderTraversal(TreeNode<T> treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.print(treeNode.data + " ");
        preOrderTraversal(treeNode.leftChild);
        preOrderTraversal(treeNode.rightChild);
    }

    /**
     * 中序遍历二叉树
     *
     * @param treeNode 要被遍历的二叉树
     */
    public void inOrderTraversal(TreeNode<T> treeNode) {
        if (treeNode == null) {
            return;
        }
        inOrderTraversal(treeNode.leftChild);
        System.out.print(treeNode.data + " ");
        inOrderTraversal(treeNode.rightChild);
    }

    /**
     * 后序遍历二叉树
     *
     * @param treeNode 要被遍历的二叉树
     */
    public void postOrderTraversal(TreeNode<T> treeNode) {
        if (treeNode == null) {
            return;
        }
        postOrderTraversal(treeNode.leftChild);
        postOrderTraversal(treeNode.rightChild);
        System.out.print(treeNode.data + " ");
    }

}
