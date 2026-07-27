class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        // split into 2 NodeLists
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //  Reverse 2nd ListNode
        ListNode prev = null;
        ListNode curr = slow.next;
        slow.next = null; 
        
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }

        // Merge both in zig-zag pattern
        ListNode first = head;
        ListNode second = prev; 
        
        while (second != null) {
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;

            first.next = second;
            second.next = tmp1;

            first = tmp1;
            second = tmp2;
        }
    }
}