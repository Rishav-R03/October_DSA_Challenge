
public class MinArea {
    public int minArea(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int min_i = 0;
        int max_i = m;
        int max_j = n;
        int min_j = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    min_i = Math.min(min_i, i);
                    min_j = Math.min(min_j, i);
                    max_i = Math.max(max_i, i);
                    max_j = Math.max(max_j, i);
                }
            }
        }
        return (max_i - min_i + 1) * (max_j - min_j + 1);
    }

    public static void main(String[] args) {

    }
}
