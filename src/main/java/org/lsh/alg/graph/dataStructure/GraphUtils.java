package org.lsh.alg.graph.dataStructure;

public class GraphUtils {

    // [from,to,weight] 从哪到哪权值是多少
    public static Graph<Integer> createGraph(Integer[][] matrix) {
        Graph<Integer> graph = new Graph<>();

        for (int i = 0; i < matrix.length - 1; i++) {
            // 拿到数据
            Integer from = matrix[i][0];
            Integer to = matrix[i][1];
            Integer weight = matrix[i][2];

            // 判断点击存不存在这两个点
            if (!graph.nodes.containsKey(from)) {
                graph.nodes.put(from, new Node<>(from));
            }
            if (!graph.nodes.containsKey(to)) {
                graph.nodes.put(to, new Node<>(to));
            }

            // 拿到这两个点
            Node<Integer> fromNode = graph.nodes.get(from);
            Node<Integer> toNode = graph.nodes.get(to);
            // 构造两点之间的边集
            Edge<Integer> newEdge = new Edge<>(weight, fromNode, toNode);
            // 修改数据
            fromNode.edges.add(newEdge);
            fromNode.next.add(toNode);
            fromNode.out++;

            toNode.in++;
            // 新增图的边
            graph.edges.add(newEdge);
        }

        return graph;
    }
}
