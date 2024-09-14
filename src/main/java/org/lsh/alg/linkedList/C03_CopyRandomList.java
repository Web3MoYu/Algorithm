package org.lsh.alg.linkedList;

import java.util.HashMap;

public class C03_CopyRandomList {

    public static void main(String[] args) {
        Node node = new Node();
        node.addLast(1);
        node.addLast(2);
        node.addLast(3);
        node.addLast(4);
        System.out.println(node);
        System.out.println(copyRandomList2(node));
    }

    private static Node copyRandomList1(Node head) {

        Node cur = head;
        HashMap<Node, Node> map = new HashMap<>();
        while (cur != null) {
            map.put(cur, new Node());
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            Node oldNode = map.get(cur);
            oldNode.value = cur.value;
            oldNode.next = map.get(cur.next);
            oldNode.random = map.get(cur.random);
            cur = cur.next;
        }

        return map.get(head);
    }

    private static Node copyRandomList2(Node head) {
        if (head == null){
            return null;
        }

        Node cur = head;
        // 构建映射关系
        while (cur != null) {
            Node newNode = new Node(cur.value);
            newNode.next = cur.next;
            cur.next = newNode;
            cur = cur.next.next;
        }
        // 构建random关系
        // 1->1'->2->2'
        cur = head;
        while (cur != null) {
            Node newNode = cur.next;
            newNode.random = cur.random == null ? null : cur.random.next;
            cur = cur.next.next;
        }

        // 恢复
        cur = head;
        Node ans = cur.next;
        while (cur != null && cur.next != null) {
            Node newNode = cur.next;
            cur.next = cur.next.next;
            newNode.next = newNode.next == null ? null : newNode.next.next;
            cur = cur.next;
        }
        return ans;
    }
}
