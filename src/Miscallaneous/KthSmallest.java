package Miscallaneous;

/*
Given an array arr[] and an integer k where k is smaller than the size of the
array, the task is to find the kth smallest element in the given array.
 */

import java.util.*;

public class KthSmallest {
    public static int kthSmallest(int[] arr, int k) {
        // Create a min-heap (priority queue)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Insert all elements of the array into the min-heap
        for (int num : arr) {
            minHeap.add(num);
        }

        // Extract the minimum element k times
        int result = -1;
        for (int i = 0; i < k; i++) {
            result = minHeap.poll(); // Extract the smallest element
        }

        return result;
    }
}
