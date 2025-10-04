import java.util.ArrayList;
import java.util.List;

public class Nqueens {
    static List<List<Integer>> nQueens(int n) {
        List<List<Integer>> res = new ArrayList<>();
        int[] cols = new int[n];
        solve(0, n, cols, res);
        return res;
    }

    // recursive backtracking
    private static void solve(int row, int n, int[] cols, List<List<Integer>> res) {
        if (row == n) {
            List<Integer> sol = new ArrayList<>();
            for (int col : cols) {
                sol.add(col + 1);
            }
            res.add(sol);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(row, col, cols)) {
                cols[row] = col;
                solve(row + 1, n, cols, res);
            }
        }
    }

    private static boolean isSafe(int row, int col, int[] cols) {
        for (int prevRow = 0; prevRow < row; prevRow++) {
            int prevCol = cols[prevRow];
            if (prevCol == col) {
                return false;
            }
            if (Math.abs(row - prevRow) == Math.abs(col - prevCol)) {
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        int n = 4;
        List<List<Integer>> res = nQueens(n);
        for (List<Integer> ans : res) {
            for (int i : ans) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}