public class ReverseInteger {
    public static int reverseInteger(int n) {
        int reversedNum = 0;

        while (n > 0) {
            int firstDigit = n % 10;
            reversedNum = reversedNum * 10 + firstDigit;
            n = n / 10;
        }
        if (reversedNum < Integer.MIN_VALUE || reversedNum > Integer.MAX_VALUE) {
            return 0;
        }
        return reversedNum;
    }

    public static void main(String[] args) {
        int n = 12345;
        int ans = reverseInteger(n);
        System.out.println(ans);
    }
}
