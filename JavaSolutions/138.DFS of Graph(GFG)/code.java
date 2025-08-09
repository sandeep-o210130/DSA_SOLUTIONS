class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size(); // number of vertices
        boolean[] visited = new boolean[n]; // visited tracker
        ArrayList<Integer> res = new ArrayList<>(); // store traversal

        // start DFS from vertex 0 (given in problem)
        findDFS(0, adj, visited, res);

        return res;
    }

    // Recursive DFS helper
    private void findDFS(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> res) {
        visited[node] = true;  // mark current node as visited
        res.add(node);         // record the node in the result

        // traverse all neighbors in given order
        for (int neighbour : adj.get(node)) {
            if (!visited[neighbour]) { // only visit unvisited nodes
                findDFS(neighbour, adj, visited, res); // recursive dive
            }
        }
    }
}
