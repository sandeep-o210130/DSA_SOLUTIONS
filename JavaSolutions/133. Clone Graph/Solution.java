/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    // A HashMap to map the original node's value (Integer) to its cloned node (Node).
    HashMap<Integer,Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if(node == null) return null;

        if(map.containsKey(node.val)){ //means it has been visited
            return map.get(node.val);
        }

        Node copiedNode = new Node(node.val);
        map.put(node.val, copiedNode);

        for(Node neighbor: node.neighbors) {
            copiedNode.neighbors.add(cloneGraph(neighbor));
        }

        return copiedNode;
    }
}
