
public class RecursionInJava{
    // method 1
    public static String reverseString(String s){
        String res = "";
        char [] sToChar = s.toCharArray();
        for(int i = sToChar.length-1;i>-1;i--){
            res += sToChar[i];
        }
        return res;
    }
    // method 2
    public static String method2(String s){
        int l = 0;
        int r = s.length()-1;
        char [] charS = s.toCharArray();
        while(l < r){
            char temp = charS[l];
            charS[l] = charS[r];
            charS[r] = temp;
            l++;
            r--;
        }
        String ans = new String(charS);
        return ans;
    }
    // method 3
    public static String method3(String s){
        if(s.length() <=1){
            return s;
        }
        return method3(s.substring(1)) + s.charAt(0);
    }

    // method 4
    public static String method4(String s, int len){
        if(len < 1){
            return "";
        }
        if(len == 1){
            return String.valueOf(s.charAt(0));
        }
        return s.charAt(len-1) + method4(s,len-1);
    }

    public static int reverseInt(int num){
        int reversedNum = 0;
        while(num > 0){
            int digit = num%10;
            reversedNum = reversedNum *10 + digit;
            num = num/10;
        }
        return reversedNum;
    }
    public static void main(){
        String s = "Hello World";
        int n = s.length();
        String res = reverseString(s);
        System.out.println(res);
        String res1 = method2(s);
        System.out.println(res1);
        String res2 = method3(s);
        System.out.println(res2);
        String res3 = method4(s,n);
        System.out.println(res3);
        int res4 = reverseInt(123456);
        System.out.println(res4);

        System.out.println(12345/10);
    }
}