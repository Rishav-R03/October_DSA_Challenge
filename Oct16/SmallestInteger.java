package Oct16;

public class SmallestInteger {
    public static int findSmallest(int [] nums, int value){
       int [] rc = new int[value]; 
       for(int n : nums){
        int rem = ((n%value)+value)%value;
        rc[rem]++;
       } 
       int res = 0;
       while(rc[res%value]>0){
        rc[res%value]--;
        res++;
       }
       return res;
    }

    public static void main(String[] args){
        int [] nums = {1,-10,7,13,6,8};
        int ans = findSmallest(nums, 5);
        System.out.println(ans);
    }
}
