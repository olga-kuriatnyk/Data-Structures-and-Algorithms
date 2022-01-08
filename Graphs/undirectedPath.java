package Graphs;

import java.util.*;

public class undirectedPath {

    public static HashMap<Character, List<Character>> graph = new HashMap<>();

    public static void main(String[] arg) {
        char[][] edges = new char[][] { { 'i', 'j' }, { 'k', 'i' }, { 'm', 'k' }, { 'k', 'l' }, { 'o', 'n' } };

        buildGraph(edges);

        // print graph
        for (Map.Entry<Character, List<Character>> entry : graph.entrySet()) {
            System.out.print(entry.getKey() + " ");
            System.out.println(entry.getValue() + " ");
        }

        char start = 'i';
        char end = 'l';
        if (hasPath(start, end, new HashSet<>())) {
            System.out.println("True"); // expected
        } else {
            System.out.println("False");
        }

        start = 'j';
        end = 'm';
        if (hasPath(start, end, new HashSet<>())) {
            System.out.println("True"); // expected
        } else {
            System.out.println("False");
        }

        start = 'j';
        end = 'o';
        if (hasPath(start, end, new HashSet<>())) {
            System.out.println("True");
        } else {
            System.out.println("False"); // expected
        }
    }

    private static boolean hasPath(char start, char end, HashSet<Character> visited) {
        if (visited.contains(start))
            return false;

        if (start == end)
            return true;

        visited.add(start);

        for (char neighbor : graph.get(start)) {
            if (hasPath(neighbor, end, visited))
                return true;
        }
        return false;
    }

    private static void buildGraph(char[][] edges) {
        for (char[] edge : edges) {
            if (!graph.containsKey(edge[0])) {
                graph.put(edge[0], new ArrayList<Character>());
            }
            graph.get(edge[0]).add(edge[1]);

            if (!graph.containsKey(edge[1])) {
                graph.put(edge[1], new ArrayList<Character>());
            }
            graph.get(edge[1]).add(edge[0]);
        }
    }
}
