import java.util.HashSet;
import java.util.Set;

public class BitWiseOR {

    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> resOR = new HashSet<>();
        Set<Integer> curOR = new HashSet<>();

        for (int x : arr) {
            Set<Integer> nextOR = new HashSet<>();
            nextOR.add(x);

            for (int y : curOR) {
                nextOR.add(x | y);
            }
            resOR.addAll(nextOR);

            curOR = nextOR;
        }
        return resOR.size();
    }
}
