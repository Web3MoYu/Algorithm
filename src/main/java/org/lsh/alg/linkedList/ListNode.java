package org.lsh.alg.linkedList;

public class ListNode {
    Integer val;
    ListNode next;
    ListNode random;

    public ListNode() {
    }

    public ListNode(Integer value) {
        this.val = value;
        this.next = null;
    }

    public void addFirst(Integer value) {
        ListNode listNode = new ListNode(value);
        listNode.next = this.next;
        this.next = listNode;
    }

    public void addLast(Integer value) {
        ListNode listNode = new ListNode(value);
        ListNode cur = this.next;
        if (cur == null) {
            this.next = listNode;
            return;
        }
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = listNode;
    }

    public ListNode reverse() {
        ListNode cur = this.next;
        ListNode pre = null;
        ListNode t = null;
        while (cur != null) {
            t = cur.next;
            cur.next = pre;
            pre = cur;
            cur = t;
        }
        ListNode res = new ListNode();
        res.next = pre;
        return res;
    }

    @Override
    public String toString() {
        ListNode listNode = this.next;
        StringBuilder str = new StringBuilder();
        while (listNode != null) {
            if (listNode.next != null) {
                str.append(listNode.val).append("->");
            } else {
                str.append(listNode.val);
            }
            listNode = listNode.next;
        }
        return str.toString();
    }
}
