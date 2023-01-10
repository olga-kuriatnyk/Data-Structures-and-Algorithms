// Write a function, treeIncludes, that takes in the root of a binary tree and a target value.
// The function should return a boolean indicating whether or not the value is contained in the tree.

import java.util.LinkedList;
import java.util.Queue;

public class TreeIncludes {
    public static void main(String[] args) {
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

        System.out.println("BFS (iterative) " + treeIncludesBFSi(a, 'e')); // true
        System.out.println("BFS (iterative) " +treeIncludesBFSi(a, 'w')); // fasle

        System.out.println("DFS (recursive) " + treeIncludesDFSr(a, 'e')); // true
        System.out.println("DFS (recursive) " + treeIncludesDFSr(a, 'w')); // fasle
    }

    // BFS (iterative)
    // n - # of nodes. Time: O(n). Space: O(n)
    private static boolean treeIncludesBFSi(TreeNode root, char target) {
        if (root == null) return false;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node.val == target) return true;
            if (node.left != null) q.add(node.left);
            if (node.right != null) q.add(node.right);
        }
        
        return false;
    }

    // DFS (recursive)
    // n - # of nodes. Time: O(n). Space: O(n)
    private static boolean treeIncludesDFSr(TreeNode root, char target) {
        if (root == null) return false;
        if (root.val == target) return true;
        return treeIncludesDFSr(root.left, target) || treeIncludesDFSr(root.right, target);
    }
}
