package DynamicProgramming;

import java.util.HashMap;

public class GridTravelerMemoization {

    private static HashMap<String, Integer> memo = new HashMap<>();

    public static void main(String[] arg) {

        System.out.println(gridTraveler(1, 1));
        memo.clear();
        System.out.println(gridTraveler(2, 3));
        memo.clear();
        System.out.println(gridTraveler(3, 2));
        memo.clear();
        System.out.println(gridTraveler(3, 3));
        memo.clear();
        System.out.println(gridTraveler(18, 17));
    }

    public static int gridTraveler(int m, int n) {
        String key = m + "," + n;

        if (memo.containsKey(key))
            return memo.get(key);
        if (m == 1 && n == 1)
            return 1;
        if (m == 0 || n == 0)
            return 0;

        memo.put(key, gridTraveler(m - 1, n) + gridTraveler(m, n - 1));
        return memo.get(key);
    }

    // Recursive
    // Time complexity O(2^(n+m))
    // Space complexity O(n+m)
    public static int gridTravelerRecursive(int m, int n) {
        if (m == 1 && n == 1)
            return 1;
        if (m == 0 || n == 0)
            return 0;

        return gridTraveler(m - 1, n) + gridTraveler(m, n - 1);
    }
}
