import java.util.*;

class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n : nums) sum += n;
        if (sum % 2 == 1) return false;
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int n : nums) {
            for (int t = target; t >= n; t--) dp[t] |= dp[t - n];
        }
        return dp[target];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.canPartition(new int[]{1, 5, 11, 5}));
        System.out.println(s.canPartition(new int[]{1, 2, 3, 5}));
    }
}
