package org.lsh.alg.graph;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Edge<T> {
    public int weight;
    public Node<T> from;
    public Node<T> to;
}
