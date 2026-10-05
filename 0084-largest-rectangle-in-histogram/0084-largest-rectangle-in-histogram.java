import java.util.Stack;

class Solution {
    public int largestRectangleArea(int[] arr) {
        int n = arr.length;
        int[] nse = new int[n];

        Stack<Integer> st = new Stack<>();
        
        // 1. Find Next Smaller Element (NSE) from right to left
        for (int i = n - 1; i >= 0; i--) {
            while (st.size() > 0 && arr[st.peek()] >= arr[i]) 
                st.pop();

            if (st.size() == 0) nse[i] = n;
            else nse[i] = st.peek();
            st.push(i);
        }

        // Clear the stack for reuse
        while (st.size() > 0) st.pop();

        int[] pse = new int[n];
        
        // 2. Find Previous Smaller Element (PSE) from left to right
        for (int i = 0; i < n; i++) {
            while (st.size() > 0 && arr[st.peek()] >= arr[i])
                st.pop();

            if (st.size() == 0) pse[i] = -1;
            else pse[i]= st.peek();

            st.push(i);
        }

        // 3. Calculate max area
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int area = arr[i] * (nse[i] - pse[i] - 1);
            maxArea = Math.max(maxArea, area);
        }
        
        return maxArea;
    }
}