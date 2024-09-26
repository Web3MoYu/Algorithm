package org.lsh.alg.linkedList;

import java.util.HashMap;

public class C03_CopyRandomList {

    public static void main(String[] args) {
        ListNode listNode = new ListNode();
        listNode.addLast(1);
        listNode.addLast(2);
        listNode.addLast(3);
        listNode.addLast(4);
        System.out.println(listNode);
        System.out.println(copyRandomList2(listNode));
    }

    private static ListNode copyRandomList1(ListNode head) {

        ListNode cur = head;
        HashMap<ListNode, ListNode> map = new HashMap<>();
        while (cur != null) {
            map.put(cur, new ListNode());
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            ListNode oldListNode = map.get(cur);
            oldListNode.val = cur.val;
            oldListNode.next = map.get(cur.next);
            oldListNode.random = map.get(cur.random);
            cur = cur.next;
        }

        return map.get(head);
    }

    private static ListNode copyRandomList2(ListNode head) {
        if (head == null){
            return null;
        }

        ListNode cur = head;
        // 构建映射关系
        while (cur != null) {
            ListNode newListNode = new ListNode(cur.val);
            newListNode.next = cur.next;
            cur.next = newListNode;
            cur = cur.next.next;
        }
        // 构建random关系
        // 1->1'->2->2'
        cur = head;
        while (cur != null) {
            ListNode newListNode = cur.next;
            newListNode.random = cur.random == null ? null : cur.random.next;
            cur = cur.next.next;
        }

        // 恢复
        cur = head;
        ListNode ans = cur.next;
        while (cur != null && cur.next != null) {
            ListNode newListNode = cur.next;
            cur.next = cur.next.next;
            newListNode.next = newListNode.next == null ? null : newListNode.next.next;
            cur = cur.next;
        }
        return ans;
    }
}
