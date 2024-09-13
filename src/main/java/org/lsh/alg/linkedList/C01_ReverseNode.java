package org.lsh.alg.linkedList;

public class C01_ReverseNode {

    public static void main(String[] args) {
        Node<Integer> node = new Node<>();
        node.add(1);
        node.add(2);
        node.add(3);
        System.out.println(node);
        node = node.reverse(node);
        System.out.println(node);
    }
}
