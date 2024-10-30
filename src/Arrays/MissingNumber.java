package Arrays;

import java.util.TreeSet;

public class MissingNumber {
    static int findNumber(int[] arr){
        int n = arr.length + 1;
        int expectedSum = n * (n + 1) / 2;

        int actualSum = 0;
        for (int i: arr){
            actualSum += i;
        }

        return expectedSum - actualSum;

    }
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5,};  // Example array with n = 6, missing number is 3
        int n = 6;
        System.out.println("The missing number is: " + findNumber(arr));

    }
}
