package SearchSort;


public class BinarySearch {

    //Basic implementation of binary search
    private static int binarySearch(int[] array, int target){

        int high = array.length - 1;
        int low = 0;
        int current;

        while(low < high){
            current = low + (high - low)/2;
            int value = array[current];

            if(value == target){
                return current;
            }

            if (value < target){
                low = current;
            }

            if(value > target){
                high = current;
            }

        }

        return -1; //Not found
    }

    public static void main(String[] args) {

        int[] array = new int[1000];
        int target = 814;

        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }

        int index = binarySearch(array, target);

        if(index == -1){
            System.out.println("Not found.");
        } else {
            System.out.println("Found at index " + index);
        }
    }
}
