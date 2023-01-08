// Write a function, treeMinValue, that takes in the root of a binary tree that contains number values.
// The function should return the minimum value within the tree.

// Assumption that the input tree is non-empty.


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeMinVal {
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
        
        System.out.println("DFS (iterative): " + treeMinValDFSi(a));
        System.out.println("DFS (recursive): " + treeMinValDFSr(a));
        System.out.println("BFS (iterative): " + treeMinValBFSi(a));
    }

    // DFS (iterative) 
    // Time: O(n); Space: O(n); n = # of nodes
    private static int treeMinValDFSi(IntNode node) {
        int min = Integer.MAX_VALUE;
        Stack<IntNode> stack = new Stack<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            IntNode curr = stack.pop();
            min = Math.min(min, curr.val);
            if (curr.left != null) stack.push(curr.left); 
            if (curr.right != null) stack.push(curr.right); 
        }
        
        return min;
    }

    // DFS (recursive)
    // Time: O(n); Space: O(n); n = # of nodes
    private static int treeMinValDFSr(IntNode node) {
        if (node == null) return Integer.MAX_VALUE;
        return Math.min(Math.min(node.val, treeMinValDFSr(node.left)), treeMinValDFSr(node.right));
    }

    // BFS (iterative)
    // Time: O(n); Space: O(n); n = # of nodes
    private static int treeMinValBFSi(IntNode node) {
        int min = Integer.MAX_VALUE;
        Queue<IntNode> q = new LinkedList<>();
        q.add(node);

        while (!q.isEmpty()) {
            IntNode curr = q.poll();
            min = Math.min(min, curr.val);
            if (curr.left != null) q.add(curr.left); 
            if (curr.right != null) q.add(curr.right); 
        }

        return min;
    }
}
