import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSdiscon {
    private int Vertices;
    private int[][] adjMat;

    public BFSdiscon(int Vertices) {
        this.Vertices = Vertices;
        adjMat = new int[Vertices][Vertices];
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

        while (!queue.isEmpty()) {
            int curNode = queue.poll();
            System.out.print(curNode + " ");
            component.add(curNode);
            for (int v = 0; v < Vertices; v++) {
                if (adjMat[curNode][v] == 1 && !visited[v]) {
                    visited[v] = true;
                    queue.add(v);
                }
            }
        }
    }

    public List<List<Integer>> findAllCompo() {
        boolean[] visited = new boolean[Vertices];
        List<List<Integer>> components = new ArrayList<>();

        for (int i = 0; i < Vertices; i++) {
            if (!visited[i]) {
                List<Integer> curCom = new ArrayList<>();
                bfs(i, visited, curCom);
                components.add(curCom);
            }
        }
        return components;
    }
}
