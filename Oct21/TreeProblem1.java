package Oct21;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    TreeNode left, right;
    int data;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.data = val;
    }

    public TreeNode(int data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class TreeProblem1 {
    public static TreeNode createTree(TreeNode root, int data) {
        TreeNode node = new TreeNode(data);
        if (root == null) {
            root = node;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode curNode = queue.poll();
            if (curNode.left != null) {
                queue.offer(curNode.left);
            } else {
                curNode.left = node;
                return root;
            }
            if (curNode.right != null) {
                queue.offer(curNode.right);
            } else {
                curNode.right = node;
                return root;
            }
        }
        return root;
    }

    public static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {
        int[] nodes = { 1, 2, 3, 4, 5 };
        TreeNode root = new TreeNode();
        for (int n : nodes) {
            createTree(root, n);
        }
        System.out.println("Pre-order");
        preOrder(root);
        System.out.println("\nIn-order");
        inOrder(root);
        System.out.println("\nPost-order");
        postOrder(root);
    }
}
