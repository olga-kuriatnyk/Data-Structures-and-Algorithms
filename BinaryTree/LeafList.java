// Write a function, leafList, that takes in the root of a binary tree
// and returns an array containing the values of all leaf nodes in left-to-right order.

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeafList {
    public static void main(String[] args) {

        List<Character> leaves = new ArrayList<>();

        TreeNode root = test_00();
        leaves = leafList(root);
        System.out.println("DFS (iterative): " + leaves); // [d, e, f]
        leaves.removeAll(leaves);

        leafListR(root, leaves);
        System.out.println("DFS (recursive): " + leaves + "\n"); // [d, e, f]
        leaves.removeAll(leaves);

        root = test_01();
        leaves = leafList(root);
        System.out.println("DFS (iterative): " + leaves); // [d, g, h]
        leaves.removeAll(leaves);

        leafListR(root, leaves);
        System.out.println("DFS (recursive): " + leaves + "\n"); // [d, g, h]
        leaves.removeAll(leaves);

        root = test_02();
        System.out.println("DFS (iterative): " + leafList(root)); // [d, g, h, f]
        leafListR(root, leaves);
        System.out.println("DFS (recursive): " + leaves + "\n"); // [d, g, h, f]
        leaves.removeAll(leaves);

        root = test_03();
        System.out.println("DFS (iterative): " + leafList(root)); // [x]
        leafListR(root, leaves);
        System.out.println("DFS (recursive): " + leaves + "\n"); // [x]
        leaves.removeAll(leaves);

        root = null;
        System.out.println("DFS (iterative): " + leafList(root)); // []
        leafListR(root, leaves);
        System.out.println("DFS (recursive): " + leaves + "\n"); // []
        leaves.removeAll(leaves);
    }

    // DFS (recursive)
    private static void leafListR(TreeNode root, List<Character> leaves) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            leaves.add(root.val);
        }
        leafListR(root.left, leaves);
        leafListR(root.right, leaves);
    }

    // DFS (iterative) 
    private static List<Character> leafList(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<Character> leaves = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left == null && node.right == null) leaves.add(node.val);
            
            if (node.right != null) stack.add(node.right);
            if (node.left != null) stack.add(node.left);
        }

        return leaves;
    }

    private static TreeNode test_00() {
        TreeNode a = new TreeNode('a');
        TreeNode b = new TreeNode('b');
        TreeNode c = new TreeNode('c');
        TreeNode d = new TreeNode('d');
        TreeNode e = new TreeNode('e');
        TreeNode f = new TreeNode('f');

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;

        //      a
        //    /   \
        //   b     c
        //  / \     \
        // d   e     f

        return a;
    }

    private static TreeNode test_01() {
        TreeNode a = new TreeNode('a');
        TreeNode b = new TreeNode('b');
        TreeNode c = new TreeNode('c');
        TreeNode d = new TreeNode('d');
        TreeNode e = new TreeNode('e');
        TreeNode f = new TreeNode('f');
        TreeNode g = new TreeNode('g');
        TreeNode h = new TreeNode('h');

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;
        e.left = g;
        f.right = h;

        //      a
        //    /   \
        //   b     c
        //  / \     \
        // d   e     f
        //    /       \
        //   g         h

        return a;
    }

    private static TreeNode test_02() {
        TreeNode a = new TreeNode('a');
        TreeNode b = new TreeNode('b');
        TreeNode c = new TreeNode('c');
        TreeNode d = new TreeNode('d');
        TreeNode e = new TreeNode('e');
        TreeNode f = new TreeNode('f');
        TreeNode g = new TreeNode('g');
        TreeNode h = new TreeNode('h');

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;
        e.left = g;
        e.right = h;

        //      a
        //    /   \
        //   b     c
        //  / \     \
        // d   e     f
        //    / \
        //   g   h

        return a;
    }

    private static TreeNode test_03() {
        TreeNode x = new TreeNode('x');

        return x;
    }
}
