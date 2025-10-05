import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// disconnected components will not show
public class BFS_Mat {
    private int Vertices;
    private int[][] adjMat;

    public BFS_Mat(int Vertices) {
        this.Vertices = Vertices;
        this.adjMat = new int[Vertices][Vertices];
    }

    public void addEdge(int s, int d) {
        if (s >= 0 && s < Vertices && d >= 0 && d < Vertices) {
            adjMat[s][d] = 1;
            adjMat[d][s] = 1;
        }
    }

    public void bfs(int startNode, boolean[] visited, List<Integer> component) {
        Queue<Integer> queue = new LinkedList<>();
        visited[startNode] = true;
        queue.add(startNode);
        System.out.print("BFS Traversal starting from node " + startNode + ": ");
        while (!queue.isEmpty()) {
            int u = queue.poll();
            System.out.print(u + " ");
            component.add(u);
            for (int v = 0; v < Vertices; v++) {
                if (adjMat[u][v] == 1 && !visited[v]) {
                    visited[v] = true;
                    queue.add(v);
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Edges creating a single connected component
        BFS_Mat g = new BFS_Mat(6);
        boolean[] visited = new boolean[6];
        List<Integer> components = new ArrayList<>();
        g.addEdge(0, 1);
        g.addEdge(0, 4);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 4);

        // Perform BFS starting from vertex 0
        g.bfs(0, visited, components); // Output should be: 0 1 4 2 3

        // Example of a partially connected graph (shows only reachable nodes)
        System.out.println("\n--- Testing with a disconnected section ---");
        BFS_Mat g2 = new BFS_Mat(7);
        // Component A: {0, 1, 2}
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        // Component B: {3, 4, 5, 6} (disconnected from A)
        g2.addEdge(3, 4);
        g2.addEdge(5, 6);
        g2.addEdge(4, 5);

        // Start BFS from node 0. It will only visit {0, 1, 2}
        // g2.bfs(0);
        // Start BFS from node 3. It will only visit {3, 4, 5, 6}
        // g2.bfs(3);
    }
}
