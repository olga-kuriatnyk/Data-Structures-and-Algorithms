// Find if Path Exists in Directed Graph

/*  Time and space complexity
*
*   if n = # of nodes and e = # of edges 
*   Time complexity: O(e)
*   Space complexity: O(n) 
*   OR 
*   n = # nodes and n^2 = # edges 
*   Time complexity: O(n^2)
*   Space complexity: O(n) 
*
*/

package Graphs;

import java.util.*;

public class hasPath {

    public static HashMap<Character, List<Character>> graph = new HashMap<>();

    public static void main(String[] arg) {
        constructGraph();

        // test hasPath
        if (hasPath('f', 'h')) {
            System.out.println("True"); // expected
        } else {
            System.out.println("False");
        }

        if (hasPath('k', 'h')) {
            System.out.println("True");
        } else {
            System.out.println("False"); // expected
        }

        // test hasPathB
        if (hasPathB('i', 'h')) {
            System.out.println("True"); // expected
        } else {
            System.out.println("False");
        }

        if (hasPathB('j', 'f')) {
            System.out.println("True");
        } else {
            System.out.println("False"); // expected
        }
    }

    // DFS recursive solution
    public static boolean hasPath(char src, char dst) {
        if (src == dst)
            return true;

        for (char neighbor : graph.get(src)) {
            if (hasPath(neighbor, dst)) {
                return true;
            }
        }
        return false;
    }

    // BFS iterative solution
    public static boolean hasPathB(char src, char dst) {
        Queue<Character> queue = new LinkedList<>();
        queue.offer(src);

        while (!queue.isEmpty()) {
            char curr = queue.poll();
            if (curr == dst) {
                return true;
            }
            for (char neighbor : graph.get(curr)) {
                queue.offer(neighbor);
            }
        }

        return false;
    }

    private static void constructGraph() {
        List<Character> list = new ArrayList<Character>();
        list.add('g');
        list.add('i');
        graph.put('f', list);

        List<Character> list2 = new ArrayList<Character>();
        list2.add('h');
        graph.put('g', list2);

        List<Character> list3 = new ArrayList<Character>();
        list3.add('g');
        list3.add('k');
        graph.put('i', list3);

        List<Character> list4 = new ArrayList<Character>();
        list4.add('i');
        graph.put('j', list4);

        graph.put('h', new ArrayList<Character>());
        graph.put('k', new ArrayList<Character>());
    }
}
