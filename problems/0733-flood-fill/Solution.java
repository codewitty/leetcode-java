import java.util.*;

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int original = image[sr][sc];
        if (original != color) fill(image, sr, sc, original, color);
        return image;
    }

    private void fill(int[][] img, int r, int c, int from, int to) {
        if (r < 0 || c < 0 || r >= img.length || c >= img[0].length || img[r][c] != from) return;
        img[r][c] = to;
        fill(img, r + 1, c, from, to);
        fill(img, r - 1, c, from, to);
        fill(img, r, c + 1, from, to);
        fill(img, r, c - 1, from, to);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        System.out.println(Arrays.deepToString(s.floodFill(image, 1, 1, 2)));
    }
}
