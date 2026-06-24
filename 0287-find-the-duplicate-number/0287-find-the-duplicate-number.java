class Solution {
    public int findDuplicate(int[] nums) {
        // Phase 1: Detect the cycle
        int slow = nums[0];
        int fast = nums[nums[0]];
        
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        
        // Phase 2: Find the entrance to the cycle
        slow = 0; // Reset slow to the start
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        
        return slow; // This is the duplicate
    }
}