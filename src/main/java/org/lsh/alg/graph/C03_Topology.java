package org.lsh.alg.graph;

import org.lsh.alg.graph.dataStructure.Graph;
import org.lsh.alg.graph.dataStructure.Node;

import java.util.*;

public class C03_Topology {

    public static List<Node<Integer>> sortedTopology(Graph<Integer> graph) {
        // node->剩余的入度
        HashMap<Node<Integer>, Integer> inMap = new HashMap<>();
        // 入度为0的点，才能进这个队列
        Queue<Node<Integer>> zeroInQueue = new LinkedList<>();
        for (Node<Integer> node : graph.nodes.values()) {
            inMap.put(node, node.in);
            if (node.in == 0) {
                zeroInQueue.add(node);
            }
        }

        List<Node<Integer>> ans = new ArrayList<>();

        while (!zeroInQueue.isEmpty()) {
            Node<Integer> cur = zeroInQueue.poll();
            ans.add(cur);
            for (Node<Integer> next : cur.nexts) {
                inMap.put(next, inMap.get(next) - 1);
                if (inMap.get(next) == 0) {
                    zeroInQueue.add(next);
                }
            }
        }
        return ans;
    }

}
