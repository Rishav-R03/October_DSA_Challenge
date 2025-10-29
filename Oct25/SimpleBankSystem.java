import java.util.Scanner;

class Main {
    public static int findBits(int x, int y) {
        int n = x ^ y;
        int count = 0;

        while (n != 0) {
            n = n & (n - 1);
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x = scanner.nextInt();

        int y = scanner.nextInt();

        System.out.println(x + " in binary is " + Integer.toBinaryString(x));
        System.out.println(y + " in binary is " + Integer.toBinaryString(y));

        System.out.println("The total number of bits to be flipped is " + findBits(x, y));

        scanner.close();
    }
}