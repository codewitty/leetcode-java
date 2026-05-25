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
    private int pre;
    private Map<Integer, Integer> inIndex;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        pre = 0;
        inIndex = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) inIndex.put(inorder[i], i);
        return build(preorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int lo, int hi) {
        if (lo > hi) return null;
        TreeNode root = new TreeNode(preorder[pre++]);
        int mid = inIndex.get(root.val);
        root.left = build(preorder, lo, mid - 1);
        root.right = build(preorder, mid + 1, hi);
        return root;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(TreeNode.bfs(s.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7})));
    }
}
