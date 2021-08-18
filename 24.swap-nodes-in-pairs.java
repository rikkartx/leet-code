/*
 * @lc app=leetcode id=24 lang=java
 *
 * [24] Swap Nodes in Pairs
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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode h = new ListNode();
        h.next = head;
        ListNode i = h;
        while(i.next != null && i.next.next != null) {
            ListNode first = i.next;
            ListNode sec = first.next;

            first.next = sec.next;
            sec.next = first;
            i.next = sec;

            i = first;
        }
        return h.next;
    }
}
// @lc code=end

