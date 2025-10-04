import java.util.LinkedList;
import java.util.Queue;

class Node {
    Node left, right;
    int data;

    public Node(int data) {
        this.data = data;
    }

    public Node(Node left, Node right, int data) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

}

public class TreeTraversals {

    public static Node createTree(Node root, int data) {
        Node newNode = new Node(data);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            if (curNode.left != null) {
                queue.add(curNode.left);
            } else {
                curNode.left = newNode;
                return root;
            }
            if (curNode.right != null) {
                queue.add(curNode.right);
            } else {
                curNode.right = newNode;
                return root;
            }
        }
        return root;
    }

    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data);
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void bfs(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            System.out.print(curNode.data);
            if (curNode.left != null) {
                queue.add(curNode.left);
            }
            if (curNode.right != null) {
                queue.add(curNode.right);
            }
        }
    }

    public static void main(String[] args) {
        int[] nodes = { 1, 2, 3, 4, 5 };
        Node root = new Node(nodes[0]);
        for (int i = 1; i < nodes.length; i++) {
            createTree(root, nodes[i]);
        }
        System.out.println("Pre-order traversal...");
        preOrder(root);
        System.out.println("\nBFS traversal...");
        bfs(root);
    }
}
