class Solution {
    public int pairSum(ListNode head) {
        // Find the middle of the linked list
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        //  Reverse the second half of the list
        ListNode prev = null;
        ListNode curr = slow;
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        
        //  Calculate the maximum twin sum
        int maxTwinSum = 0;
        ListNode start = head;
        
        // 'prev' is now the head of the reversed second half
        while (prev != null) { 
            maxTwinSum = Math.max(maxTwinSum, start.val + prev.val);
            start = start.next;
            prev = prev.next;
        }
        
        return maxTwinSum;
    }
}