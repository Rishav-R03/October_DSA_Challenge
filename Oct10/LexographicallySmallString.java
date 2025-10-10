package Oct10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LexographicallySmallString {
    public static String smallestEq(String s1, String s2, String baseStr) {
        Map<Character, List<Character>> adj = new HashMap<>();
        int n = s1.length();
        for (int i = 0; i < n; i++) {
            char u = s1.charAt(i);
            char v = s2.charAt(i);

            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }
        StringBuilder result = new StringBuilder();
        for (char ch : baseStr.toCharArray()) {
            boolean[] visited = new boolean[26];
            char minChar = dfs(adj, ch, visited);
            result.append(minChar);
        }
        return result.toString();
    }

    private static char dfs(Map<Character, List<Character>> adj, char ch, boolean[] visited) {
        visited[ch - 'a'] = true;
        char minchar = ch;
        for (char n : adj.getOrDefault(ch, new ArrayList<>())) {
            if (!visited[n - 'a']) {
                char cand = dfs(adj, n, visited);
                if (cand < minchar) {
                    minchar = cand;
                }
            }
        }
        return minchar;
    }

    public static void main(String [] args){
        String ans = smallestEq("parker", "morris", "parser");
        System.out.println(ans);
    }
}
