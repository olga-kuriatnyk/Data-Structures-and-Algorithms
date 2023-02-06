package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HasCycle {
    public static void main(String[] args) {
        Map<Character, List<Character>> graph = new HashMap<>();

        graph = test_00();
        System.out.println(hasCycle(graph)); // true

        graph.clear();
        graph = test_01();
        System.out.println(hasCycle(graph)); // false

        graph.clear();
        graph = test_02();
        System.out.println(hasCycle(graph)); // true

        graph.clear();
        graph = test_03();
        System.out.println(hasCycle(graph)); // false

        graph.clear();
        graph = test_04();
        System.out.println(hasCycle(graph)); // true

        
        graph.clear();
        graph = test_05();
        System.out.println(hasCycle(graph)); // true
    }

    private static boolean hasCycle(Map<Character, List<Character>> graph) {
        Set<Character> visited = new HashSet<>();

        for (char key : graph.keySet()) {
            if (dfs(graph, key, visited, new HashSet<>())) return true;
        }       

        return false;
    }

    private static boolean dfs(Map<Character, List<Character>> graph, char curr, Set<Character> visited,
                                 Set<Character> visiting) {
        if (visited.contains(curr)) return false;
        if (visiting.contains(curr)) return true; // cycle detected 
        visiting.add(curr);

        for (char neighbor : graph.get(curr)) {
            if (dfs(graph, neighbor, visited, visiting)) return true;
        }

        visiting.remove(curr);
        visited.add(curr);
        return false;
    }

    public static Map<Character, List<Character>> test_00() {
        Map<Character, List<Character>> graph = new HashMap<Character, List<Character>>();
        graph.put('a', new ArrayList<>(Arrays.asList('b')));
        graph.put('b', new ArrayList<>(Arrays.asList('c')));
        graph.put('c', new ArrayList<>(Arrays.asList('a')));
        return graph;
    }

    public static Map<Character, List<Character>> test_01() {
        Map<Character, List<Character>> graph = new HashMap<Character, List<Character>>();
        graph.put('a', new ArrayList<>(Arrays.asList('b')));
        graph.put('b', new ArrayList<>(Arrays.asList('c')));
        graph.put('c', new ArrayList<>());
        return graph;
    }

    public static Map<Character, List<Character>> test_02() {
        Map<Character, List<Character>> graph = new HashMap<Character, List<Character>>();
        graph.put('a', new ArrayList<>(Arrays.asList('b','c')));
        graph.put('b', new ArrayList<>());
        graph.put('c', new ArrayList<>());
        graph.put('e', new ArrayList<>(Arrays.asList('f')));
        graph.put('f', new ArrayList<>(Arrays.asList('e')));
        return graph;
    }

    public static Map<Character, List<Character>> test_03() {
        Map<Character, List<Character>> graph = new HashMap<Character, List<Character>>();
        graph.put('q', new ArrayList<>(Arrays.asList('r','s')));
        graph.put('r', new ArrayList<>(Arrays.asList('t','u')));
        graph.put('s', new ArrayList<>());
        graph.put('t', new ArrayList<>());
        graph.put('u', new ArrayList<>());
        graph.put('v', new ArrayList<>(Arrays.asList('w')));
        graph.put('w', new ArrayList<>());
        graph.put('x', new ArrayList<>(Arrays.asList('w')));
        return graph;
    }

    public static Map<Character, List<Character>> test_04() {
        Map<Character, List<Character>> graph = new HashMap<Character, List<Character>>();
        graph.put('a', new ArrayList<>(Arrays.asList('b')));
        graph.put('b', new ArrayList<>(Arrays.asList('c')));
        graph.put('c', new ArrayList<>(Arrays.asList('a')));
        graph.put('g', new ArrayList<>());
        return graph;
    }

    public static Map<Character, List<Character>> test_05() {
        Map<Character, List<Character>> graph = new HashMap<Character, List<Character>>();
        graph.put('a', new ArrayList<>(Arrays.asList('b')));
        graph.put('b', new ArrayList<>(Arrays.asList('c')));
        graph.put('c', new ArrayList<>(Arrays.asList('d')));
        graph.put('d', new ArrayList<>(Arrays.asList('b')));
        return graph;
    }
}
