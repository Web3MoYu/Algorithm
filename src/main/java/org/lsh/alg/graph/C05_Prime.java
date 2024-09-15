package org.lsh.alg.graph;

import org.lsh.alg.graph.dataStructure.Edge;
import org.lsh.alg.graph.dataStructure.Graph;
import org.lsh.alg.graph.dataStructure.Node;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * P算法
 * 针对点而言
 * 随便一个点，加入点的集合，然后边加入边的集合
 * 从边的集合中选一个最小的边，解锁与之相连的点，将该点加入点集
 * 重复上述步骤
 */
public class C05_Prime {

    public static Set<Edge<Integer>> primeMST(Graph<Integer> graph) {
        // 优先队列
        PriorityQueue<Edge<Integer>> queue = new PriorityQueue<>
                ((Comparator.comparingInt(o -> o.weight)));
        // 点集
        HashSet<Node<Integer>> nodes = new HashSet<>();

        // 边集
        HashSet<Edge<Integer>> result = new HashSet<>();

        for (Node<Integer> node : graph.nodes.values()) {
            if (!nodes.contains(node)) {
                nodes.add(node);
                // 添加所有的边
                queue.addAll(node.edges);
                while (!queue.isEmpty()) {
                    Edge<Integer> edge = queue.poll(); // 弹出最小的边
                    Node<Integer> toNode = edge.to; // 该边指向的新点
                    // 查看该点在不在点集里
                    if (!nodes.contains(toNode)) {
                        nodes.add(toNode);
                        result.add(edge);
                        // 再次添加有该点所新解锁的边
                        queue.addAll(toNode.edges);
                    }
                }
            }
        }
        return result;
    }
}
