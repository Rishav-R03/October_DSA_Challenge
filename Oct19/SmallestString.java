import java.util.Queue;
import java.util.Set;
import java.util.HashSet;
import java.util.LinkedList;

public class SmallestString {
    public String smallestString(String s, int a, int b) {
        String res = s;
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(s);
        visited.add(s);

        while (!queue.isEmpty()) {
            String curr = queue.poll();
            if (curr.compareTo(res) < 0) {
                res = curr;
            }

            // added string
            char[] chars = curr.toCharArray();
            for (int i = 1; i < curr.length(); i += 2) {
                chars[i] = (char) (((chars[i] - '0' + a) % 10) + '0');
            }
            String addedStr = new String(chars);
            if (visited.add(addedStr)) {
                queue.offer(addedStr);
            }
            // rotated
            String rotated = curr.substring(curr.length() - b) + curr.substring(0, curr.length() - b);
            if (visited.add(rotated)) {
                queue.offer(rotated);
            }
        }
        return res;
    }

    static void main(String[] args) {
        SmallestString ss = new SmallestString();
        String s = "5525";
        int a = 9, b = 2;
        String res = ss.smallestString(s, a, b);
        System.out.println(res);
    }
}