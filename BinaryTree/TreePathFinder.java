// Write a function, pathFinder, that takes in the root of a binary tree and a target value.
// The function should return an array representing a path to the target value.
// If the target value is not found in the tree, then return null.

import java.util.ArrayList;
import java.util.Arrays;

public class TreePathFinder {
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

        System.out.println("Not optimaized: " + pathFinderDFSr(a, 'e'));
        System.out.println("helper: " + helper(a, 'e'));
        System.out.println("Optimaized: " + pathFinder(a, 'e'));
    }


    /* DFS (recursive), to avoid quadratics space compexity, we add nodes to the end of the list, 
       hence they they in a wrond order and the list needs reversing 
       n - # of nodes. Time: O(n), Space: O(n)
    */
    // Reserve result array to output in correct order 
    // n - # of nodes. Time: O(n), Space: O(n)
    private static ArrayList<Character> pathFinder(TreeNode root, char target) {
        if (root == null) return null;
        ArrayList<Character> result = helper(root, target);
        ArrayList<Character> reResult = new ArrayList<>();
        for (int i = result.size()-1; i >= 0; i--) {
            reResult.add(result.get(i));
        }
        return reResult;
        
    }

    private static ArrayList<Character> helper(TreeNode root, char target) {
        if (root == null) return null;
        if (root.val == target) return new ArrayList<>(Arrays.asList(root.val));

        ArrayList<Character> leftPath = helper(root.left, target);
        if (leftPath != null) {
            leftPath.add(root.val); // takes in O(1) time
            return leftPath;
        }

        ArrayList<Character> rightPath = helper(root.right, target);
        if (rightPath != null) {
            rightPath.add(root.val); // takes in O(1) time
            return rightPath;
        }
        return null;
    }

    // DFS (recurcive)
    // n - # of nodes. Time: O(n), Space: O(n^2) because of ArrayList .add(index, value) runs O(n)
    private static ArrayList<Character> pathFinderDFSr(TreeNode root, char target) {
        if (root == null) return null;
        if (root.val == target) return new ArrayList<>(Arrays.asList(root.val));

        ArrayList<Character> leftPath = pathFinderDFSr(root.left, target);
        if (leftPath != null) {
            leftPath.add(0, root.val); // takes in O(n) time
            return leftPath;
        }

        ArrayList<Character> rightPath = pathFinderDFSr(root.right, target);
        if (rightPath != null) {
            rightPath.add(0, root.val); // takes in O(n) time
            return rightPath;
        }
        return null;
    }
}
