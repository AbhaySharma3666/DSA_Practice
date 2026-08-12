class Solution {
    public int checkNextGreaterElement(int num, int[] nums2) {
        int indexInNums2 = -1;
        
        // Step 1: Find where 'num'
        for (int i = 0; i < nums2.length; i++) {
            if (nums2[i] == num) {
                indexInNums2 = i;
                break;
            }
        }
        
        // Step 2: Look for the next greater element
        for (int i = indexInNums2 + 1; i < nums2.length; i++) {
            if (nums2[i] > num) return nums2[i];
        }
        return -1;
    }
    
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = checkNextGreaterElement(nums1[i], nums2);
        }
        return ans;
    }
}