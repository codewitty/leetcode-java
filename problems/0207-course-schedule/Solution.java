import java.util.*;

class Solution {
    // Kahn's algorithm: a cycle leaves some course with nonzero indegree.
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());
        int[] indegree = new int[numCourses];
        for (int[] p : prerequisites) {
            graph.get(p[1]).add(p[0]);
            indegree[p[0]]++;
        }
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) if (indegree[i] == 0) q.add(i);
        int taken = 0;
        while (!q.isEmpty()) {
            int c = q.poll();
            taken++;
            for (int next : graph.get(c)) if (--indegree[next] == 0) q.add(next);
        }
        return taken == numCourses;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.canFinish(2, new int[][]{{1, 0}}));
        System.out.println(s.canFinish(2, new int[][]{{1, 0}, {0, 1}}));
    }
}
