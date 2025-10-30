package Oct30;

import java.util.Scanner;

public class MinNumOp {
    public int minOps(int[] target) {
        final int n = target.length;
        int ans = target[0];
        for(int i = 1;i<n;i++){
            ans += Math.max(0,target[i]-target[i-1]);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        MinNumOp ob1 = new MinNumOp();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int out = ob1.minOps(arr);
        System.out.println(out);
        sc.close();
    }
}
