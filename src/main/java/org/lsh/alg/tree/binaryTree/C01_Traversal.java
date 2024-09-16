package org.lsh.alg.tree.binaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class C01_Traversal {

    public static void main(String[] args) {
        TreeNode root = TreeNode.init();
        preOrderRecur(root);
        System.out.println();
        preOrderStack(root);
        System.out.println();
        inOrderRecur(root);
        System.out.println();
        inOrderStack(root);
        System.out.println();
        posOrderRecur(root);
        System.out.println();
        posOrderStack(root);
        System.out.println();
        widthTraversal(root);
    }

    public static void preOrderRecur(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrderRecur(root.left);
        preOrderRecur(root.right);
    }

    public static void preOrderStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.print(node.val + " ");
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    public static void inOrderRecur(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderRecur(root.left);
        System.out.print(root.val + " ");
        inOrderRecur(root.right);
    }

    public static void inOrderStack(TreeNode root) {
        // 对于任意一个树，只要有左树，就压入，没有就弹出打印，并跳到右树
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                System.out.print(root.val + " ");
                root = root.right;
            }

        }
    }

    public static void posOrderRecur(TreeNode root) {
        if (root == null) {
            return;
        }
        posOrderRecur(root.left);
        posOrderRecur(root.right);
        System.out.print(root.val + " ");
    }

    public static void posOrderStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> help = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            help.push(node);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        while (!help.isEmpty()) {
            System.out.print(help.pop().val + " ");
        }
    }

    public static void widthTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            System.out.print(poll.val + " ");
            if (poll.left != null) {
                queue.add(poll.left);
            }
            if (poll.right != null) {
                queue.add(poll.right);
            }
        }
    }
}
