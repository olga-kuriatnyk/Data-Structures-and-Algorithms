// Write a function, largestComponent, that takes in the adjacency list of an undirected graph.
// The function should return the size of the largest connected component in the graph.

package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class LargestComponent {

    public static void main(String[] args) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();

        // test_00
        int[][] edges = new int[][] {{0,8}, {0,1}, {0,5}, {5,8}, {3,4}, {2,4}, {3,2}};
        buildGraph(edges, graph);

        System.out.println("result: " + largestComponent(graph)); // 4

        // test_01
        graph.clear();
        edges = new int[][] {{1,2}, {2,8}, {6,7}, {9,8}, {7,8}};
        buildGraph(edges, graph);

        System.out.println("result: " + largestComponent(graph)); // 6

    }

    private static int largestComponent(HashMap<Integer, List<Integer>> graph) {
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        int maxCount = Integer.MIN_VALUE, count = 0;
        
        for (int node : graph.keySet()) { 
            if (!visited.contains(node)) { 
                stack.add(node);
                count = 0;
                while (!stack.isEmpty()) {
                    int curr = stack.pop();                    
                    if (!visited.contains(curr)) {
                        for (int neighbor : graph.get(curr)) {
                            if (!visited.contains(neighbor))
                                stack.add(neighbor);
                        }
                        count += 1;
                    }
                    visited.add(curr);                    
                }
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }

    private static void buildGraph(int[][] edges, HashMap<Integer, List<Integer>> graph) {
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
