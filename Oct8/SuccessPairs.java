import java.util.Arrays;

public class SuccessPairs {
    public static int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length;
        int ans[] = new int[n];

        for (int i = 0; i < n; i++) {
            int idx = bs(potions, spells[i], success);
            if (idx != -1) ans[i] = potions.length - idx;
        }

        return ans;
    }

    public static int bs(int potions[], long strength, long success) {
        int low = 0, high = potions.length - 1, idx = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if ((long) potions[mid] * strength >= success) {
                idx = mid;
                high = mid - 1; // find smaller index
            } else {
                low = mid + 1;
            }
        }
        return idx;
    }

    public static void main(String [] args){
        int [] ans = new int[3];
        int spells [] = {5,1,3};
        int potions [] = {1,2,3,4,5};
        int success = 7;
        ans = successfulPairs(spells,potions,success);
        System.out.println("Successful Pairs: " );
        for(int i = 0;i<3;i++){
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }
}