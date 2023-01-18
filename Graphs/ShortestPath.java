// Write a function, shortestPath, that takes in an array of edges for an undirected graph
// and two nodes (nodeA, nodeB). The function should return the length of the shortest
// path between A and B. Consider the length as the number of edges in the path,
// not the number of nodes. If there is no path between A and B, then return -1.

package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class ShortestPath {
    public static void main(String[] args) {

        Map<Character, List<Character>> graph = new HashMap<>();
        
        // test_00
        char[][] edges = new char[][] {{'w','x'}, {'x','y'}, {'z','y'}, {'z','v'}, {'w','v'}};
        buildGraph(edges, graph);        
        System.out.println("result: " + shortestPath(graph, 'w', 'z')); // 2

        // test_01
        System.out.println("result: " + shortestPath(graph, 'y', 'x')); // 1

        // test_02
        graph.clear();
        edges = new char[][] {{'a','c'}, {'a','b'}, {'c','b'}, {'c','d'}, {'b','d'}, {'e','d'}, {'g','f'}};
        buildGraph(edges, graph);
        System.out.println("result: " + shortestPath(graph, 'a', 'e')); // 3 

        // test_03
        System.out.println("result: " + shortestPath(graph, 'e', 'c')); // 2

        // test_04
        System.out.println("result: " + shortestPath(graph, 'b', 'g')); // -1

        // test_05
        graph.clear();
        edges = new char[][] {{'c', 'n'}, {'c','e'}, {'c','s'}, {'c','w'}, {'w','e'}};
        buildGraph(edges, graph);
        System.out.println("result: " + shortestPath(graph, 'w', 'e')); // 1

        // test_6
        graph.clear();
        edges = new char[][] {{'m','n'}, {'n','o'}, {'o','p'}, {'p','q'}, {'t','o'}, {'r','q'}, {'r','s'}};
        buildGraph(edges, graph);
        System.out.println("result: " + shortestPath(graph, 'm', 's')); // 6

    }

    private static int shortestPath(Map<Character, List<Character>> graph, char nodeA, char nodeB) {
        if (nodeA == nodeB) return 0;
        int count = 0;
        Queue<Character> q = new LinkedList<>();
        Set<Character> visited = new HashSet<>();
        q.add(nodeA);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                char curr = q.poll();
                if (curr == nodeB) {
                    return count;
                }
                if (!visited.contains(curr) && graph.containsKey(curr)) {
                    for (char neighbor : graph.get(curr)) {
                        if (!visited.contains(neighbor))
                            q.add(neighbor);    
                    }
                }
                visited.add(curr);
            }
            count += 1;
            
        }

        return -1;
    }

    private static void buildGraph(char[][] edges, Map<Character, List<Character>> graph) {
        for (char[] edge : edges) {
            if (!graph.containsKey(edge[0])) {
                graph.put(edge[0], new ArrayList<>());
            }
            if (!graph.containsKey(edge[1])) {
                graph.put(edge[1], new ArrayList<>());
            }
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
    }


}
