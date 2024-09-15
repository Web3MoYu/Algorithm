package org.lsh.alg.graph;

import org.lsh.alg.graph.dataStructure.Node;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class C02_DFS {

    private static void bfs(Node<Integer> node) {
        if (node == null) {
            return;
        }
        Stack<Node<Integer>> stack = new Stack<>();
        // 保证不要重复进点
        HashSet<Node<Integer>> set = new HashSet<>();
        stack.push(node);
        set.add(node);
        System.out.println(node.value);
        while (!stack.isEmpty()) {
            Node<Integer> cur = stack.pop();
            for (Node<Integer> next : cur.nexts) {
                // 发现有一个没走过，就先把之前的cur压回栈，在压next，然后set标记next
                // 相当于逮着一条路走到黑，知道一条路走完，就会回到cur，继续延申cur的其他路
                if (!set.contains(next)) {
                    stack.push(cur);
                    stack.push(next);
                    set.add(next);
                    System.out.println(cur.value);
                    break;
                }
            }
        }
    }
}
