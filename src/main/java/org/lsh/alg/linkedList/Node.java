package org.lsh.alg.linkedList;

public class Node<T> {
    T value;
    Node<T> next;

    public Node() {
    }

    public Node(T value) {
        this.value = value;
    }

    public Node<T> add(T value) {
        Node<T> node = new Node<>(value);
        node.next = this.next;
        this.next = node;
        return this;
    }

    public Node<T> reverse(Node<T> head) {
        Node<T> cur = head.next;
        Node<T> pre = null;

        // 3->2->1
        // 2->1
        // 3->null
        while (cur != null) {
            Node<T> t = cur.next;
            cur.next = pre;
            pre = cur;
            cur = t;
        }
        Node<T> res = new Node<>();
        res.next = pre;
        return res;
    }

    @Override
    public String toString() {
        Node<T> node = this.next;
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
