public class WeightedGraph {
    private int numVer;
    private int[][] adjMat;

    public WeightedGraph(int numVer) {
        this.numVer = numVer;
        this.adjMat = new int[numVer][numVer];
    }

    public void addEdge(int s, int d, int w) {
        if (s >= 0 && s < numVer && d >= 0 && d < numVer) {
            adjMat[s][d] = w;
            adjMat[d][s] = w;
        } else {
            System.out.println("Out of bounds");
        }
    }

    public boolean hasEdge(int s, int d) {
        return adjMat[s][d] != 0;
    }

    public void display() {
        for (int i = 0; i < numVer; i++) {
            for (int j = 0; j < numVer; j++) {
                System.out.print(adjMat[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        WeightedGraph g1 = new WeightedGraph(4);
        g1.display();
        g1.addEdge(0, 1, 2);
        g1.addEdge(1, 3, 3);
        g1.addEdge(1, 2, 1);
        g1.addEdge(2, 3, 5);

        g1.display();

    }
}
