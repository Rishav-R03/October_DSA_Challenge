package Oct16;

public class StrongPairs {
    public static int findStrongPairs(int[] nums) {
        int maxStrength = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs(nums[i] - nums[j]) <= Math.min(nums[i], nums[j])) {
                    maxStrength = Math.max(maxStrength, nums[i] ^ nums[j]);
                }
            }
        }
        return maxStrength;
    }

    public static void main(String[] args) {
        int nums [] = {1,2,3,4,5};
        int ans = findStrongPairs(nums);
        System.out.println(ans);
    }
}
