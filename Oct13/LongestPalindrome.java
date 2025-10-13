public class LongestPalindrome{
    public static int longestPalindrome(Strng [] words){
        Map<String,Integer> map = new HashMap<>();
        for(String w : words){
            map.put(w,map.getOrDefault(w,0)+1);
        }
        int count = 0, alreadyP = 0;
        for(Map.Entry<String,Integer> e : map.entrySet()){
            String w = e.getKey();
            Integer f = e.getValue();
            String s = new StringBuilder(w).reverse().toString();
            if(w.equals(s)){
                count += (f/2)*4;
                if(f%2==1){
                    alreadyP = 1;
                }
            }else if(w.compareTo(s) < 0 && map.containsKey(s)){
                count += Math.min(f,map.get(s))*4;
            }
        }
        return count + alreadyP*2;

    }
}