class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int INF = (int)1e9;
        int[][] dist = new int[n][n];
        
        // 1. Initialize distances
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }
        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            dist[u][v] = w;
            dist[v][u] = w; // undirected
        }

        // 2. Floyd–Warshall relaxation
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // 3. Count reachable cities for each node
        int minReachable = Integer.MAX_VALUE;
        int result = -1;
        
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && dist[i][j] <= distanceThreshold) {
                    count++;
                }
            }
            // If tie, choose larger index
            if (count <= minReachable) {
                minReachable = count;
                result = i;
            }
        }
        
        return result;
    }
}
