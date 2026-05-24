import java.util.*;

class Solution {
    public int uniquePaths(int m, int n) {
        int[] row = new int[n];
        Arrays.fill(row, 1);
        for (int r = 1; r < m; r++) {
            for (int c = 1; c < n; c++) row[c] += row[c - 1];
        }
        return row[n - 1];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.uniquePaths(3, 7));
        System.out.println(s.uniquePaths(3, 2));
    }
}
