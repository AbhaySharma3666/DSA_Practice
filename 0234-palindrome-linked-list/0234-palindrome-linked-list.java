class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        
        // 1. Find the middle of the linked list
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // 2. Reverse the second half of the list
        ListNode prev = null;
        ListNode curr = slow;
        
        while (curr != null) {
            ListNode nextTemp = curr.next; // Store next node
            curr.next = prev;              // Reverse the link
            prev = curr;                   // Move prev forward
            curr = nextTemp;               // Move curr forward
        }
        
        // 3. Compare the first and second half nodes
        ListNode left = head;
        ListNode right = prev; 
        
        while (right != null) {
            if (left.val != right.val) return false; 
            left = left.next;
            right = right.next;
        }
        return true;
    }
}