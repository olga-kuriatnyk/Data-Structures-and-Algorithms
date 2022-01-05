package Graphs;

import java.util.*;

public class DFS {

    public static HashMap<Character, List<Character>> graph = new HashMap<>();

    public static void main(String[] arg) {

        // construct the graph
        constructGraph();

        // print graph
        for (Map.Entry<Character, List<Character>> entry : graph.entrySet()) {
            System.out.print(entry.getKey() + " ");
            System.out.println(entry.getValue() + " ");
        }

        // function to print the graph in DF order
        depthFirstPrint('a');
        System.out.println();
        depthFirstPrintRecursive('a');
    }

    // iterative DFS
    private static void depthFirstPrint(Character source) {

        Stack<Character> stack = new Stack<>();
        stack.push(source);

        while (!stack.isEmpty()) {
            Character curr = stack.pop();
            System.out.print(curr + " ");

            for (Character neighbor : graph.get(curr)) {
                stack.push(neighbor);
            }
        }
    }

    // recursive DFS
    private static void depthFirstPrintRecursive(Character source) {

        System.out.print(source + " ");

        for (Character neighbor : graph.get(source)) {
            depthFirstPrint(neighbor);
        }
    }

    private static void constructGraph() {
        List<Character> list = new ArrayList<Character>();
        list.add('b');
        list.add('c');
        graph.put('a', list);

        List<Character> list2 = new ArrayList<Character>();
        list2.add('d');
        graph.put('b', list2);

        List<Character> list3 = new ArrayList<Character>();
        list3.add('e');
        graph.put('c', list3);

        List<Character> list4 = new ArrayList<Character>();
        list4.add('f');
        graph.put('d', list4);

        graph.put('e', new ArrayList<Character>());
        graph.put('f', new ArrayList<Character>());
    }
}
