class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        // sum of 0 to n
        int sum = (n*(n+1))/2; 
        int arrsum= 0;
        for(int ele : nums){
            arrsum += ele;
        }
        return sum - arrsum;
    }
}