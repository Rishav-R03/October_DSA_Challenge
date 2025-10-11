import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Spells {
    public static long maxPower(int[] power) {
        if (power.length == 0)
            return 0;

        Arrays.sort(power);
        List<Integer> vals = new ArrayList<>();
        List<Long> earn = new ArrayList<>();

        for (int i = 0; i < power.length;) {
            int v = power[i];
            long sum = 0;
            while (i < power.length && power[i] == v) {
                sum += v;
                i++;
            }
            vals.add(v);
            System.out.println("v " + v);
            earn.add(sum);
            System.out.println("sum " + sum);
        }

        int n = vals.size();
        long[] dp = new long[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            int nextIdx = Collections.binarySearch(vals, vals.get(i) + 3);

            if (nextIdx < 0)
                nextIdx = -nextIdx - 1;
            System.out.println("nextIdx " + nextIdx);
            long take = earn.get(i) + dp[nextIdx];
            long skip = dp[i + 1];
            dp[i] = Math.max(take, skip);
            System.out.println("dp[i] " + dp[i]);
        }

        return dp[0];
    }

    public static void main(String[] args) {
        int arr[] = { 1, 1, 3, 4 };
        long ans = maxPower(arr);
        System.out.println("ans " + ans);
    }
}
