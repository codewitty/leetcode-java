import java.util.*;

class Solution {
    // Dutch national flag: [0, lo) zeros, [lo, mid) ones, (hi, end] twos.
    public void sortColors(int[] nums) {
        int lo = 0, mid = 0, hi = nums.length - 1;
        while (mid <= hi) {
            if (nums[mid] == 0) swap(nums, lo++, mid++);
            else if (nums[mid] == 2) swap(nums, mid, hi--);
            else mid++;
        }
    }

    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {2, 0, 2, 1, 1, 0};
        s.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
