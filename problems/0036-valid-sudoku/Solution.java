import java.util.*;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char v = board[r][c];
                if (v == '.') continue;
                if (!seen.add(v + " row " + r)
                        || !seen.add(v + " col " + c)
                        || !seen.add(v + " box " + r / 3 + "-" + c / 3)) return false;
            }
        }
        return true;
    }

    private static char[][] grid(String... rows) {
        return Arrays.stream(rows).map(String::toCharArray).toArray(char[][]::new);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        char[][] board = grid("53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1",
                "7...2...6", ".6....28.", "...419..5", "....8..79");
        System.out.println(s.isValidSudoku(board));
        board[0][0] = '8';
        System.out.println(s.isValidSudoku(board));
    }
}
