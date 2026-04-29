import java.util.*;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i && !dp[i]; j++) {
                dp[i] = dp[j] && words.contains(s.substring(j, i));
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.wordBreak("leetcode", List.of("leet", "code")));
        System.out.println(s.wordBreak("applepenapple", List.of("apple", "pen")));
        System.out.println(s.wordBreak("catsandog", List.of("cats", "dog", "sand", "and", "cat")));
    }
}
