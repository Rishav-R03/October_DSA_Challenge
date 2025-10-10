package Oct10;

public class MaxEnergy {
    public static int maxEnergy(int[] magicians, int k) {
        int n = magicians.length;
        int ans = helper(0, n, magicians, k);
        return ans;
    }

    private static int helper(int i, int n, int[] magicians, int k) {
        int maxE = 0, curE = 0;
        if (i > n) {
            return maxE;
        }
        curE = curE + magicians[i];
        maxE = Math.max(helper(i + k, n, magicians, k), curE);
        return maxE;
    }

    public static void main(String[] args) {
        int[] mag = { 5, 2, -10, -5, 1 };
        int k = 3;
        int ans = maxEnergy(mag, k);
        System.out.println(ans);
    }
}
