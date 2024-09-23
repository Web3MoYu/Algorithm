package org.lsh.alg.tree.binaryTree;

public class C07_Morris {

    public static void main(String[] args) {
        TreeNode root = TreeNode.init();
        morris(root);
        System.out.println();
        preMorris(root);
        System.out.println();
        inMorris(root);
        System.out.println();
        posMorris(root);
    }

    public static void morris(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode cur = root;
        TreeNode mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            System.out.print(cur.val + " ");
            if (mostRight != null) { // mostRight是cur左孩子
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                // mostRight是cur左子树上的最右节点
                if (mostRight.right == null) { // 第一次来到cur节点
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            }
            cur = cur.right;
        }
    }

    public static void preMorris(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode cur = root;
        TreeNode mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) { // mostRight是cur左孩子
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                // mostRight是cur左子树上的最有节点
                if (mostRight.right == null) { // 第一次来到cur节点
                    System.out.print(cur.val + " ");
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            } else { // 没有左子树的情况
                System.out.print(cur.val + " ");
            }
            cur = cur.right;
        }
    }

    public static void inMorris(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode cur = root;
        TreeNode mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) { // mostRight是cur左孩子
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                // mostRight是cur左子树上的最有节点
                if (mostRight.right == null) { // 第一次来到cur节点
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            }
            System.out.print(cur.val + " ");
            cur = cur.right;
        }
    }

    public static void posMorris(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode cur = root;
        TreeNode mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) { // mostRight是cur左孩子
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                // mostRight是cur左子树上的最有节点
                if (mostRight.right == null) { // 第一次来到cur节点
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                    printEdge(cur.left);
                }
            }
            cur = cur.right;
        }
        printEdge(root);
    }

    private static void printEdge(TreeNode root) {
        TreeNode tail = reverseEdge(root);
        TreeNode cur = tail;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.right;
        }
        reverseEdge(tail);
    }

    private static TreeNode reverseEdge(TreeNode root) {
        TreeNode pre = null;
        TreeNode next = null;
        while(root != null){
            next = root.right;
            root.right = pre;
            pre = root;
            root = next;
        }
        return pre;
    }
}
