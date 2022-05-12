package LinkedList;

import java.util.ArrayList;

public class Traversal {
    
    public static void main(String[] arg) {
        Node a = new Node('A');
        Node b = new Node('B');
        Node c = new Node('C');
        Node d = new Node('D');
        a.next = b;
        b.next = c;
        c.next = d;

        // printLinkedList(a);
        printLinkedListRecursive(a);

        Node e = new Node('E');
        d.next = e;
        System.out.println(linkedListValues(a));
    }

    public static void printLinkedList(Node head) {
        Node curr = head;
        while(curr != null) {
            System.out.println(curr.val);
            curr = curr.next;
        }
    } 

    public static void printLinkedListRecursive(Node head) {
        if (head == null) return;
        System.out.println(head.val);
        printLinkedListRecursive(head.next);
    } 
    
    public static ArrayList<Character> linkedListValues(Node head) {
        Node curr = head;
        ArrayList<Character> list = new ArrayList<Character>();
        while (curr != null) {
            list.add(curr.val);
            curr = curr.next;
        }
        return list;
    }

}

