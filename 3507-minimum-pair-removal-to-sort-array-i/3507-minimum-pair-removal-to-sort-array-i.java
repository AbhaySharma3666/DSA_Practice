import java.util.ArrayList;
import java.util.List;

class Solution {
    public int minimumPairRemoval(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        
        int operations = 0;
        
        // Continue operating until the list becomes non-decreasing
        while (!isSorted(list)) {
            int minSum = Integer.MAX_VALUE;
            int minIndex = -1;
            
            // Find the adjacent pair with the minimum sum (leftmost is picked naturally)
            for (int i = 0; i < list.size() - 1; i++) {
                int currentSum = list.get(i) + list.get(i + 1);
                if (currentSum < minSum) {
                    minSum = currentSum;
                    minIndex = i;
                }
            }
            
            // Replace the chosen pair with their sum
            list.set(minIndex, minSum);
            list.remove(minIndex + 1);
            
            operations++;
        }
        
        return operations;
    }
    
    // Helper method to check if the list is non-decreasing
    private boolean isSorted(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
}