public class WaterBottle2 {
    public int getMax(int bottles, int numsEx) {
        int eb = bottles;
        int db = bottles;
        while (eb >= numsEx) {
            db--;
            eb++;
        }
        return db;
    }
}