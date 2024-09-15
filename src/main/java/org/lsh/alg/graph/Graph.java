package org.lsh.alg.graph;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.HashSet;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Graph<T> {
    // 编号和实际结构
    private HashMap<Integer, Node<T>> nodes;
    private HashSet<Edge<T>> edges;
}
