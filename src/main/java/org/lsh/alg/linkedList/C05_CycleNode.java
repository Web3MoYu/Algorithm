package org.lsh.alg.linkedList;

import java.util.HashSet;

public class C05_CycleNode {

    public static void main(String[] args) {
        Node node = new Node();
        node.addLast(1);
        node.addLast(2);
        node.addLast(3);
        node.addLast(4);
        System.out.println(detectCycle1(node));
        System.out.println(detectCycle2(node));
    }

    // HashSet
    public static Node detectCycle1(Node head) {
        Node cur = head.next;
        HashSet<Node> set = new HashSet<>();
        while (cur != null) {
            if (set.contains(cur)) {
                return cur;
            }
            set.add(cur);
            cur = cur.next;
        }
        return null;
    }

    // Slow Fast
    public static Node getLoop(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        Node slow = head.next;
        Node fast = head.next.next;

        while (slow != fast) {
            if (fast.next == null || fast.next.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    public static Node bothLoop(Node head1, Node head2) {

        // 拿到是否有环
        Node loop1 = getLoop(head1);
        Node loop2 = getLoop(head2);
        // 如果都没有环，就是两个单链表的相交问题
        if (loop1 == null && loop2 == null) {
            return getIntersectionNode(head1, head2, null);
        }
        // 都有环
        if (loop1 != null && loop2 != null) {
            // 如果入环节点相同，那么就是无环节点的相交问题
            if (loop1 == loop2) {
                return getIntersectionNode(head1, head2, loop2);
            } else {
                // 如果入环节点不同，看loop1在转回自己之前能不能遇到loop2，如果可以就有，没有就为null
                Node cur = loop1.next;
                while (cur != loop1) {
                    if (cur == loop2) {
                        return loop2;
                    }
                    cur = cur.next;
                }
                return null;
            }
        }
        return null;
    }

    public static Node getIntersectionNode(Node head1, Node head2, Node target) {
        Node n1 = head1;
        Node n2 = head2;
        int count = 0;

        while (n1 != target) {
            count++;
            n1 = n1.next;
        }

        while (n2 != target) {
            count--;
            n2 = n2.next;
        }

        // 选出长的
        n1 = count > 0 ? head1 : head2;
        n2 = n1 == head1 ? head2 : head1;

        count = Math.abs(count);
        while (count > 0) {
            n1 = n1.next;
            count--;
        }

        while (n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }
}