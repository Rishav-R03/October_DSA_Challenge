import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

public class SwimInRise {

    public static int maxTime(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int[][] dirs = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
        Set<String> seen = new HashSet<>();

        pq.offer(new int[] { grid[0][0], 0, 0 });
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int max_d = cur[0], r = cur[1], c = cur[2];
            String key = r + "," + c;
            if (seen.contains(key))
                continue;
            seen.add(key);

            if (r == m - 1 && c == n - 1)
                return max_d;

            for (int[] dir : dirs) {
                int nr = r + dir[0], nc = c + dir[1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && !seen.contains(nr + "," + nc)) {
                    int newD = Math.max(grid[nr][nc], max_d);
                    pq.offer(new int[] { newD, nr, nc });
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows...");
        int m = sc.nextInt();
        System.out.println("Enter number of cols...");
        int n = sc.nextInt();
        System.out.println("Enter grid...");
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        int ans = maxTime(grid);
        System.out.println("Minimum time required: " + ans);
        sc.close();
    }
}