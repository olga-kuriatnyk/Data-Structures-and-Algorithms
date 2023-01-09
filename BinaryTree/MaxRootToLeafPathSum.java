// A function, maxPathSum, that takes in the root of a binary tree that contains number values.
// The function should return the maximum sum of any root to leaf path within the tree.

// You may assume that the input tree is non-empty.

public class MaxRootToLeafPathSum {
    public static void main(String[] args) {
        IntNode a = new IntNode(3);
        IntNode b = new IntNode(11);
        IntNode c = new IntNode(4);
        IntNode d = new IntNode(4);
        IntNode e = new IntNode(-2);
        IntNode f = new IntNode(1);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;

        System.out.println(maxPathSum(a));
    }

    // DFS (recusive)
    // n - # of node
    // Space: O(n); Time: O(n)
    private static int maxPathSum(IntNode node) {
        if (node == null) return Integer.MIN_VALUE;

        if (node.left == null && node.right == null) return node.val;

        return node.val + Math.max(maxPathSum(node.left), maxPathSum(node.right));
    }
}
