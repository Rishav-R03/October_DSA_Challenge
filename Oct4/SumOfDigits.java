public class SumOfDigits {
    public static int sumOfDigits(int n) {
        if (n < 10) {
            return n;
        }
        return (n % 10) + sumOfDigits(n / 10);
    }

    public static void main(String[] args) {
        int n = 12345;
        int ans = sumOfDigits(n);
        System.out.println(ans);
    }
}
