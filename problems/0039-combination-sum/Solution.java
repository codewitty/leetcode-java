import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> out = new ArrayList<>();
        backtrack(candidates, 0, target, new ArrayList<>(), out);
        return out;
    }

    private void backtrack(int[] cands, int start, int remaining, List<Integer> path, List<List<Integer>> out) {
        if (remaining == 0) {
            out.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < cands.length; i++) {
            if (cands[i] > remaining) continue;
            path.add(cands[i]);
            backtrack(cands, i, remaining - cands[i], path, out);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.combinationSum(new int[]{2, 3, 6, 7}, 7));
        System.out.println(s.combinationSum(new int[]{2, 3, 5}, 8));
    }
}
