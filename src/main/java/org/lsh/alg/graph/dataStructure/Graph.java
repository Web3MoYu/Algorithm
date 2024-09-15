package org.lsh.alg.graph.dataStructure;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.HashSet;

@AllArgsConstructor
@NoArgsConstructor
public class Graph<T> {
    // 编号和实际结构
    public HashMap<Integer, Node<T>> nodes;
    public HashSet<Edge<T>> edges;
}
