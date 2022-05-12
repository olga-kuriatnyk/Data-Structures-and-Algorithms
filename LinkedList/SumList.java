package LinkedList;

public class SumList {
    public static void main(String[] arg) {
        NodeInt a = new NodeInt(2);
        NodeInt b = new NodeInt(8);
        NodeInt c = new NodeInt(3);
        NodeInt d = new NodeInt(7);
        a.next = b;
        b.next = c;
        c.next = d;
        System.out.println(calculateSum(a));
        System.out.println(calculateSumRecursive(a));
    }

    // Time complexity: O(N)
    // Space complexity: O(1)
    public static int calculateSum(NodeInt head) {
        int sum = 0;
        NodeInt curr = head;
        while (curr != null) {
            sum += curr.val;
            curr = curr.next;
        }
        return sum;
    }

    // Time complexity: O(N)
    // Space complexity: O(N)
    public static int calculateSumRecursive(NodeInt head) {
        if (head == null)
            return 0;
        return head.val + calculateSumRecursive(head.next);
    }

}
