package SearchSort;

public class BubbleSort {
    public static void main(String[] args) {

        int[] array = {1,6,2,7,9,3,12,4,8,10,11,5};

        bubbleSort(array);

        for (int i: array) {
            System.out.print(i+ " ");
        }

    }

    public static void bubbleSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if(arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
            }
        }

        }

    }
}
