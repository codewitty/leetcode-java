import java.util.*;

class Solution {
    public boolean exist(char[][] board, String word) {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (dfs(board, word, 0, r, c)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] b, String w, int i, int r, int c) {
        if (i == w.length()) return true;
        if (r < 0 || c < 0 || r >= b.length || c >= b[0].length || b[r][c] != w.charAt(i)) return false;
        char saved = b[r][c];
        b[r][c] = '#';
        boolean found = dfs(b, w, i + 1, r + 1, c) || dfs(b, w, i + 1, r - 1, c)
                || dfs(b, w, i + 1, r, c + 1) || dfs(b, w, i + 1, r, c - 1);
        b[r][c] = saved;
        return found;
    }

    private static char[][] grid(String... rows) {
        return Arrays.stream(rows).map(String::toCharArray).toArray(char[][]::new);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        char[][] board = grid("ABCE", "SFCS", "ADEE");
        System.out.println(s.exist(board, "ABCCED"));
        System.out.println(s.exist(board, "SEE"));
        System.out.println(s.exist(board, "ABCB"));
    }
}
