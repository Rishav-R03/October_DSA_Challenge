import java.util.HashSet;
import java.util.Set;

public class MaxErasure {
    public static int maxSubArray(int[] arr) {
        int left = 0, curSum = 0, maxSum = 0;
        Set<Integer> set = new HashSet<>();
        for (int right = 0; right < arr.length; right++) {
            while (set.contains(arr[right])) {
                set.remove(arr[left]);
                curSum -= arr[left];
                left++;
            }
            set.add(arr[right]);
            curSum += arr[right];
            maxSum = Math.max(maxSum, curSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int arr[] = { 4, 2, 4, 5, 6 };
        int ans = maxSubArray(arr);
        System.out.println(ans);
    }
}
