class Solution {
    private int manhattanDist(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int totalCost = 0;
        
        // Tracks the minimum distance from the current MST to each unvisited point
        int[] minDist = new int[n];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        boolean[] visited = new boolean[n];
        
        // Start from the first point
        minDist[0] = 0;
        
        for (int i = 0; i < n; i++) {
            // Find the unvisited node with the smallest distance to the MST
            int u = -1;
            for (int j = 0; j < n; j++) {
                if (!visited[j] && (u == -1 || minDist[j] < minDist[u])) {
                    u = j;
                }
            }
            
            // Add the cost and mark as visited
            visited[u] = true;
            totalCost += minDist[u];
            
            // Update distances for all remaining unvisited points
            for (int v = 0; v < n; v++) {
                if (!visited[v]) {
                    int dist = manhattanDist(points[u], points[v]);
                    if (dist < minDist[v]) {
                        minDist[v] = dist;
                    }
                }
            }
        }
        return totalCost;
    }
}