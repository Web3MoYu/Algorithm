package org.lsh.alg.linkedList;


public class C01_ReverseNode {

    public static void main(String[] args) {
        ListNode listNode = new ListNode();
        listNode.addLast(1);
        listNode.addLast(2);
        listNode.addLast(3);
        listNode.addLast(4);
        System.out.println(listNode);
        listNode = listNode.reverse();
    }
}
