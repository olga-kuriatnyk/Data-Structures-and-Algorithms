

public class TreeNode {
    char val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(char val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    TreeNode(char val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}