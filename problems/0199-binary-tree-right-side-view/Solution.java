import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) { this.val = val; }

    // Builds a tree from LeetCode's level-order array format.
    static TreeNode of(Integer... vals) {
        if (vals.length == 0 || vals[0] == null) return null;
        TreeNode root = new TreeNode(vals[0]);
        Deque<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        int i = 1;
        while (i < vals.length) {
            TreeNode cur = q.poll();
            if (vals[i] != null) { cur.left = new TreeNode(vals[i]); q.add(cur.left); }
            i++;
            if (i < vals.length && vals[i] != null) { cur.right = new TreeNode(vals[i]); q.add(cur.right); }
            i++;
        }
        return root;
    }

    static List<Integer> bfs(TreeNode root) {
        List<Integer> out = new ArrayList<>();
        Deque<TreeNode> q = new ArrayDeque<>();
        if (root != null) q.add(root);
        while (!q.isEmpty()) {
            TreeNode n = q.poll();
            out.add(n.val);
            if (n.left != null) q.add(n.left);
            if (n.right != null) q.add(n.right);
        }
        return out;
    }
}

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> out = new ArrayList<>();
        dfs(root, 0, out);
        return out;
    }

    // Visit right first, so the first node seen at each depth is the rightmost.
    private void dfs(TreeNode n, int depth, List<Integer> out) {
        if (n == null) return;
        if (depth == out.size()) out.add(n.val);
        dfs(n.right, depth + 1, out);
        dfs(n.left, depth + 1, out);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.rightSideView(TreeNode.of(1, 2, 3, null, 5, null, 4)));
        System.out.println(s.rightSideView(TreeNode.of(1, 2, 3, 4, null, null, null, 5)));
    }
}
