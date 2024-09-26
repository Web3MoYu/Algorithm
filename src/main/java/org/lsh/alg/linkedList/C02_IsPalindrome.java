package org.lsh.alg.linkedList;

import java.util.Objects;
import java.util.Stack;

/**
 * 回文链表
 * 有一个链表，给你一个数num，将其划分为小于num的放左边、等于的放中间、大于的放右边
 */
public class C02_IsPalindrome {

    public static void main(String[] args) {
        ListNode listNode = new ListNode();
        System.out.println(isPalindrome1(listNode) == isPalindrome2(listNode));
        System.out.println(listNode);
    }

    // 笔试写法
    private static boolean isPalindrome1(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        ListNode cur = head.next;
        while (cur != null) {
            stack.push(cur.value);
            cur = cur.next;
        }
        cur = head.next;
        while (cur != null) {
            if (!Objects.equals(cur.value, stack.pop())) {
                return false;
            }
            cur = cur.next;
        }
        return true;
    }

    // 面试写法
    private static boolean isPalindrome2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        if (head.next.next == null) {
            return true;
        }
        /*
         * 1
         * 1->2->1
         * 1->2->3->2->1
         * 1->1
         * 1->2->2->1
         */
        ListNode cur = head.next;
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode firstTail = slow; // 存储中点的前一个
        // 结束循环，此时fast来到尾部,slow来到中点的前一个
        cur = slow.next;
        slow.next = null;
        // 逆序
        slow = null;
        while (cur != null) {
            fast = cur.next;
            cur.next = slow;
            slow = cur;
            cur = fast;
        }
        fast = slow; // 存储尾节点
        // 逆序完成此时slow为尾节点,此时开始判断是否回文 1->2->2->1
        cur = head.next;
        boolean flag = true;
        while (cur != null && slow != null) {
            if (!Objects.equals(cur.value, slow.value)) {
                flag = false;
                break;
            }
            cur = cur.next;
            slow = slow.next;
        }
        // 结束循环后 1->2<-2<-1 1->2->3<-2<-1
        cur = fast;
        slow = null;
        // 右边恢复
        while (cur != null) {
            fast = cur.next;
            cur.next = slow;
            slow = cur;
            cur = fast;
        }
        // 连接左右
        firstTail.next = slow;
        return flag;
    }
}
