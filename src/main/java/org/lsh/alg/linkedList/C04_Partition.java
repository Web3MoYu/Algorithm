package org.lsh.alg.linkedList;

public class C04_Partition {

    public static void main(String[] args) {
        ListNode listNode = new ListNode();
        listNode.addLast(1);
        listNode.addLast(2);
        listNode.addLast(5);
        listNode.addLast(5);
        listNode.addLast(4);
        listNode.addLast(5);
        listNode.addLast(6);
        System.out.println(partition1(listNode, 5));
        System.out.println(partition2(listNode, 5));
    }


    private static ListNode partition2(ListNode head, int num) {

        if (head == null) {
            return null;
        }

        // 创建三个区间的头尾
        ListNode lh = null, lt = null;
        ListNode eh = null, et = null;
        ListNode bh = null, bt = null;

        // 遍历链表
        ListNode cur = head.next;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = null;
            if (cur.value < num) {
                if (lh == null) {
                    lh = cur;
                } else {
                    lt.next = cur;
                }
                lt = cur;
            } else if (cur.value == num) {
                if (eh == null) {
                    eh = cur;
                } else {
                    et.next = cur;
                }
                et = cur;
            } else {
                if (bh == null) {
                    bh = cur;
                } else {
                    bt.next = cur;
                }
                bt = cur;
            }
            cur = next;
        }
        // 如果小于区存在
        if (lt != null) {
            lt.next = eh; // 连等于区
            // 判断谁去连大于区，如果et为空则lt连，否则et连
            et = et == null ? lt : et;
        }
        // 连大于区
        if (et != null) {
            et.next = bh;
        }
        if (lh != null) {
            head.next = lh;
        } else {
            if (eh != null) {
                head.next = eh;
            } else {
                head.next = bh;
            }
        }
        return head;
    }

    private static ListNode partition1(ListNode head, int num) {

        if (head == null) {
            return null;
        }

        // 获取长度
        ListNode cur = head.next;
        int len = 0;
        while (cur != null) {
            len++;
            cur = cur.next;
        }

        // 构建Node[]
        ListNode[] arr = new ListNode[len];
        cur = head.next;
        for (int i = 0; i < len && cur != null; i++, cur = cur.next) {
            arr[i] = cur;
        }

        solve(arr, num);
        // 串起来
        ListNode ans = arr[0];
        for (int i = 1; i < arr.length; i++) {
            arr[i].next = null;
            ans.next = arr[i];
            ans = arr[i];
        }
        return head;
    }

    private static void solve(ListNode[] arr, int num) {
        int less = -1;
        int more = arr.length;
        int i = 0;
        while (i < more) {
            if (arr[i].value < num) {
                swap(arr, ++less, i++);
            } else if (arr[i].value > num) {
                swap(arr, i, --more);
            } else {
                i++;
            }
        }
    }

    private static void swap(ListNode[] arr, int i, int j) {
        ListNode t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}