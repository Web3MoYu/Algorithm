package org.lsh.alg.graph;


import org.lsh.alg.graph.dataStructure.Edge;
import org.lsh.alg.graph.dataStructure.Node;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 计算从某一点出发，到达其他路径的最小权值和
 */
public class C06_Dijkstra {


    /**
     * key: 代表从head出发到key
     * value: 从head出发到key的最小距离
     * 比如key: 5, value: 10，表示从head出发到5的最小距离为10
     */
    public static HashMap<Node<Integer>, Integer> dijkstra(Node<Integer> head) {
        HashMap<Node<Integer>, Integer> distanceMap = new HashMap<>();
        distanceMap.put(head, 0);

        // 处理过的点
        Set<Node<Integer>> selectedNodes = new HashSet<>();
        Node<Integer> minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);

        while (minNode != null) {
            int distance = distanceMap.get(minNode);
            for (Edge<Integer> edge : minNode.edges) {
                Node<Integer> toNode = edge.to;
                // 没记录代表正无穷(让之前没路的变成有路了)
                if (!distanceMap.containsKey(toNode)) {
                    distanceMap.put(toNode, distance + edge.weight);
                }
                // 让之前的变得更小了
                distanceMap.put(edge.to, Math.min(distanceMap.get(toNode), distance + edge.weight));
            }
            selectedNodes.add(minNode);
            minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);
        }
        return distanceMap;
    }

    private static Node<Integer> getMinDistanceAndUnselectedNode
            (HashMap<Node<Integer>, Integer> map, Set<Node<Integer>> set) {
        Node<Integer> minNode = null;
        int misDistance = Integer.MAX_VALUE;
        for (Map.Entry<Node<Integer>, Integer> entry : map.entrySet()) {
            Node<Integer> node = entry.getKey();
            int distance = entry.getValue();
            if (!set.contains(node) && distance < misDistance) {
                minNode = node;
                misDistance = distance;
            }
        }
        return minNode;
    }
}
