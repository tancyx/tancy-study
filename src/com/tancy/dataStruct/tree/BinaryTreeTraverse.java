package com.tancy.dataStruct.tree;

import java.util.*;

/**
 * @author tancy
 * 2021/7/3 14:13
 * @description 二叉树遍历
 * 参考链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal/solution/tu-jie-er-cha-shu-de-si-chong-bian-li-by-z1m/
 */
public class BinaryTreeTraverse {


    public static void main(String[] args) {
        BinaryTreeNode node7 = new BinaryTreeNode(7);
        BinaryTreeNode node6 = new BinaryTreeNode(6);
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node3 = new BinaryTreeNode(3, node6, node7);
        BinaryTreeNode node2 = new BinaryTreeNode(2, node4, node5);

        BinaryTreeNode node1 = new BinaryTreeNode(1, node2, node3);

        System.out.println("================recursive pre");
        preOrderRecursive(node1).forEach(integer -> System.out.print(integer + ","));
        System.out.println(" ");
        System.out.println("================recursive mid");
        midOrderRecursive(node1).forEach(integer -> System.out.print(integer + ","));
        System.out.println(" ");
        System.out.println("================recursive last");
        lastOrderRecursive(node1).forEach(integer -> System.out.print(integer + ","));

        System.out.println(" ");
        System.out.println("================iterator pre");
        preOrder(node1).forEach(integer -> System.out.print(integer + ","));

        System.out.println(" ");
        System.out.println("================iterator model pre");
        preOrderModel(node1).forEach(integer -> System.out.print(integer + ","));
        System.out.println(" ");
        System.out.println("================iterator model mid");
        midOrderModel(node1).forEach(integer -> System.out.print(integer + ","));
        System.out.println(" ");
        System.out.println("================iterator model last");
        lastOrderModel(node1).forEach(integer -> System.out.print(integer + ","));


        System.out.println(" ");
        System.out.println("================iterator flag pre");
        preOrderFlag(node1).forEach(integer -> System.out.print(integer + ","));
        clear(node1);
        System.out.println(" ");
        System.out.println("================iterator flag mid");
        midOrderFlag(node1).forEach(integer -> System.out.print(integer + ","));
        clear(node1);
        System.out.println(" ");
        System.out.println("================iterator flag last");
        lastOrderFlag(node1).forEach(integer -> System.out.print(integer + ","));
        clear(node1);


        System.out.println(" ");
        System.out.println("================dfs");
        dfs(node1).forEach(integer -> System.out.print(integer + ","));

        System.out.println(" ");
        System.out.println("================bfs");
        bfs(node1).forEach(integer -> System.out.print(integer + ","));

        System.out.println(" ");
        System.out.println("================level iterator");
        levelOrder(node1).forEach(level -> {
            System.out.println("---------------");
            level.forEach(integer -> System.out.print(integer + ","));
            System.out.println("");
        });


    }

    private static void clear(BinaryTreeNode root) {
        if (root == null) return;
        root.flag = false;
        clear(root.left);
        clear(root.right);
    }

    private static List<Integer> preOrderRecursive(BinaryTreeNode root) {
        if (root == null) return Collections.emptyList();
        List<Integer> result = new LinkedList<>();
        result.add(root.value);
        result.addAll(preOrderRecursive(root.left));
        result.addAll(preOrderRecursive(root.right));
        return result;
    }


    private static List<Integer> midOrderRecursive(BinaryTreeNode root) {
        if (root == null) return Collections.emptyList();
        List<Integer> result = new LinkedList<>();
        result.addAll(midOrderRecursive(root.left));
        result.add(root.value);
        result.addAll(midOrderRecursive(root.right));
        return result;
    }

    private static List<Integer> lastOrderRecursive(BinaryTreeNode root) {
        if (root == null) return Collections.emptyList();
        List<Integer> result = new LinkedList<>();
        result.addAll(lastOrderRecursive(root.left));
        result.addAll(lastOrderRecursive(root.right));
        result.add(root.value);
        return result;
    }


    /**
     * 根 -> 左 -> 右
     *
     * @param root
     * @return
     */
    private static List<Integer> preOrder(BinaryTreeNode root) {
        List<Integer> result = new LinkedList<>();
        LinkedList<BinaryTreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            BinaryTreeNode node = stack.pop();
            result.add(node.value);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }

    /**
     * 根 -> 左 -> 右
     *
     * @param root
     * @return
     */
    private static List<Integer> preOrderModel(BinaryTreeNode root) {
        List<Integer> result = new LinkedList<>();
        BinaryTreeNode cursor = root;
        LinkedList<BinaryTreeNode> stack = new LinkedList<>();
        while (cursor != null || !stack.isEmpty()) {
            while (cursor != null) {
                result.add(cursor.value);
                stack.push(cursor);
                cursor = cursor.left;
            }
            BinaryTreeNode node = stack.pop();
            cursor = node.right;
        }
        return result;
    }

    /**
     * 左 -> 根 -> 右
     *
     * @param root
     * @return
     */
    private static List<Integer> midOrderModel(BinaryTreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode cursor = root;
        while (cursor != null || !stack.isEmpty()) {
            while (cursor != null) {
                stack.push(cursor);
                cursor = cursor.left;
            }

            BinaryTreeNode node = stack.pop();
            result.add(node.value);
            cursor = node.right;
        }

        return result;
    }

    /**
     * 根 -> 右 -> 左
     * 遍历完之后，反转即得到：左 -> 右 -> 根（后序遍历）
     *
     * @param root
     * @return
     */
    private static List<Integer> lastOrderModel(BinaryTreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode cursor = root;
        while (cursor != null || !stack.isEmpty()) {
            while (cursor != null) {
                result.add(cursor.value);
                stack.push(cursor);
                cursor = cursor.right;
            }

            BinaryTreeNode node = stack.pop();
            cursor = node.left;
        }
        Collections.reverse(result);
        return result;
    }

    /**
     * 正常后序遍历解法，通过增加一个 flag 标示位，true：标示可以加入结果集的节点，false：标示需要继续向下遍历
     * 即：假设所有节点都为根节点（叶子节点看作有2个空子节点的根节点），每次循环入栈的顺序为“根右左”；
     * 这样在出栈时就相当于按后序遍历了所有根节点，所有叶子节点视为根节点的左右自己节点为空则跳过
     *
     * @param root
     * @return
     */
    private static List<Integer> lastOrderFlag(BinaryTreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<BinaryTreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            BinaryTreeNode node = stack.pop();
            if (node == null) continue;
            if (node.flag) {
                result.add(node.value);
            } else {
                node.flag = true;
                stack.push(node);
                stack.push(node.right);
                stack.push(node.left);
            }
        }
        return result;
    }

    private static List<Integer> preOrderFlag(BinaryTreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<BinaryTreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            BinaryTreeNode node = stack.pop();
            if (node == null) continue;
            if (node.flag) {
                result.add(node.value);
            } else {
                node.flag = true;
                stack.push(node.right);
                stack.push(node.left);
                stack.push(node);
            }
        }
        return result;
    }


    private static List<Integer> midOrderFlag(BinaryTreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<BinaryTreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            BinaryTreeNode node = stack.pop();
            if (node == null) continue;
            if (node.flag) {
                result.add(node.value);
            } else {
                node.flag = true;
                stack.push(node.right);
                stack.push(node);
                stack.push(node.left);
            }
        }
        return result;
    }

    private static List<Integer> preOrderx(BinaryTreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<BinaryTreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            BinaryTreeNode node = stack.pop();
            if (node == null) continue;
            result.add(node.value);
            stack.push(node.right);
            stack.push(node.left);
        }
        return result;
    }

    private static List<Integer> lastOrderx(BinaryTreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<BinaryTreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            BinaryTreeNode node = stack.pop();
            if (node == null) continue;
            result.add(node.value);
            stack.push(node.left);
            stack.push(node.right);
        }
        Collections.reverse(result);
        return result;
    }


    /**
     * 深度优先搜索
     *
     * @param root
     * @return
     */
    private static List<Integer> dfs(BinaryTreeNode root) {
        if (root == null) return Collections.emptyList();
        List<Integer> result = new LinkedList<>();
        result.add(root.value);
        result.addAll(dfs(root.left));
        result.addAll(dfs(root.right));
        return result;
    }

    /**
     * 广度优先搜索
     *
     * @param root
     * @return
     */
    private static List<Integer> bfs(BinaryTreeNode root) {
        List<Integer> result = new LinkedList<>();
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            BinaryTreeNode node = queue.remove();
            if (node == null) continue;
            result.add(node.value);
            queue.add(node.left);
            queue.add(node.right);
        }
        return result;
    }

    /**
     * 层序遍历
     *
     * @param root
     * @return
     */
    private static List<List<Integer>> levelOrder(BinaryTreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                BinaryTreeNode node = queue.remove();
                if (node == null) continue;
                level.add(node.value);
                queue.add(node.left);
                queue.add(node.right);
            }
            result.add(level);
        }
        return result;
    }
}
