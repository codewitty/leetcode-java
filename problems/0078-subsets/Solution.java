import java.util.*;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> out = new ArrayList<>();
        out.add(new ArrayList<>());
        for (int n : nums) {
            for (int i = 0, size = out.size(); i < size; i++) {
                List<Integer> next = new ArrayList<>(out.get(i));
                next.add(n);
                out.add(next);
            }
        }
        return out;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.subsets(new int[]{1, 2, 3}));
    }
}
