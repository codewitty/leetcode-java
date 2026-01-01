import java.util.*;

class Solution {
    // Max-heap of size k keeps the k closest seen so far.
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> dist(b) - dist(a));
        for (int[] p : points) {
            heap.add(p);
            if (heap.size() > k) heap.poll();
        }
        return heap.toArray(new int[0][]);
    }

    private static int dist(int[] p) {
        return p[0] * p[0] + p[1] * p[1];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.deepToString(s.kClosest(new int[][]{{1, 3}, {-2, 2}}, 1)));
    }
}
