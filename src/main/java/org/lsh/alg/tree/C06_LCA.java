package org.lsh.alg.tree;

// 最大公共祖先
public class C06_LCA {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 自己左右孩子都不为空就返回自己
        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }
}
