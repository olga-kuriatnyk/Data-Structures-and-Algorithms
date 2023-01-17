// A function, maxPathSum, that takes in the root of a binary tree that contains number values.
// The function should return the maximum sum of any root to leaf path within the tree.

// You may assume that the input tree is non-empty.

public class MaxRootToLeafPathSum {
    public static void main(String[] args) {

        IntNode root = test_00();
        System.out.println(maxPathSum(root));   // 18

        root = test_01();
        System.out.println(maxPathSum(root));   // 59

        root = test_02();
        System.out.println(maxPathSum(root));   // -8

        root = test_03();
        System.out.println(maxPathSum(root));   // 42

    }

    // DFS (recusive)
    // n - # of node
    // Space: O(n); Time: O(n)
    private static int maxPathSum(IntNode node) {
        if (node == null) return Integer.MIN_VALUE;

        if (node.left == null && node.right == null) return node.val;

        return node.val + Math.max(maxPathSum(node.left), maxPathSum(node.right));
    }

    private static IntNode test_00() {
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

        //       3
        //    /    \
        //   11     4
        //  / \      \
        // 4   -2     1

        return a;
    }

    private static IntNode test_01() {
        IntNode a = new IntNode(5);
        IntNode b = new IntNode(11);
        IntNode c = new IntNode(54);
        IntNode d = new IntNode(20);
        IntNode e = new IntNode(15);
        IntNode f = new IntNode(1);
        IntNode g = new IntNode(3);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        e.left = f;
        e.right = g;

        //        5
        //     /    \
        //    11    54
        //  /   \
        // 20   15
        //      / \
        //     1  3

        return a;
    }

    private static IntNode test_02() {
        IntNode a = new IntNode(-1);
        IntNode b = new IntNode(-6);
        IntNode c = new IntNode(-5);
        IntNode d = new IntNode(-3);
        IntNode e = new IntNode(0);
        IntNode f = new IntNode(-13);
        IntNode g = new IntNode(-1);
        IntNode h = new IntNode(-2);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;
        e.left = g;
        f.right = h;

        //        -1
        //      /   \
        //    -6    -5
        //   /  \     \
        // -3   0    -13
        //     /       \
        //    -1       -2

        return a;
    }

    private static IntNode test_03() {
        IntNode a = new IntNode(42);

        //        42

        return a;
    }
}
