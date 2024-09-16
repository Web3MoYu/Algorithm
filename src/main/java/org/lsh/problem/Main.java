package org.lsh.problem;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[][] grid = {{0, 1}, {1, 0}, {2, 1}};

        System.out.println(canFinish(2, grid));


    }

    static class Node {
        public int val;
        public Set<Node> nexts;
        public int in;

        public Node(int val) {
            this.val = val;
            this.in = 0;
            this.nexts = new HashSet<>();
        }
    }

    public static HashMap<Integer, Node> pre(int[][] pre) {
        HashMap<Integer, Node> nodes = new HashMap<>();
        for (int[] ints : pre) {
            int from = ints[0];
            int to = ints[1];
            if (from == to) {
                return null;
            }
            if (!nodes.containsKey(from)) {
                nodes.put(from, new Node(from));
            }
            if (!nodes.containsKey(to)) {
                nodes.put(to, new Node(to));
            }
            Node fromNode = nodes.get(from);
            Node toNode = nodes.get(to);
            toNode.in++;

            fromNode.nexts.add(toNode);
        }
        return nodes;
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        // 查看是不是有环即可
        HashMap<Integer, Node> nodes = pre(prerequisites);
        // 入度为0的点，才能进这个队列
        Queue<Node> zeroInQueue = new LinkedList<>();
        HashMap<Node, Integer> inMap = new HashMap<>();
        if (prerequisites.length == 0) {
            return true;
        }
        if (nodes == null) {
            return false;
        }
        // 遍历一边找到入度为0的点
        for (Node node : nodes.values()) {
            inMap.put(node, node.in);
            if (node.in == 0) {
                zeroInQueue.add(node);
            }
        }

        List<Node> ans = new ArrayList<>();
        while (!zeroInQueue.isEmpty()) {
            Node cur = zeroInQueue.poll();
            ans.add(cur);
            for (Node next : cur.nexts) {
                inMap.put(next, inMap.get(next) - 1);
                if (inMap.get(next) == 0) {
                    zeroInQueue.add(next);
                }
            }
        }
        return ans.size() == nodes.size();
    }
}
