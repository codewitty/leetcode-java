import java.util.*;

class Solution {
    // Bucket sort by frequency: O(n).
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : nums) freq.merge(n, 1, Integer::sum);
        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) buckets.add(new ArrayList<>());
        for (Map.Entry<Integer, Integer> e : freq.entrySet()) buckets.get(e.getValue()).add(e.getKey());
        int[] out = new int[k];
        int idx = 0;
        for (int f = nums.length; f > 0 && idx < k; f--) {
            for (int n : buckets.get(f)) {
                if (idx == k) break;
                out[idx++] = n;
            }
        }
        return out;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
        System.out.println(Arrays.toString(s.topKFrequent(new int[]{1}, 1)));
    }
}
