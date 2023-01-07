

public class IntNode {
    int val;
    IntNode left;
    IntNode right;

    IntNode() {
    }

    IntNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    IntNode(int val, IntNode left, IntNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}