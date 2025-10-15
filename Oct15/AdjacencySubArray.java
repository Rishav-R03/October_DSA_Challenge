public class AdjacencySubArray {
    public static int maxAdjSubArray(int[] nums) {
        int cnt = 0, maxLen = 0, prevInc = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                cnt++;
            } else {
                prevInc = cnt;
                cnt = 1;
            }
            maxLen = Math.max(maxLen, Math.min(cnt, prevInc));
            maxLen = Math.max(maxLen, cnt / 2);
        }
        return maxLen;
    }

    public static void main(String [] args){
        int [] nums = {2,5,7,8,9,2,3,4,3,1};
        int ans = maxAdjSubArray(nums);
        System.out.println(ans);
    }
}