package org.lsh.alg.linkedList;

public class C04_Partition {

    public static void main(String[] args) {
        Node node = new Node();
        node.addLast(1);
        node.addLast(2);
        node.addLast(5);
        node.addLast(5);
        node.addLast(4);
        node.addLast(5);
        node.addLast(6);
        System.out.println(partition1(node, 5));
        System.out.println(partition2(node, 5));
    }


    private static Node partition2(Node head, int num) {

        if (head == null) {
            return null;
        }

        // 创建三个区间的头尾
        Node lh = null, lt = null;
        Node eh = null, et = null;
        Node bh = null, bt = null;

        // 遍历链表
        Node cur = head.next;
        Node next = null;
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

    private static Node partition1(Node head, int num) {

        if (head == null) {
            return null;
        }

        // 获取长度
        Node cur = head.next;
        int len = 0;
        while (cur != null) {
            len++;
            cur = cur.next;
        }

        // 构建Node[]
        Node[] arr = new Node[len];
        cur = head.next;
        for (int i = 0; i < len && cur != null; i++, cur = cur.next) {
            arr[i] = cur;
        }

        solve(arr, num);
        // 串起来
        Node ans = arr[0];
        for (int i = 1; i < arr.length; i++) {
            arr[i].next = null;
            ans.next = arr[i];
            ans = arr[i];
        }
        return head;
    }

    private static void solve(Node[] arr, int num) {
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

    private static void swap(Node[] arr, int i, int j) {
        Node t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}