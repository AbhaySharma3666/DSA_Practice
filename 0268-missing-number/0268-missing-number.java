class Solution {
    public int missingNumber(int[] nums) {
        int i = 0;
        int n = nums.length;
    
        while (i < n) {
            // Correct position is nums[i] == i
            // Only swap if the number is within [0, n-1] 
            // AND it's not already in the correct place
            if (nums[i] < n && nums[i] != i) {
                swap(nums, i, nums[i]);
            } else i++;
        }
    
        // After sorting, the index where nums[i] != i is your missing number
        for (int j = 0; j < n; j++) if (nums[j] != j) return j;
    
        return n;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
