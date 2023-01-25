// Write a function sumPossible that takes in an amount and an array of positive numbers.
// The function should return a boolean indicating whether or not it is possible to
// create the amount by summing numbers of the array. You may reuse numbers of the array
// as many times as necessary.
// You may assume that the target amount is non-negative.

// a - amaunt(target), n - length of nums
// Time: O(a*n), Space: O(a)

package DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class SumPossible {
    public static void main(String[] args) {
        Map<Integer, Boolean> memo = new HashMap<>();
        
        // test_00
        int[] nums = new int[] {5, 12, 4};
        int target = 8;
        System.out.println("test_00. expected: true, result: "+sumPossible(nums, memo, target)); // true

        // test_01
        memo.clear();
        nums = new int[] {6, 2, 10, 19};
        target = 15;
        System.out.println("test_01. expected: false, result: "+sumPossible(nums, memo, target)); // false

        // test_02
        memo.clear();
        nums = new int[] {6, 2, 1};
        target = 13;
        System.out.println("test_02. expected: true, result: "+sumPossible(nums, memo, target)); // true

        // test_03
        memo.clear();
        nums = new int[] {6, 20, 1};
        target = 103;
        System.out.println("test_03. expected: true, result: "+sumPossible(nums, memo, target)); // true

        // test_04
        memo.clear();
        nums = new int[] {};
        target = 12;
        System.out.println("test_04. expected: false, result: "+sumPossible(nums, memo, target)); // false

        // test_05
        memo.clear();
        nums = new int[] {12};
        target = 12;
        System.out.println("test_05. expected: true, result: "+sumPossible(nums, memo, target)); // true

        // test_06
        memo.clear();
        nums = new int[] {};
        target = 0;
        System.out.println("test_06. expected: true, result: "+sumPossible(nums, memo, target)); // true

        // test_07
        memo.clear();
        nums = new int[] {10, 8, 265, 24};
        target = 271;
        System.out.println("test_07. expected: false, result: "+sumPossible(nums, memo, target)); // false

        // test_08
        memo.clear();
        nums = new int[] {4, 2, 10};
        target = 2017;
        System.out.println("test_08. expected: false, result: "+sumPossible(nums, memo, target)); // false

        // test_09
        memo.clear();
        nums = new int[] {3, 5};
        target = 13;
        System.out.println("test_08. expected: true, result: "+sumPossible(nums, memo, target)); // true
    }

    private static boolean sumPossible(int[] nums, Map<Integer, Boolean> memo, int target) {
        if (target < 0) return false;
        if (target == 0) return true;
        if (memo.containsKey(target)) return memo.get(target);        

        for (int num : nums) {
            int currTarget = target - num;

            memo.put(currTarget, sumPossible(nums, memo, currTarget));
            if (memo.get(currTarget)) return true;
        }

        return false;
    }
}
