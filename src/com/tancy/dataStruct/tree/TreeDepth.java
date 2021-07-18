package com.tancy.dataStruct.tree;

/**
 * @author tancy
 * 2021/7/4 14:08
 * @description 树的高度
 */
public class TreeDepth {


    public static void main(String[] args) {
        BinaryTreeNode node9 = new BinaryTreeNode(9);
        BinaryTreeNode node8 = new BinaryTreeNode(8);

        BinaryTreeNode node7 = new BinaryTreeNode(7, node8, node9);
        BinaryTreeNode node6 = new BinaryTreeNode(6);
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node3 = new BinaryTreeNode(3, node6, node7);
        BinaryTreeNode node2 = new BinaryTreeNode(2, node4, node5);

        BinaryTreeNode node1 = new BinaryTreeNode(1, node2, node3);

        System.out.println(maxDepth(node1));

        System.out.println(isBalanced(node1));

    }


    private static int maxDepth(BinaryTreeNode root) {
        if (root == null) return 0;
        int depth = 1;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return depth + Math.max(left, right);
    }


    private static boolean isBalanced(BinaryTreeNode root) {
        if (root == null) return true;
        int ldepth = maxDepth(root.left);
        int rdepth = maxDepth(root.right);
        if (Math.abs(ldepth - rdepth) > 1) {
            return false;
        }
        boolean left = isBalanced(root.left);
        boolean right = isBalanced(root.right);
        return left && right;
    }

}
