class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] result = {-1, -1};

        // A critical point requires at least 3 nodes
        if (head == null || head.next == null || head.next.next == null) {
            return result;
        }

        ListNode prev = head;
        ListNode curr = head.next;
        int currentIndex = 1; // treating head as index 0, so curr is index 1
        
        int firstCritical = -1;
        int lastCritical = -1;
        int minDistance = Integer.MAX_VALUE;

        // Traverse until curr is the second to last node
        while (curr.next != null) {
            // Check if it's a local maxima or local minima
            if ((curr.val > prev.val && curr.val > curr.next.val) || 
                (curr.val < prev.val && curr.val < curr.next.val)) {
                
                if (firstCritical == -1) {
                    // This is the very first critical point we've found
                    firstCritical = currentIndex;
                } else {
                    // Calculate minimum distance using the previous critical point
                    minDistance = Math.min(minDistance, currentIndex - lastCritical);
                }
                
                // Update the last seen critical point to the current one
                lastCritical = currentIndex;
            }
            
            // Move pointers forward
            prev = curr;
            curr = curr.next;
            currentIndex++;
        }

        // If we found at least two critical points, update the result array
        if (minDistance != Integer.MAX_VALUE) {
            result[0] = minDistance;
            result[1] = lastCritical - firstCritical; // Max distance is from first to last critical point
        }

        return result;
    }
}