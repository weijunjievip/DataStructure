package com.example.binarytree;

import java.util.Arrays;
import java.util.LinkedList;

public class BinaryTreeTest {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>(Arrays.asList(3, 2, 9, null, null, 10, null, null, 8, null, 4));

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
    }

}
