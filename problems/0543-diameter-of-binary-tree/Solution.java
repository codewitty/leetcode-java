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
    private int best;

    public int diameterOfBinaryTree(TreeNode root) {
        best = 0;
        depth(root);
        return best;
    }

    private int depth(TreeNode n) {
        if (n == null) return 0;
        int l = depth(n.left), r = depth(n.right);
        best = Math.max(best, l + r);
        return Math.max(l, r) + 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.diameterOfBinaryTree(TreeNode.of(1, 2, 3, 4, 5)));
        System.out.println(s.diameterOfBinaryTree(TreeNode.of(1, 2)));
    }
}
