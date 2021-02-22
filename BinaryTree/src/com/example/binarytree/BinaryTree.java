package com.example.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
     * @param treeNode 要被遍历的二叉树的根节点
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
     * @param treeNode 要被遍历的二叉树的根节点
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
     * @param treeNode 要被遍历的二叉树的根节点
     */
    public void postOrderTraversal(TreeNode<T> treeNode) {
        if (treeNode == null) {
            return;
        }
        postOrderTraversal(treeNode.leftChild);
        postOrderTraversal(treeNode.rightChild);
        System.out.print(treeNode.data + " ");
    }

    /**
     * 使用栈结构前序遍历二叉树
     *
     * @param treeNode 要被遍历的二叉树的根节点
     */
    public void preOrderTraversalByStack(TreeNode<T> treeNode) {
        Stack<TreeNode<T>> stack = new Stack<>();
        TreeNode<T> root = treeNode;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                System.out.print(root.data + " ");
                root = root.leftChild;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                root = root.rightChild;
            }
        }

    }

    /**
     * 使用栈结构中序遍历二叉树
     *
     * @param treeNode 要被遍历的二叉树的根节点
     */
    public void inOrderTraversalByStack(TreeNode<T> treeNode) {
        Stack<TreeNode<T>> stack = new Stack<>();
        TreeNode<T> root = treeNode;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.leftChild;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                System.out.print(root.data + " ");
                root = root.rightChild;
            }
        }
    }

    /**
     * 使用栈结构后序遍历二叉树
     *
     * @param treeNode 要被遍历的二叉树的根节点
     */
    public void postOrderTraversalByStack(TreeNode<T> treeNode) {
        Stack<TreeNode<T>> stack = new Stack<>();
        Stack<TreeNode<T>> printStack = new Stack<>(); //存放打印结果的栈
        TreeNode<T> root = treeNode;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                printStack.push(root);
                root = root.rightChild;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                root = root.leftChild;
            }
        }
        while (!printStack.isEmpty()) {
            System.out.print(printStack.pop().data + " ");
        }
    }

    /**
     * 利用队列层序遍历二叉树
     *
     * @param treeNode 要被遍历的二叉树的根节点
     */
    public void levelOrderTraversal(TreeNode<T> treeNode) {
        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.offer(treeNode);
        while (!queue.isEmpty()) {
            TreeNode<T> root = queue.poll();
            System.out.print(root.data + " ");
            if (root.leftChild != null) {
                queue.offer(root.leftChild);
            }
            if (root.rightChild != null) {
                queue.offer(root.rightChild);
            }
        }
    }

}
