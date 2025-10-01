package Oct1;

class MaxBottles {
    public int maxBottles(int numBo, int numEx) {
        int ans = numBo;
        int empty = numBo;

        while (empty >= numEx) {
            int quo = empty / numEx;
            ans += quo;
            empty = quo + (empty % numEx);
        }
        return ans;
    }
    
}