
public class RangeProductQueries{
    public static int [] productQueries(int n, int [][] queries){
//        int mod = 10e9 + 7;
        int ansL = queries.length;

        int powerElement = 1;
        while(powerElement < n){
            powers.add(powerElement);
            powerElement *= 2;
        }
        return powers;
    }
    public static void main(String [] args){
        int [][] queries = {{0,1},{2,2},{0,3}};
        int n = 15;
        int ans [] = productQueries(n,queries);
        System.out.println(ans);
    }
}