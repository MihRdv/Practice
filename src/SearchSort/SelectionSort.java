package SearchSort;

public class SelectionSort {
    public static void main(String[] args) {
        int[] array = {1,6,2,7,9,3,12,4,8,10,11,5};

        selectionSort(array);

        for(int i: array){
            System.out.print(i + " ");
        }
    }

    private static void selectionSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            int temp;
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[min] > arr[j]){
                    min = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }
}
