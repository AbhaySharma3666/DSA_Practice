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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        while(prev.next != null){
            ListNode curr = prev.next;
            if (curr.next != null && curr.val == curr.next.val) {
                int skipVal = curr.val;
                while (curr != null && curr.val == skipVal) {
                    curr = curr.next;
                }
                prev.next = curr;
            } else prev = prev.next;
        }
        return dummy.next;
    }
}