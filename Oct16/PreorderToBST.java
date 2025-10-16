package Oct16;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class PreorderToBST {
    int i = 0;

    public TreeNode bfsFromPreorder(int[] preorder) {
        return build(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public TreeNode build(int[] preorder, int min, int max) {
        if (i == preorder.length || preorder[i] < min || preorder[i] > max) {
            return null;
        }
        int value = preorder[i++];
        TreeNode node = new TreeNode(value);
        node.left = build(preorder, min, value);
        node.right = build(preorder, value, max);
        return node;
    }

    public static void main(String[] args) {

    }
}
