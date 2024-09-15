package org.lsh.alg.graph;


import org.lsh.alg.graph.dataStructure.Node;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class C01_BFS {

    private static void bfs(Node<Integer> node) {
        if (node == null) {
            return;
        }
        Queue<Node<Integer>> queue = new LinkedList<>();
        // 保证不要重复进点
        HashSet<Node<Integer>> set = new HashSet<>();
        queue.add(node);
        set.add(node);
        while (!queue.isEmpty()) {
            Node<Integer> poll = queue.poll();
            System.out.println(poll.value);
            for (Node<Integer> next : poll.nexts) {
                if (!set.contains(next)) {
                    set.add(next);
                    queue.add(next);
                }
            }
        }
    }
}
