// Write a function, fiveSort, that takes in an array of numbers as an argument.
// The function should rearrange elements of the array such that all 5s appear at the end.
// Your function should perform this operation in-place by mutating the original array.
// The function should return the array.

// Elements that are not 5 can appear in any order in the output,
// as long as all 5s are at the end of the array.

// n - length of nums
// Time: O(n)
// Space: O(1)

import java.util.Arrays;

public class FiveSort {
    public static void main(String[] args) {
        int[] nums = new int[]{12, 5, 1, 5, 12, 7};
        fiveSort(nums);
        System.out.println(Arrays.toString(nums)); // [12, 7, 1, 12, 5, 5] 

        nums = new int[]{5, 5, 5, 1, 1, 1, 4};
        fiveSort(nums);
        System.out.println(Arrays.toString(nums)); // [4, 1, 1, 1, 5, 5, 5] 

        nums = new int[]{5, 2, 5, 6, 5, 1, 10, 2, 5, 5};
        fiveSort(nums);
        System.out.println(Arrays.toString(nums)); // [2, 2, 10, 6, 1, 5, 5, 5, 5, 5] 

        nums = new int[]{5, 5, 6, 5, 5, 5, 5};
        fiveSort(nums);
        System.out.println(Arrays.toString(nums)); // 6, 5, 5, 5, 5, 5, 5

        nums = new int[]{5, 1, 2, 5, 5, 3, 2, 5, 1, 5, 5, 5, 4, 5};
        fiveSort(nums);
        System.out.println(Arrays.toString(nums)); // 4, 1, 2, 1, 2, 3, 5, 5, 5, 5, 5, 5, 5, 5
    }

    private static void fiveSort(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            while (nums[right] == 5)
                right--;
            while (nums[left] != 5)
                left++;
            if (left < right) {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
            }
        }
    }
}
