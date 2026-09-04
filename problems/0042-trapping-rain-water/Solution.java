import java.util.*;

class Solution {
    // Two pointers: the lower side's max bounds the water at that side.
    public int trap(int[] height) {
        int lo = 0, hi = height.length - 1, leftMax = 0, rightMax = 0, water = 0;
        while (lo < hi) {
            if (height[lo] < height[hi]) {
                leftMax = Math.max(leftMax, height[lo]);
                water += leftMax - height[lo++];
            } else {
                rightMax = Math.max(rightMax, height[hi]);
                water += rightMax - height[hi--];
            }
        }
        return water;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(s.trap(new int[]{4, 2, 0, 3, 2, 5}));
    }
}
