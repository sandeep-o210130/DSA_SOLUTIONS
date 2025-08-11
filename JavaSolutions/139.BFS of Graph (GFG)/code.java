class Solution {
    // Function to return Breadth First Search Traversal of given graph.
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> res = new ArrayList<>();
        boolean[] visited = new boolean[adj.size()];
        Queue<Integer> q = new LinkedList<>();
        // Start from node 0
        q.offer(0);
        visited[0] = true;
        while (!q.isEmpty()) {
            int node = q.poll();
            res.add(node);
            for (int n : adj.get(node)) {
                if (!visited[n]) {
                    q.offer(n);
                    visited[n] = true;
                }
            }
        }
        return res;
    }
}
