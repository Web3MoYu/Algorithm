package org.lsh.alg.graph;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Node<T> {
    private T value;
    // 入度
    private int in;
    // 出度
    private int out;
    // 从该点出发直接领居
    public List<Node<T>> next;
    // 从该点出发的边
    private List<Edge<T>> edges;

    public Node(T value) {
        this.value = value;
        this.in = 0;
        this.out = 0;
        this.next = new ArrayList<>();
        this.edges = new ArrayList<>();
    }
}
