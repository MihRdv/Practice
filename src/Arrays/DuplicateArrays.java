package Arrays;

import java.util.*;

//Time complexity O(n log n)
public class DuplicateArrays {
        public static List<Integer> findDuplicates(int[] arr) {
            // Create a list to store duplicates
            List<Integer> duplicates = new ArrayList<>();

            // Sort the array
            Arrays.sort(arr);

            // Check for duplicates in the sorted array
            for (int i = 1; i < arr.length; i++) {
                // If the current element is the same as the previous one, it's a duplicate
                if (arr[i] == arr[i - 1]) {
                    // To avoid adding the same duplicate multiple times
                    if (duplicates.isEmpty() || duplicates.get(duplicates.size() - 1) != arr[i]) {
                        duplicates.add(arr[i]);
                    }
                }
            }
            return duplicates;
        }



    public static void main(String[] args) {
        int[] array = {1,1,2,2,3,4,4,6,6,7,8,8,2,2,3};
        System.out.println(findDuplicates(array));
    }
}
