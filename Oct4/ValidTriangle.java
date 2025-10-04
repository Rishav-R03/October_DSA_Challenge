import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ValidTriangle {
    public String triangleType(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums);
        for (int n : nums) {
            set.add(n);
        }
        if (nums[0] + nums[1] <= nums[2]) {
            return "none";
        }
        if (set.size() == 1) {
            return "equilateral";
        }
        if (set.size() == 2) {
            return "isosceles";
        }
        return "scalene";
    }
}
