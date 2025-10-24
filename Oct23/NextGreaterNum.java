package Oct23;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class NextGreaterNum {
    public int nextBeautiful(int n) {
        List<Integer> list = new ArrayList<>();
        generate(0, new int[0], list);

        Collections.sort(list);
        for (int num : list) {
            if (num > n)
                return num;
        }
        return -1;
    }

    private void generate(long num, int[] count, List<Integer> list) {
        if (num > 0 && isBeautiful(count)) {
            list.add((int) num);
        }
        if (num > 12224444)
            return;

        for (int d = 1; d <= 7; d++) {
            if (count[d] < d) {
                count[d]++;
                generate(num * 10 + d, count, list);
                count[d]--;
            }
        }
    }

    public boolean isBeautiful(int[] count) {
        for (int d = 1; d <= 7; d++) {
            if (count[d] != 0 && count[d] != d)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        NextGreaterNum ng = new NextGreaterNum();
        int n = 1000;
        int ans = ng.nextBeautiful(n);
        System.out.println(ans);
    }
}
