package org.lsh.alg.graph.dataStructure;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Edge<T> {
    public int weight;
    public Node<T> from;
    public Node<T> to;
}
