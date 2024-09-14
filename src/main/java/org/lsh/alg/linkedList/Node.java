package org.lsh.alg.linkedList;

public class Node {
    Integer value;
    Node next;
    Node random;

    public Node() {
    }

    public Node(Integer value) {
        this.value = value;
        this.next = null;
    }

    public void addFirst(Integer value) {
        Node node = new Node(value);
        node.next = this.next;
        this.next = node;
    }

    public void addLast(Integer value) {
        Node node = new Node(value);
        Node cur = this.next;
        if (cur == null) {
            this.next = node;
            return;
        }
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;
    }

    public Node reverse() {
        Node cur = this.next;
        Node pre = null;
        Node t = null;
        while (cur != null) {
            t = cur.next;
            cur.next = pre;
            pre = cur;
            cur = t;
        }
        Node res = new Node();
        res.next = pre;
        return res;
    }

    @Override
    public String toString() {
        Node node = this.next;
        StringBuilder str = new StringBuilder();
        while (node != null) {
            if (node.next != null) {
                str.append(node.value).append("->");
            } else {
                str.append(node.value);
            }
            node = node.next;
        }
        return str.toString();
    }
}
