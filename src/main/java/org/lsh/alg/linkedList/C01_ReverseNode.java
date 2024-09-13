package org.lsh.alg.linkedList;


public class C01_ReverseNode {

    public static void main(String[] args) {
        Node<Integer> node = new Node<>();
        node.addLast(1);
        node.addLast(2);
        node.addLast(3);
        node.addLast(4);
        System.out.println(node);
        node = node.reverse();
    }
}
