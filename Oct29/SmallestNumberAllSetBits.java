package Oct29;

public class SmallestNumberAllSetBits {
    public static int smallestNumber(int n) {
        for (int i = 0; i <= n; i++) {
            int z = 1 << i;
            if (z > n)
                return z - 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        int ans = smallestNumber(5);
        System.out.println(ans);
        System.out.println(1 << 3);
        System.out.println(20 >> 1);
    }
}