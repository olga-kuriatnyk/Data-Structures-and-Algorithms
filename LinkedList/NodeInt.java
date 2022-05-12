package LinkedList;

public class NodeInt {
    int val;
    NodeInt next;

    NodeInt() {
    }

    NodeInt(int val) {
        this.val = val;
        this.next = null;
    }

    NodeInt(int val, NodeInt next) {
        this.val = val;
        this.next = next;
    }
}
