import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // LinkedHashMap keeps groups in first-seen order.
        Map<String, List<String>> groups = new LinkedHashMap<>();
        for (String s : strs) {
            char[] key = s.toCharArray();
            Arrays.sort(key);
            groups.computeIfAbsent(new String(key), k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(groups.values());
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
