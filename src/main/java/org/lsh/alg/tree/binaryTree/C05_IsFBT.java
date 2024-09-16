package org.lsh.alg.tree.binaryTree;

public class C05_IsFBT {

    public static void main(String[] args) {
        TreeNode root = TreeNode.init();
        System.out.println(isFBT(root));
    }

    private static class Info {
        int height;
        int nodes;

        public Info(int height, int nodes) {
            this.height = height;
            this.nodes = nodes;
        }
    }

    private static boolean isFBT(TreeNode root) {
        if (root == null) {
            return true;
        }
        Info data = process(root);
        return data.nodes == (1 << data.height) - 1;
    }

    private static Info process(TreeNode root) {
        if (root == null) {
            return new Info(0, 0);
        }

        Info leftData = process(root.left);
        Info rightData = process(root.right);

        int height = Math.max(leftData.height, rightData.height) + 1;
        int nodes = leftData.nodes + rightData.nodes + 1;

        return new Info(height, nodes);
    }
}
