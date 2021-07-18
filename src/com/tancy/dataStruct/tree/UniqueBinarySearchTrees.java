package com.tancy.dataStruct.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author tancy
 * 2021/7/8 9:06
 * @description 不同的二叉搜索树
 *
 */
public class UniqueBinarySearchTrees {


    public static void main(String[] args) {
        trees(3).forEach(binaryTreeNode -> System.out.println(binaryTreeNode.value));
        while (true) {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    private static List<BinaryTreeNode> trees(int num) {
        if (num < 1) {
            return new LinkedList<>();
        }

        return subTree(1, num);
    }


    /**
     * 给定一个数字 n，要求生成所有值为 1...n 的二叉搜索树。
     * 分治法
     * @param left
     * @param right
     * @return
     */
    private static List<BinaryTreeNode> subTree(int left, int right) {
        List<BinaryTreeNode> result = new LinkedList<>();
        if (left > right) {
            result.add(null);
            return result;
        }
        for (int i = left; i <= right; i++) {
            List<BinaryTreeNode> leftTree = subTree(left, i - 1);
            List<BinaryTreeNode> rightTree = subTree(i + 1, right);
            for (BinaryTreeNode lt : leftTree) {
                for (BinaryTreeNode rt : rightTree) {
                    BinaryTreeNode root = new BinaryTreeNode(i);
                    root.left = lt;
                    root.right = rt;
                    result.add(root);
                }
            }

        }
        return result;
    }

}
