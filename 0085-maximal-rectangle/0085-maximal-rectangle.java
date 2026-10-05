class Solution {
    public int largestRectangleArea(int[] arr) {
        int n = arr.length;
        int[] nse = new int[n];
        Stack<Integer> st = new Stack<>();

        // 1. Next Smaller Element (NSE)
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) st.pop();
            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        st.clear();

        // 2. Previous Smaller Element (PSE)
        int[] pse = new int[n];
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) st.pop();
            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        // 3. Compute maximum area
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int width = nse[i] - pse[i] - 1;
            maxArea = Math.max(maxArea, arr[i] * width);
        }

        return maxArea;
    }

    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int[] heights = new int[n];
        int max = 0;

        for (int i = 0; i < m; i++) {
            // Update the histogram height for each column
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') heights[j] += 1;
                else heights[j] = 0; // Ground level resets on '0'
            }
            // Run histogram calculation for the current row
            max = Math.max(max, largestRectangleArea(heights));
        }

        return max;
    }
}