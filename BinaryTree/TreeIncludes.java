// Write a function, treeIncludes, that takes in the root of a binary tree and a target value.
// The function should return a boolean indicating whether or not the value is contained in the tree.

// n - # of nodes 
// Time: O(n)
// Space: O(n)
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
        System.out.println(treeIncludes(a, 'e')); // true

        System.out.println(treeIncludes(a, 'w')); // fasle
    }

    private static boolean treeIncludes(TreeNode root, char target) {
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
}
