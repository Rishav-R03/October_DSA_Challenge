import java.util.Arrays;
import java.util.Scanner;

public class SP_2 {
    private static int[][] graph;
    private static int[] q;
    private static int[] prev;
    private static int[] visited;
    private static int front;
    private static int rear;

    public static int bfs(int vertex, int totalVertices, int endVertex) {
        while (front <= rear) {
            visited[vertex] = 1;
            for (int i = 1; i <= totalVertices; i++) {
                if (graph[vertex][i] == 1 && visited[i] == 0) {
                    visited[i] = 1;
                    prev[i] = vertex;
                    q[rear] = i;
                    rear++;
                }
            }
            vertex = q[front];
            front++;
            if (vertex == endVertex) {
                return 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalVertices = scanner.nextInt();

        graph = new int[totalVertices + 1][totalVertices + 1];
        q = new int[totalVertices + 1];
        prev = new int[totalVertices + 1];
        visited = new int[totalVertices + 1];
        front = 0;
        rear = 0;

        Arrays.fill(prev, -1);
        Arrays.fill(visited, 0);

        for (int i = 1; i <= totalVertices; i++) {
            for (int j = 1; j <= totalVertices; j++) {
                graph[i][j] = scanner.nextInt();
            }
        }

        int startingVertex = scanner.nextInt() + 1;
        int endingVertex = scanner.nextInt() + 1;

        int flag = bfs(startingVertex, totalVertices, endingVertex);

        int[] path = new int[totalVertices + 1];
        int ctr = 0;

        if (flag == 1) {
            while (prev[endingVertex] != -1) {
                path[ctr] = endingVertex;
                endingVertex = prev[endingVertex];
                ctr++;
            }

            System.out.println(ctr);
            System.out.print(startingVertex - 1);
            for (int i = ctr - 1; i >= 0; i--) {
                System.out.print(" " + (path[i] - 1));
            }
            System.out.println();
        } else {
            System.out.println("Not found");
        }

        scanner.close();
    }
}