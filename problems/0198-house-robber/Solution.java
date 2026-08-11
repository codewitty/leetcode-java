import java.util.*;

class Solution {
    public int rob(int[] nums) {
        int prev = 0, cur = 0;
        for (int n : nums) {
            int next = Math.max(cur, prev + n);
            prev = cur;
            cur = next;
        }
        return cur;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.rob(new int[]{1, 2, 3, 1}));
        System.out.println(s.rob(new int[]{2, 7, 9, 3, 1}));
    }
}
