package com.example.binarytree;

import java.util.Arrays;
import java.util.LinkedList;

public class BinaryTreeTest {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>(Arrays.asList(3, 2, 9, null, null, 10, null, null, 8, null, 4));

//        LinkedList<String> linkedList = new LinkedList<>(Arrays.asList("傲慢与偏见", "茶花女", "局外人", null, null, "飘", null, null, "少年维特的烦恼", null, "百年孤独"));

        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        TreeNode<Integer> treeNode = binaryTree.createTree(linkedList);

        System.out.println("前序遍历：");
        binaryTree.preOrderTraversal(treeNode);
        System.out.println();
        System.out.println("中序遍历：");
        binaryTree.inOrderTraversal(treeNode);
        System.out.println();
        System.out.println("后序遍历：");
        binaryTree.postOrderTraversal(treeNode);

        System.out.println();
        System.out.println();
        System.out.println("利用栈结构前序遍历二叉树：");
        binaryTree.preOrderTraversalByStack(treeNode);
        System.out.println();
        System.out.println("利用栈结构中序遍历二叉树：");
        binaryTree.inOrderTraversalByStack(treeNode);
        System.out.println();
        System.out.println("利用栈结构后序遍历二叉树：");
        binaryTree.postOrderTraversalByStack(treeNode);

        System.out.println();
        System.out.println();
        System.out.println("层序遍历二叉树：");
        binaryTree.levelOrderTraversal(treeNode);
    }

}
