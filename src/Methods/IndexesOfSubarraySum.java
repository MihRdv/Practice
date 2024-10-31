package Methods;

import java.util.ArrayList;

/*
Given an unsorted array arr containing only non-negative integers, your task is to find a
continuous subarray (a contiguous sequence of elements) whose sum equals a
specified value target. You need to return the 1-based indices of the leftmost and rightmost
elements of this subarray.
 */
public class IndexesOfSubarraySum {

    public static ArrayList<Integer> subarraySum(int[] arr, int target) {
        int n = arr.length;
        int start = 0;
        long currentSum = 0;
        boolean flag = false;
        ArrayList<Integer> result = new ArrayList<>();

        // Iterate over the array
        for (int end = 0; end < n; end++) {
            currentSum += arr[end]; // Add the current element to the current sum

            // While the current sum is greater than the target, adjust the start
            while (currentSum > target && start <= end) {
                currentSum -= arr[start]; // Remove the starting element from current sum
                start++; // Move the start index to the right
            }

            // If current sum equals target, we found a valid subarray
            if (currentSum == target) {
                result.add(start + 1); // 1-based index for start
                result.add(end + 1);   // 1-based index for end
                return result;          // Return immediately since we want the first found
            }
        }

        // If no subarray is found, store -1 in result
        result.add(-1);
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {15, 2, 4, 8, 9, 5, 10, 23};
        ArrayList<Integer> res = subarraySum(arr, 23);
        for (int i : res)
            System.out.print(i + " ");
    }
}
