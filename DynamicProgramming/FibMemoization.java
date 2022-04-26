// a function fib(n) takes in a number as an argument and
// returns the n-th number of the Fibonacci sequence

package DynamicProgramming;

import java.util.HashMap;

public class FibMemoization {

    private static HashMap<Integer, Integer> memo = new HashMap<>();

    public static void main(String[] arg) {

        // recursive solition tests
        System.out.println(fibRecursive(6)); // 8
        System.out.println(fibRecursive(7)); // 13
        System.out.println(fibRecursive(8)); // 21

        // dynamic solution, memoization tests
        System.out.println(fib(6)); // 8

        memo.clear();
        System.out.println(fib(8)); // 21

        memo.clear();
        System.out.println(fib(48)); // 512559680
    }

    // dynamic solution, memoization
    // key will be arg to function, value will be the return value
    // time and space complexity O(n)
    private static int fib(int n) {

        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;

        memo.put(n, fib(n - 1) + fib(n - 2));
        return memo.get(n);
    }

    // recursive solution, doesn't work on big numbers like fib(50)
    // complexity is O(2^n)
    private static int fibRecursive(int n) {
        if (n <= 2)
            return 1;
        return fibRecursive(n - 1) + fibRecursive(n - 2);
    }
}
