//This problem is nothing but Dijkstra in disguise.
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // Build adjacency list
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        for (int[] t : times) {
            graph.get(t[0]).add(new int[]{t[1], t[2]}); // {neighbor, weight}
        }

        // Min-heap for Dijkstra (node, time)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        pq.offer(new int[]{k, 0});

        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0], time = curr[1];

            if (time > dist[node]) continue;

            for (int[] nei : graph.get(node)) {
                int next = nei[0], newTime = time + nei[1];
                if (newTime < dist[next]) {
                    dist[next] = newTime;
                    pq.offer(new int[]{next, newTime});
                }
            }
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1; // unreachable
            ans = Math.max(ans, dist[i]);
        }
        return ans;
    }
}
