// Write a function, pairProduct, that takes in a vector of numbers and a target product as arguments.
// The function should return a std::array containing a pair of indices whose elements multiply to the given target.
// The indices returned must be unique.

// Be sure to return the indices, not the elements themselves.

// There is guaranteed to be one such pair whose product is the target.

// n = size of input array
// Time: O(n)
// Space: O(n)

import java.util.Arrays;
import java.util.HashMap;

public class PairProduct {
    public static void main(String[] args) {

        int[] input = new int[] {3, 2, 5, 4, 1};
        int target = 8;
        int[] result = pairProduct(input, target); 
        System.out.println(Arrays.toString(result)); // [1,3]

        int[] input2 = new int[] { 4, 7, 9, 2, 5, 1};
        int target2 = 35;
        int[] result2 = pairProduct(input2, target2); 
        System.out.println(Arrays.toString(result2)); // [1,4]
    }

    private static int[] pairProduct(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            double curr = (double)target / (double)nums[i];
            
            if (curr % 1 != 0 || !map.containsKey((int)curr)) {
                map.put(nums[i], i);
            } else {
                return new int[] {map.get((int)curr), i};
            }
        }

        return null;
    }
}
