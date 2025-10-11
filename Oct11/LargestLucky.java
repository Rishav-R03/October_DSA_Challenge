import java.util.HashMap;
import java.util.Map;

public class LargestLucky {
    public static int largestLuck(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : arr) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int largest = -1;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            int num = e.getKey();
            int freq = e.getValue();

            if (num == freq) {
                if (num > largest) {
                    largest = num;
                }
            }
        }
        return largest;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 2, 3, 4, 4, 4, 4 };
        int ans = largestLuck(arr);
        System.out.println(ans);
    }
}
