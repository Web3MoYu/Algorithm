package org.lsh.alg.tree.binaryTree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class C02_MaxWidth {

    public static void main(String[] args) {
        TreeNode root = TreeNode.init();
        System.out.println(maxWidth2(root));
    }

    // 使用hashmap的解法
    private static int maxWidth(TreeNode root) {
        int max = Integer.MIN_VALUE;
        int curLevels = 1; // 确认当前层数的
        int curNodes = 0;
        HashMap<TreeNode, Integer> map = new HashMap<>();
        map.put(root, 1); // 记录第一层

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            Integer cur = map.get(poll);
            if (cur == curLevels) {
                curNodes++;
            } else {
                curLevels++;// 不一样代表当前层级数变了
                max = Math.max(max, curNodes);
                curNodes = 1; // 注意这里，要写成这样，因为和第一层不一样已经时下一层的第一个了
            }
            if (poll.left != null) {
                queue.add(poll.left);
                map.put(poll.left, curLevels + 1); // 下一层的层级数加1
            }

            if (poll.right != null) {
                queue.add(poll.right);
                map.put(poll.right, curLevels + 1);
            }
        }
        // 这里注意和最后一层的节点数比较
        return Math.max(max, curNodes);
    }

    private static int maxWidth2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode curEnd = root; // 永远表示当前层最后一个节点
        TreeNode nextEnd = null; // 表示下一层最后一个节点
        int max = Integer.MIN_VALUE;
        int curNodes = 0;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            // 每次加入新的元素，都要赋值给nextEnd，保证nextEnd是该层最后一个
            if (cur.left != null) {
                queue.add(cur.left);
                nextEnd = cur.left;
            }
            if (cur.right != null) {
                queue.add(cur.right);
                nextEnd = cur.right;
            }
            if (cur == curEnd) {
                curNodes++;// 进入这里计算该层最后一个
                System.out.println(curNodes);
                max = Math.max(max, curNodes);
                curNodes = 0;
                curEnd = nextEnd; // 将下一层的赋值给当前层，表示进入下一层了
                continue;
            }
            curNodes++;
        }
        return max;
    }
}
