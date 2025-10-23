package Oct21;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = null;
        right = null;
    }
}

public class MaxDepth {
    static Node bfs(Node root) {
        if (root == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            System.out.print(curr.data + " ");
            if (curr.left != null) {
                queue.offer(curr.left);
            }
            if (curr.right != null) {
                queue.offer(curr.right);
            }
        }
        return root;
    }

    static int iterativeHeight(Node root) {
        if (root == null) {
            return -1;
        }
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        int depth = 0;
        while (!q.isEmpty()) {
            int lvlSize = q.size();
            for (int i = 0; i < lvlSize; i++) {
                Node curr = q.poll();
                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);
            }
            depth++;
        }
        return depth - 1;

    }

    static int height(Node root) {
        if (root == null) {
            return -1;
        }
        int lHeight = height(root.left);
        int rHeight = height(root.right);

        return Math.max(lHeight, rHeight) + 1;
    }

    static void main(String[] args) {
        Node root = new Node(12);
        root.left = new Node(8);
        root.right = new Node(18);
        root.left.left = new Node(5);
        root.left.right = new Node(11);

        System.out.println(height(root));
        System.out.println(iterativeHeight(root));
        System.out.println("BFS : Traversal");
        bfs(root);
    }
}
