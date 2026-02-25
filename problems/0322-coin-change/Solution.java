import java.util.*;

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int a = 1; a <= amount; a++) {
            for (int c : coins) if (c <= a) dp[a] = Math.min(dp[a], dp[a - c] + 1);
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(s.coinChange(new int[]{2}, 3));
        System.out.println(s.coinChange(new int[]{1}, 0));
    }
}
