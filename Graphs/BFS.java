package Graphs;

import java.util.*;

public class BFS {

    public static HashMap<Character, List<Character>> graph = new HashMap<>();

    public static void main(String[] arg) {

        // construct the graph
        constructGraph();

        // function to print the graph in DF order
        breadthFirstPrint('a');
    }

    // iterative BFS
    private static void breadthFirstPrint(Character source) {
        Queue<Character> queue = new LinkedList<>();
        queue.add(source);

        while (!queue.isEmpty()) {
            char curr = queue.poll();
            System.out.print(curr + " ");

            for (Character neighbor : graph.get(curr)) {
                queue.add(neighbor);
            }
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
