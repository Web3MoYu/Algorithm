package org.lsh.alg.graph.dataStructure;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class Node<T> {
    public T value;
    // 入度
    public int in;
    // 出度
    public int out;
    // 从该点出发直接领居
    public List<Node<T>> nexts;
    // 从该点出发的边
    public List<Edge<T>> edges;

    public Node(T value) {
        this.value = value;
        this.in = 0;
        this.out = 0;
        this.nexts = new ArrayList<>();
        this.edges = new ArrayList<>();
    }
}
