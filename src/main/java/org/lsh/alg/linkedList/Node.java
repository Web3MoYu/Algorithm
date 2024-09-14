package org.lsh.alg.linkedList;

public class Node<T> {
    T value;
    Node<T> next;
    Node<T> random;


    public Node() {
    }

    public Node(T value) {
        this.value = value;
        this.next = null;
    }

    public void addFirst(T value) {
        Node<T> node = new Node<>(value);
        node.next = this.next;
        this.next = node;
    }

    public void addLast(T value) {
        Node<T> node = new Node<>(value);
        Node<T> cur = this.next;
        if (cur == null) {
            this.next = node;
            return;
        }
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;
    }

    public Node<T> reverse() {
        Node<T> cur = this.next;
        Node<T> pre = null;
        Node<T> t = null;
        while (cur != null) {
            t = cur.next;
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
