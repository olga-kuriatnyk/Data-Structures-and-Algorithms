import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeValueCount {
    public static void main(String[] args) {
        IntNode a = new IntNode(12);
        IntNode b = new IntNode(6);
        IntNode c = new IntNode(6);
        IntNode d = new IntNode(4);
        IntNode e = new IntNode(6);
        IntNode f = new IntNode(12);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;
        System.out.println("DFS (iterative) " + treeValueCountDFSi(a, 6)); // -> 3
        System.out.println("DFS (recursive) " + treeValueCountDFSr(a, 6));
        System.out.println("BFS (iterative) " + treeValueCountBFSi(a, 6));

        System.out.println("DFS (iterative) " + treeValueCountDFSi(a, 60)); // -> 0
        System.out.println("DFS (recursive) " + treeValueCountDFSr(a, 60));
        System.out.println("BFS (iterative) " + treeValueCountBFSi(a, 60));

        System.out.println("DFS (iterative) " + treeValueCountDFSi(a, 4)); // -> 1
        System.out.println("DFS (recursive) " + treeValueCountDFSr(a, 4));
        System.out.println("BFS (iterative) " + treeValueCountBFSi(a, 4));
    }

    // DFS (iterative)
    // n - # of nodes
    // Time: O(n). Space: O(n)
    private static int treeValueCountDFSi(IntNode root, int target) {
        int count = 0;
        Stack<IntNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            IntNode curr = stack.pop();
            if (curr.val == target) count++;
            if (curr.left != null) stack.push(curr.left);
            if (curr.right != null) stack.push(curr.right);
        }

        return count;
    }

    // DFS (recursive)
    // n - # of nodes
    // Time: O(n). Space: O(n)
    private static int treeValueCountDFSr(IntNode root, int target) {
        if (root == null) return 0;
        
        int leftCount = treeValueCountDFSr(root.left, target);
        int rightCount = treeValueCountDFSr(root.right, target);
        return (root.val == target ? 1 : 0) + leftCount + rightCount;

        // if (root == null) return 0;
        // int match = (root.val == target ? 1 : 0);
        // return match + treeValueCountDFSr(root.left, target) + treeValueCountDFSr(root.right, target);
    }

    // BFS (iterative)
    // n - # of nodes
    // Time: O(n). Space: O(n)
    private static int treeValueCountBFSi(IntNode root, int target) {
        int count = 0;

        Queue<IntNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            IntNode curr = queue.poll();
            if (curr.val == target) count += 1;
            if (curr.left != null) queue.add(curr.left);
            if (curr.right != null) queue.add(curr.right);
        }
        
        return count;
    }
}
