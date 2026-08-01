import java.util.*;

class Solution {
    // Monotonic stack of indices still waiting for a warmer day.
    public int[] dailyTemperatures(int[] temperatures) {
        int[] out = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int j = stack.pop();
                out[j] = i - j;
            }
            stack.push(i);
        }
        return out;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
        System.out.println(Arrays.toString(s.dailyTemperatures(new int[]{30, 40, 50, 60})));
    }
}
