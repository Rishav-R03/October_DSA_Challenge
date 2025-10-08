
public class SuccessMatrix{
    public static int [] successfulPairs(int [] arr1, int success, int [] arr2){
        Arrays.sort(arr2);
        int m =  arr1.length;
        int n = arr2.length;

        for(int i = 0;i<m;i++){
            int idx = bs(arr2,arr1[i],success);
            if(idx != -1) ans[i] = arr2.length-idx;
        }
        return ans;
    }

    public int bs (int potions[],long strength, long success){
        int low = 0, high = potions.length-1,idx = -1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if((long) potions[mid] * strength >= success){
                idx = mid;
                high = mid-1;
            }else{
                low = mid + 1;
            }
        }
        return idx;
    }

    public static void main(String [] args){

    }
}