import java.util.*;

class Solution {
    // Boyer-Moore voting: the majority survives every cancellation.
    public int majorityElement(int[] nums) {
        int candidate = 0, count = 0;
        for (int n : nums) {
            if (count == 0) candidate = n;
            count += n == candidate ? 1 : -1;
        }
        return candidate;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.majorityElement(new int[]{3, 2, 3}));
        System.out.println(s.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }
}
