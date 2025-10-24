package Oct23;

public class HasSameDigits {
    public static boolean hasSameDigits(String num) {
        int i = 0;
        String res = "";
        while (num.length() > 2 && i < num.length() - 1) {
            res += (char) ((((num.charAt(i) - '0') + (num.charAt(i + 1) - '0')) % 10) + '0');
            i++;
            if (i == num.length() - 1) {
                num = res;
                i = 0;
                res = "";
            }
        }
        return num.length() == 2 && num.charAt(0) == num.charAt(1);
    }
}
