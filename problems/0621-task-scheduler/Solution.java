import java.util.*;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char t : tasks) count[t - 'A']++;
        int max = 0, maxCount = 0;
        for (int c : count) {
            if (c > max) {
                max = c;
                maxCount = 1;
            } else if (c == max) {
                maxCount++;
            }
        }
        // (max - 1) full frames of n + 1 slots, then the tasks tied for max.
        return Math.max(tasks.length, (max - 1) * (n + 1) + maxCount);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.leastInterval("AAABBB".toCharArray(), 2));
        System.out.println(s.leastInterval("ACABDB".toCharArray(), 1));
        System.out.println(s.leastInterval("AAABBB".toCharArray(), 3));
    }
}
