package org.lsh.alg.linkedList;

import java.util.HashMap;

public class C03_CopyRandomList {

    public static void main(String[] args) {
        Node<Integer> node = new Node<>();
        node.addLast(1);
        node.addLast(2);
        node.addLast(3);
        node.addLast(4);
        System.out.println(node);
        System.out.println(copyRandomList2(node));
    }

    private static Node<Integer> copyRandomList1(Node<Integer> head) {

        Node<Integer> cur = head;
        HashMap<Node<Integer>, Node<Integer>> map = new HashMap<>();
        while (cur != null) {
            map.put(cur, new Node<>());
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            Node<Integer> oldNode = map.get(cur);
            oldNode.value = cur.value;
            oldNode.next = map.get(cur.next);
            oldNode.random = map.get(cur.random);
            cur = cur.next;
        }

        return map.get(head);
    }

    private static Node<Integer> copyRandomList2(Node<Integer> head) {
        if (head == null){
            return null;
        }

        Node<Integer> cur = head;
        // 构建映射关系
        while (cur != null) {
            Node<Integer> newNode = new Node<>(cur.value);
            newNode.next = cur.next;
            cur.next = newNode;
            cur = cur.next.next;
        }
        // 构建random关系
        // 1->1'->2->2'
        cur = head;
        while (cur != null) {
            Node<Integer> newNode = cur.next;
            newNode.random = cur.random == null ? null : cur.random.next;
            cur = cur.next.next;
        }

        // 恢复
        cur = head;
        Node<Integer> ans = cur.next;
        while (cur != null && cur.next != null) {
            Node<Integer> newNode = cur.next;
            cur.next = cur.next.next;
            newNode.next = newNode.next == null ? null : newNode.next.next;
            cur = cur.next;
        }
        return ans;
    }
}
