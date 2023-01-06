// Write a function, longestStreak, that takes in the head of a linked list as an argument.
// The function should return the length of the longest consecutive streak of the same value within the list.

// n - lenth of the list
// Time: O(n)
// Space: O(1)
package LinkedList;

public class LongestStreak {
    public static void main(String[] args) {

        NodeInt a = new NodeInt(5);
        NodeInt b = new NodeInt(5);
        NodeInt c = new NodeInt(7);
        NodeInt d = new NodeInt(7);
        NodeInt e = new NodeInt(7);
        NodeInt f = new NodeInt(6);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f; 
        System.out.println(longestStreak(a)); // 3

    }

    private static int longestStreak(NodeInt head) {
        int result = Integer.MIN_VALUE;
        NodeInt curr = head;
        while (curr != null) {
            int count = 1;
            while (curr.next != null && curr.val == curr.next.val) {
                count++;
                curr = curr.next;
            }
            result = Math.max(result,count);
            curr = curr.next;
        }
        return result;
    }
}
