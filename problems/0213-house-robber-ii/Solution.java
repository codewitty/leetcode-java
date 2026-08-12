import java.util.*;

class Solution {
    // The first and last house are adjacent, so rob one of two straight ranges.
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }

    private int rob(int[] nums, int lo, int hi) {
        int prev = 0, cur = 0;
        for (int i = lo; i <= hi; i++) {
            int next = Math.max(cur, prev + nums[i]);
            prev = cur;
            cur = next;
        }
        return cur;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.rob(new int[]{2, 3, 2}));
        System.out.println(s.rob(new int[]{1, 2, 3, 1}));
        System.out.println(s.rob(new int[]{1, 2, 3}));
    }
}
