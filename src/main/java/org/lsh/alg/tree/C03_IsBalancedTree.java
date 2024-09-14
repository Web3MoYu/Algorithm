package org.lsh.alg.tree;

public class C03_IsBalancedTree {

    private static class ReturnType {
        boolean isBalanced;
        int height;

        public ReturnType(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.init();
        System.out.println(process(root).isBalanced);
    }

    private static ReturnType process(TreeNode root) {
        if (root == null) { // tree is null
            return new ReturnType(true, 0);
        }

        // 返回左右子树的信息
        ReturnType leftData = process(root.left);
        ReturnType rightData = process(root.right);

        int height = Math.max(leftData.height, rightData.height) + 1;
        boolean isBalanced = leftData.isBalanced && rightData.isBalanced
                && Math.abs(leftData.height - rightData.height) < 2;
        return new ReturnType(isBalanced, height);
    }
}
