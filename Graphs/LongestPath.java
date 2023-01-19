// Write a function, longestPath, that takes in an adjacency list for a directed acyclic graph.
// The function should return the length of the longest path within the graph.
// A path may start and end at any two nodes.
// The length of a path is considered the number of edges in the path, not the number of nodes.

// DFS (recursive) 
// e - # of edges, n - # of nodes
// Time: O(e), Space: O(n)

package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestPath {
    public static void main(String[] args) {
        Map<Character, List<Character>> graph = new HashMap<>();
        
        // test_00
        char[][] edges = new char[][] {{'a','c'}, {'a','b'}, {'b','c'},};
        buildDirectedGraph(edges, graph);
        System.out.println(longestPaht(graph));     // 2

        // test_01
        graph.clear();
        edges = new char[][] {{'a','c'}, {'a','b'}, {'b','c'}, {'q','r'}, {'r','s'}, {'r','u'}, {'r','t'}, {'s','t'}, {'t','u'}};
        buildDirectedGraph(edges, graph);
        System.out.println(longestPaht(graph));     // 4

        // test_02
        graph.clear();
        edges = new char[][] {{'h','i'}, {'h','j'}, {'h','k'}, {'g','h'}, {'x','y'}};
        buildDirectedGraph(edges, graph);
        System.out.println(longestPaht(graph));     // 2

        // test_03
        graph.clear();
        edges = new char[][] {{'a','b'}, {'b','c'}, {'e','f'}, {'f','g'}, {'g','h'}};
        buildDirectedGraph(edges, graph);
        System.out.println(longestPaht(graph));     // 3

    }

    private static int longestPaht(Map<Character, List<Character>> graph) {
        // find all terminal nodes and mark their dist as 0
        // keep distance map. key - char, value - distance 
        // iterate the graph, for each node start dfs, if node has distance return that distance + 1

        
        Map<Character, Integer> distance = new HashMap<>();
        int maxPath = 0;

        // find all terminal nodes 
        for (Map.Entry<Character, List<Character>> entry : graph.entrySet()) {
            if (entry.getValue().isEmpty()) {
                distance.put(entry.getKey(), 0);
            }
        }
        
        for (char ch : graph.keySet()) {
            maxPath = Math.max(maxPath, traverseDistance(graph, distance, ch));
        }

        return maxPath;
    }

    private static int traverseDistance(Map<Character, List<Character>> graph, Map<Character,Integer> distance, char node) {
        if (distance.containsKey(node)) return distance.get(node);

        int maxDistance = 0;
        for (char neighbor : graph.get(node)) {
            int attempt = traverseDistance(graph, distance, neighbor);
            maxDistance = Math.max(maxDistance, attempt);
        }

        distance.put(node, maxDistance + 1);
        return distance.get(node);
        
    }

    private static void buildDirectedGraph(char[][] edges, Map<Character, List<Character>> graph) {
        for (char[] edge : edges) {
            if (!graph.containsKey(edge[0])) {
                graph.put(edge[0], new ArrayList<>());
            }
            if (!graph.containsKey(edge[1])) {
                graph.put(edge[1], new ArrayList<>());
            }
            graph.get(edge[0]).add(edge[1]);
            
        }
    }
}
