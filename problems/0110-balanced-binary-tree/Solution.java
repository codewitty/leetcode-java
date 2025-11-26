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
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    // Returns -1 as soon as any subtree is unbalanced.
    private int height(TreeNode n) {
        if (n == null) return 0;
        int l = height(n.left);
        if (l == -1) return -1;
        int r = height(n.right);
        if (r == -1) return -1;
        return Math.abs(l - r) > 1 ? -1 : Math.max(l, r) + 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isBalanced(TreeNode.of(3, 9, 20, null, null, 15, 7)));
        System.out.println(s.isBalanced(TreeNode.of(1, 2, 2, 3, 3, null, null, 4, 4)));
    }
}
