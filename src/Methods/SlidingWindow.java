package Methods;

//Calculate the max fixed size subarray sum
public class SlidingWindow {

    static int fixedWindow(int[] arr, int windowSize){
        int maxSum = 0;
        int n = arr.length;

        if(n < windowSize){
           System.out.println("Invalid"); return -1;
        }

        for (int i = 0; i < windowSize; i++) {
            maxSum += arr[i];
        }

        int currentSum = maxSum;

            for (int i = windowSize; i < n; i++) {
                currentSum += arr[i] - arr[i - windowSize];
                maxSum = Math.max(currentSum, maxSum);
            }

        return maxSum;
    }

    public static void main(String[] args) {

        int[] arr = {1, 4, 2, 10, 2, 3, 1, 0, 20};

        System.out.println(fixedWindow(arr,4));
    }
}
