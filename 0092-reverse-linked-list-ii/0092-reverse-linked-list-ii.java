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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Move `prev` to the node just before position `left`
        ListNode prev = dummy;
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }

        // `curr` points to the starting node of the sublist to reverse
        ListNode curr = prev.next;

        // in-place node swapping
        for (int i = 0; i < right - left; i++) {
            ListNode subNext = curr.next;
            curr.next = subNext.next;
            subNext.next = prev.next;
            prev.next = subNext;
        }

        return dummy.next;
    }
}