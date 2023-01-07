// Write a function, treeSum, that takes in the root of a binary tree that contains number values.
// The function should return the total sum of all values in the tree.

// n - # of nodes 
// Time: O(n)
// Space: O(n)

import java.util.LinkedList;
import java.util.Queue;

public class TreeSum {
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
        System.out.println(treeSum(a)); // 21
        System.out.println(treeSumRec(a));

        IntNode w = new IntNode();
        System.out.println(treeSum(w)); // 0
        System.out.println(treeSumRec(w));
    }

    private static int treeSumRec(IntNode node) {
        if (node == null) return 0;
        return node.val + treeSumRec(node.left) + treeSumRec(node.right); 
    }

    // BFS iteratevly 
    private static int treeSum(IntNode node) {
        if (node == null) return 0;
        int sum = 0;
        Queue<IntNode> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            IntNode curr = queue.poll();
            sum += curr.val;
            if (curr.left != null) queue.add(curr.left);
            if (curr.right != null) queue.add(curr.right);
        }

        return sum;
    }
}
