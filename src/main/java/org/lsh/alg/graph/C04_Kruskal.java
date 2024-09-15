package org.lsh.alg.graph;

import org.lsh.alg.graph.dataStructure.Edge;
import org.lsh.alg.graph.dataStructure.Graph;
import org.lsh.alg.graph.dataStructure.Node;

import java.util.*;

/**
 * 最小生成树
 * 将边从小到大排序
 * 然后依次加入，如果加入之后构成环了，就丢弃，否则就加入
 * 最后边的集合就是最小生成树
 */
public class C04_Kruskal {

    public static class UnionSet {
        public HashMap<Node<Integer>, List<Node<Integer>>> setMap;

        public UnionSet(List<Node<Integer>> nodes) {
            setMap = new HashMap<>();
            for (Node<Integer> cur : nodes) {
                List<Node<Integer>> set = new ArrayList<>();
                set.add(cur);
                setMap.put(cur, set);
            }
        }

        public boolean isSameSet(Node<Integer> from, Node<Integer> to) {
            List<Node<Integer>> fromSet = setMap.get(from);
            List<Node<Integer>> toSet = setMap.get(to);
            return fromSet == toSet;
        }

        //                           1             2
        public void union(Node<Integer> from, Node<Integer> to) {
            List<Node<Integer>> fromSet = setMap.get(from);
            List<Node<Integer>> toSet = setMap.get(to);
            // {1} {2}
            for (Node<Integer> toNode : toSet) {
                fromSet.add(toNode);
                // 将toNode指向的集合地址变成和fromSet一致
                setMap.put(toNode, fromSet);
            }
        }
    }

    public static Set<Edge<Integer>> kruskalMST(Graph<Integer> graph) {
        UnionSet unionSet = new UnionSet(new ArrayList<>(graph.nodes.values()));
        // 优先队列
        PriorityQueue<Edge<Integer>> queue = new PriorityQueue<>((Comparator.comparingInt(o -> o.weight)));
        queue.addAll(graph.edges);

        Set<Edge<Integer>> result = new HashSet<>();
        while (!queue.isEmpty()) {
            Edge<Integer> edge = queue.poll();
            if (!unionSet.isSameSet(edge.from, edge.to)) {
                result.add(edge);
                unionSet.union(edge.from, edge.to);
            }
        }
        return result;
    }
}
