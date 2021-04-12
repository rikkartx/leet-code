/*
 * @lc app=leetcode id=2 lang=java
 *
 * [2] Add Two Numbers
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }

        ListNode head = new ListNode(0);
        ListNode node = head;
        int plus = 0;
        while(l1 != null || l2 != null || plus != 0) {
            int l1v = 0;
            int l2v = 0;
            if(l1 != null) {
                l1v = l1.val;
                l1 = l1.next;
            }
            if(l2 != null) {
                l2v = l2.val;
                l2 = l2.next;
            }

            int sum = plus + l1v + l2v;
            plus = sum / 10;
            node.next = new ListNode(sum % 10);
            node = node.next;
        }
        return head.next;
    }
}
// @lc code=end

class ListNode {
    int val;
    ListNode next;

    ListNode() {}
    ListNode(int val) {this.val = val;}
    ListNode(int val, ListNode next) {
        this.val = val; 
        this.next = next;
    }
}
