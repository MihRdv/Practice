package Arrays;

public class MajorityElement {
    //Given an array arr. Find the majority element in the array. If no majority exists, return -1.
    //A majority element in an array is an element that appears strictly more
    // than arr.size()/2 times in the array.
    public static void main(String[] args) {
        int[] arr = {3, 3, 4, 2, 4, 4, 2, 4, 4};
        int result = majorElement(arr);
        System.out.println("Majority element: " + result);
    }

    static int majorElement(int[] arr) {
        int candidate = -1;
        int count = 0;

        for (int i : arr) {
            if (count == 0) {
                candidate = i;
                count = 1;
            } else if (i == candidate) {
                count++;
            } else {
                count--;
            }
        }

        count = 0;
        for (int num : arr) {
            if (num == candidate) {
                count++;
            }
        }

        if (count > arr.length / 2) {
            return candidate;
        } else {
            return -1;
        }
    }
}
