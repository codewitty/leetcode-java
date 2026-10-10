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

class Codec {
    // Preorder with "#" for null children.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        write(root, sb);
        return sb.toString();
    }

    private void write(TreeNode n, StringBuilder sb) {
        if (n == null) {
            sb.append("#,");
            return;
        }
        sb.append(n.val).append(',');
        write(n.left, sb);
        write(n.right, sb);
    }

    public TreeNode deserialize(String data) {
        return read(new ArrayDeque<>(Arrays.asList(data.split(","))));
    }

    private TreeNode read(Deque<String> tokens) {
        String t = tokens.poll();
        if (t.equals("#")) return null;
        TreeNode n = new TreeNode(Integer.parseInt(t));
        n.left = read(tokens);
        n.right = read(tokens);
        return n;
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        String data = codec.serialize(TreeNode.of(1, 2, 3, null, null, 4, 5));
        System.out.println(data);
        System.out.println(TreeNode.bfs(codec.deserialize(data)));
    }
}
