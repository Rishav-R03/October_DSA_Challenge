import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PacificAtlantic {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        if (heights[0].length == 0 || heights.length == 0 || heights == null) {
            return res;
        }
        int m = heights.length, n = heights[0].length;

        boolean[][] pac = new boolean[m][n];
        boolean[][] atl = new boolean[m][n];

        Queue<int[]> pq = new LinkedList<>();
        for (int j = 0; j < n; j++) {
            pq.offer(new int[] { 0, j });
            pac[0][j] = true;
        }
        for (int i = 1; i < m; i++) {
            pq.offer(new int[] { i, 0 });
            pac[i][0] = true;
        }
        bfs(heights, pq, pac);

        Queue<int[]> aq = new LinkedList<>();
        for (int j = 0; j < n; j++) {
            aq.offer(new int[] { m - 1, j });
            atl[m - 1][j] = true;
        }
        for (int i = 0; i < m - 1; i++) {
            aq.offer(new int[] { i, n - 1 });
            atl[i][n - 1] = true;
        }

        bfs(heights, aq, atl);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pac[i][j] && atl[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    public void bfs(int[][] heights, Queue<int[]> q, boolean[][] visited) {
        int m = heights.length, n = heights[0].length;
        int[][] dirs = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];
            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                if (nr < 0 || nr >= m || nc < 0 || nc >= n)
                    continue;
                if (visited[nr][nc])
                    continue;
                if (heights[nr][nc] < heights[r][c])
                    continue;
                visited[nr][nc] = true;
                q.offer(new int[] { nr, nc });
            }
        }
    }
}
