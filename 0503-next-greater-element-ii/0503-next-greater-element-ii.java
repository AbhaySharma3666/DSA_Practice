import java.util.Stack;
import java.util.Arrays;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
    
        Arrays.fill(ans, -1); 
        
        Stack<Integer> stack = new Stack<>(); 
        
        // Loop twice to simulate the circular array
        for (int i = 0; i < 2 * n; i++) {
            int currentIndex = i % n;
            
            while (!stack.isEmpty() && nums[currentIndex] > nums[stack.peek()]) {
                int poppedIndex = stack.pop();
                ans[poppedIndex] = nums[currentIndex];
            }
            
            if (i < n) stack.push(currentIndex);
        }
        
        return ans;
    }
}