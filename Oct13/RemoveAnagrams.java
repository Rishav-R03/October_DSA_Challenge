import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

public class RemoveAnagrams{
    public static List<String> removeAnagrams(String [] words){
        int n = words.length;
        List<Map<Character,Integer>> freq = new ArrayList<>();
        for(String w : words){
            Map<Character,Integer> map = new HashMap<>();
            for(char c : w.toCharArray()){
                map.put(c, map.getOrDefault(c,0)+1);
            }
            freq.add(map);
        }
        List<String> ans = new ArrayList<>();
        ans.add(words[0]);
        for(int i = 1;i<n;i++){
            if(!freq.get(i).equals(freq.get(i-1))){
                ans.add(words[i]);
            }
        }
        return ans;
    }
    // method 2

    /**
     *
     * @param words A List of strings
     * @return list of words
     */
    public static List<String> removeAnagramII(String [] words){
        int n = words.length;
        List<String> ans = new ArrayList<>();
        ans.add(words[0]);
        for(int i = 1;i<n;i++){
            char [] a = words[i].toCharArray(), b = ans.get(ans.size()-1).toCharArray();
            Arrays.sort(a);
            Arrays.sort(b);
            if(!Arrays.equals(a,b)){
                ans.add(words[i]);
            }
        }
        return ans;
    }
    public static void main(String [] args){
        List<String> result1 = new ArrayList<>();
        List<String> result2 = new ArrayList<>();
        String [] words = {"abba","aabb","abab","cd","cd"};
        result1 = removeAnagrams(words);
        result2 = removeAnagramII(words);
        System.out.println(result1);
        System.out.println(result2);

    }
}