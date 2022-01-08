// Write a function, connectedComponentsCount, that takes in the adjacency 
// list of an undirected graph. The function should return the number of
// connected components within the graph.

package Graphs;

import java.util.*;

public class connectedComponents {

    public static void main(String[] arg) {
        int n = 3;
        int[][] edges = new int[n][2];
        edges[0] = new int[] { 0, 1 };
        edges[1] = new int[] { 1, 2 };
        edges[2] = new int[] { 3, 4 };

        HashMap<Integer, List<Integer>> graph = new HashMap<>();

        buildGraph(graph, edges);

        Set<Integer> visited = new HashSet<>();

        int count = 0;
        for (int node : graph.keySet()) {
            System.out.println(visited);
            if (explore(graph, node, visited)) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static boolean explore(HashMap<Integer, List<Integer>> graph, int current, Set<Integer> visited) {
        if (visited.contains(current))
            return false;

        visited.add(current);

        for (int neighbor : graph.get(current)) {
            explore(graph, neighbor, visited);
        }
        return true;
    }

    private static void buildGraph(HashMap<Integer, List<Integer>> graph, int[][] edges) {
        for (int[] edge : edges) {
            if (!graph.containsKey(edge[0])) {
                graph.put(edge[0], new ArrayList<Integer>());
            }
            graph.get(edge[0]).add(edge[1]);

            if (!graph.containsKey(edge[1])) {
                graph.put(edge[1], new ArrayList<Integer>());
            }
            graph.get(edge[1]).add(edge[0]);
        }
    }

}
