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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode fast = head;
        ListNode first = head;
        ListNode second = head;

        // Move fast to the k-th node
        for (int i = 1; i < k; i++) {
            fast = fast.next;
        }
        
        // 'first' now points to the k-th node from the start
        first = fast;
    
        while (fast.next != null) {
            fast = fast.next;
            second = second.next;
        }

        // Swap
        int temp = first.val;
        first.val = second.val;
        second.val = temp;

        return head;
        // ListNode slow = head;
        // ListNode fast = head;
        // for(int i=1;i<=k;i++) {fast = fast.next;}

        // while(fast!=null){
        //     slow = slow.next;
        //     fast = fast.next;
        // }

        // fast = head;
        // for(int i=1;i<=k-1;i++) fast = fast.next;

        // int temp = fast.val;
        // fast.val = slow.val;
        // slow.val = temp;

        // return head;
    }
}