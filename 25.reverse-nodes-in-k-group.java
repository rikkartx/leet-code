/*
 * @lc app=leetcode id=25 lang=java
 *
 * [25] Reverse Nodes in k-Group
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        return reverseKGroupWithoutCache(head, k);
    }

    public ListNode reverseKGroupUsingCache(ListNode head, int k) {
        if(head == null || head.next == null || k <= 1) {
            return head;
        }
        ListNode dummy = new ListNode();
        int n = 0;
        ListNode[] queue = new ListNode[k];
        ListNode node = head;
        ListNode prev = null;
        while (node != null) {
            queue[n++] = node;
            node = node.next;
            if(n == k) {
                for (int i = 0; i <= n - 1; i++) {
                    queue[i].next = i == 0 ? node : queue[i - 1];
                }
                if(dummy.next == null) {
                    dummy.next = queue[n - 1];
                }
                if(prev != null) {
                    prev.next = queue[n - 1];
                }
                prev = queue[0];
                n = 0;
            }
        }
        return dummy.next;
    }

    public ListNode reverseKGroupWithoutCache(ListNode head, int k) {
        if(head == null || head.next == null || k <= 1) {
            return head;
        }
        ListNode dummy = new ListNode();
        int n = 0;
        ListNode node = head;
        ListNode subListHead = head;
        ListNode prev = null;
        while (node != null) {
            n++;
            node = node.next;
            if(n == k) {
                ListNode reversed = reverse(subListHead, node, k);
                if(dummy.next == null) {
                    dummy.next = reversed;
                }
                if(prev != null) {
                    prev.next = reversed;
                }
                prev = subListHead;
                subListHead = subListHead.next;
                n = 0;
            }
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode head, ListNode tailNext, int k) {
        ListNode prev = null;
        int count = k;
        while(count > 0) {
            ListNode next = head.next;
            head.next = count == k ? tailNext : prev;
            prev = head;
            head = next;
            count--;
        }
        return prev;
    }
}
// @lc code=end

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
