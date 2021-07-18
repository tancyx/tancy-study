package com.tancy.dataStruct.tree;

/**
 * @author tancy
 * 2021/7/3 13:39
 * @description 二叉树
 */
public class BinaryTreeNode {

    public int value;

    public BinaryTreeNode left;

    public BinaryTreeNode right;

    public boolean flag;

    public BinaryTreeNode() {

    }

    public BinaryTreeNode(int value) {
        this.value = value;
    }

    public BinaryTreeNode(int value, BinaryTreeNode left, BinaryTreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
