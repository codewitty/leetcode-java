import java.util.*;

class Solution {
    public int maxArea(int[] height) {
        int lo = 0, hi = height.length - 1, best = 0;
        while (lo < hi) {
            best = Math.max(best, (hi - lo) * Math.min(height[lo], height[hi]));
            if (height[lo] < height[hi]) lo++;
            else hi--;
        }
        return best;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(s.maxArea(new int[]{1, 1}));
    }
}
