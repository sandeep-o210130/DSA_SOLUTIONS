import java.util.*;

class Solution {
    public String alienOrder(String[] words) {
        // Step 1: Build graph
        Map<Character, List<Character>> adj = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();

        // Initialize graph with all unique characters
        for (String word : words) {
            for (char c : word.toCharArray()) {
                adj.putIfAbsent(c, new ArrayList<>());
                inDegree.putIfAbsent(c, 0);
            }
        }

        // Step 2: Build edges by comparing adjacent words
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i], w2 = words[i + 1];

            // Edge case: prefix problem (invalid order)
            if (w1.length() > w2.length() && w1.startsWith(w2)) {
                return "";
            }

            int minLen = Math.min(w1.length(), w2.length());
            for (int j = 0; j < minLen; j++) {
                char c1 = w1.charAt(j), c2 = w2.charAt(j);
                if (c1 != c2) {
                    adj.get(c1).add(c2);
                    inDegree.put(c2, inDegree.get(c2) + 1);
                    break; // only first differing char matters
                }
            }
        }

        // Step 3: Topological Sort (Kahn’s BFS)
        Queue<Character> q = new LinkedList<>();
        for (char c : inDegree.keySet()) {
            if (inDegree.get(c) == 0) q.offer(c);
        }

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            char cur = q.poll();
            sb.append(cur);

            for (char nei : adj.get(cur)) {
                inDegree.put(nei, inDegree.get(nei) - 1);
                if (inDegree.get(nei) == 0) q.offer(nei);
            }
        }

        // Step 4: Check if topological order includes all nodes (cycle detection)
        if (sb.length() < inDegree.size()) return "";

        return sb.toString();
    }
}
