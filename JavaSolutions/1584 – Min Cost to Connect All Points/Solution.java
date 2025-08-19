class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean[] visited = new boolean[n];
        int[] minDist = new int[n];
        Arrays.fill(minDist, Integer.MAX_VALUE);

        // Start from node 0
        minDist[0] = 0;
        int result = 0;

        for (int i = 0; i < n; i++) {
            // Pick unvisited node with smallest dist
            int u = -1;
            for (int j = 0; j < n; j++) {
                if (!visited[j] && (u == -1 || minDist[j] < minDist[u])) {
                    u = j;
                }
            }

            visited[u] = true;
            result += minDist[u];

            // Update neighbors' distances
            for (int v = 0; v < n; v++) {
                if (!visited[v]) {
                    int cost = Math.abs(points[u][0] - points[v][0]) + 
                               Math.abs(points[u][1] - points[v][1]);
                    if (cost < minDist[v]) {
                        minDist[v] = cost;
                    }
                }
            }
        }

        return result;
    }
}
