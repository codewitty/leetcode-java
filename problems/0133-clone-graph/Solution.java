import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors = new ArrayList<>();

    Node(int val) { this.val = val; }
}

class Solution {
    private final Map<Node, Node> copies = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Node copy = copies.get(node);
        if (copy != null) return copy;
        copy = new Node(node.val);
        copies.put(node, copy);
        for (Node n : node.neighbors) copy.neighbors.add(cloneGraph(n));
        return copy;
    }

    public static void main(String[] args) {
        Node[] nodes = new Node[5];
        for (int i = 1; i <= 4; i++) nodes[i] = new Node(i);
        int[][] adj = {{}, {2, 4}, {1, 3}, {2, 4}, {1, 3}};
        for (int i = 1; i <= 4; i++) for (int j : adj[i]) nodes[i].neighbors.add(nodes[j]);

        Node clone = new Solution().cloneGraph(nodes[1]);
        System.out.println(clone != nodes[1]);
        System.out.println(clone.neighbors.get(0).val + " " + clone.neighbors.get(1).val);
        System.out.println(clone.neighbors.get(0).neighbors.get(0) == clone);
    }
}
