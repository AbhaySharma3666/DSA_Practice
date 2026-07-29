import java.util.ArrayList;
import java.util.List;

// Divide & Conquer method - Time Complexity: O(N log k)

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        List<ListNode> arr = new ArrayList<>();
        for (ListNode list : lists) {
            arr.add(list);
        }

        //  Merge lists in pairs
        while (arr.size() > 1) {
            List<ListNode> nextLevel = new ArrayList<>();
            
            // Step through the list two at a time
            for (int i = 0; i < arr.size(); i += 2) {
                if (i + 1 < arr.size()) {
                    // Merge the pair and add to the next round
                    nextLevel.add(mergeTwoLists(arr.get(i), arr.get(i + 1)));
                } else {
                    // If there is an odd number of lists, carry the last one over
                    nextLevel.add(arr.get(i));
                }
            }
            
            // Overwrite our current list with the newly merged pairs
            arr = nextLevel;
        }

        return arr.get(0);
    }

    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        
        if (list1 != null) {
            curr.next = list1;
        } else {
            curr.next = list2;
        }
        
        return dummy.next;
    }
}