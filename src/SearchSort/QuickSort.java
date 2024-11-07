package SearchSort;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = {4,9,0,1,2,5,6,8,7,3};

        quickSort(array,0, array.length - 1);

        for(int i: array){
            System.out.print(i + " ");
        }
    }

    public static void quickSort(int[] array, int start, int end){

        if(end <= start) return; //Base case

        int pivot = partition(array,start,end);
        quickSort(array,start,pivot - 1);
        quickSort(array,pivot + 1, end);
    }

    public static int partition(int[] array, int start, int end){
        int pivot = array[end];
        int i = start - 1;

        for (int j = start; j <= end - 1; j++) {
            if (array[j] < pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array,i + 1,end);

        return i + 1;
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
