package org.lsh.alg.tree;

import java.util.LinkedList;
import java.util.Queue;

public class C03_IsCBT {
    public static void main(String[] args) {
        TreeNode root = TreeNode.init();
        System.out.println(isCBT(root));
    }

    private static boolean isCBT(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        // 是否遇到过左右孩子不全的节点
        boolean leaf = false;
        TreeNode left = null;
        TreeNode right = null;
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            left = poll.left;
            right = poll.right;

            if (
                // 条件2
                    (leaf && (left != null || right != null))
                            ||
                            (left == null && right != null) // 条件1
            ) {
                return false;
            }

            if (left != null) {
                queue.add(left);
            }
            if (right != null) {
                queue.add(right);
            }
            if (left == null || right == null) {
                leaf = true;
            }
        }
        return true;
    }
}
