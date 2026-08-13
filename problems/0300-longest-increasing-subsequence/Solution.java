import java.util.*;

class Solution {
    // tails[i] is the smallest tail of any increasing subsequence of length i + 1.
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for (int n : nums) {
            int lo = 0, hi = size;
            while (lo < hi) {
                int mid = (lo + hi) >>> 1;
                if (tails[mid] < n) lo = mid + 1;
                else hi = mid;
            }
            tails[lo] = n;
            if (lo == size) size++;
        }
        return size;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println(s.lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));
        System.out.println(s.lengthOfLIS(new int[]{7, 7, 7, 7, 7, 7, 7}));
    }
}
