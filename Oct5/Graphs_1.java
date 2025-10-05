
public class Graphs_1 {
    private int numVer;
    private int[][] adjMat;

    public Graphs_1(int numVer) {
        this.numVer = numVer;
        this.adjMat = new int[numVer][numVer];
    }

    // add edges
    public void addEdge(int s, int d) {
        if (s >= 0 && s < numVer && d >= 0 && d < numVer) {
            adjMat[s][d] = 1;
            adjMat[d][s] = 1;
        } else {
            System.out.println("Out of bounds...");
        }
    }

    // has edge
    public boolean hasEdge(int s, int d) {
        if (s >= 0 && s < numVer && d >= 0 && d < numVer) {
            if (adjMat[s][d] == 1) {
                System.out.println("Yes");
                return true;
            }
        }
        System.out.println("No");
        return false;
    }

    // display matrix
    public void displayMat() {
        for (int i = 0; i < numVer; i++) {
            for (int j = 0; j < numVer; j++) {
                System.out.print(adjMat[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Graphs_1 g1 = new Graphs_1(4);
        g1.addEdge(0, 1);
        g1.addEdge(1, 3);
        g1.addEdge(2, 3);
        g1.addEdge(2, 1);
        // g1.addEdge(0, 1);
        g1.displayMat();

        g1.hasEdge(0, 1);
    }
}