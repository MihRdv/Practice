package SearchSort;

public class MergeSort {
    public static void main(String[] args) {

        int[] array = {4,9,0,1,2,5,6,8,7,3};

        mergeSort(array);

        for(int i: array){
            System.out.print(i + " ");
        }
    }

    public static void mergeSort(int[] array){

        int length = array.length;
        int middle = length / 2;

        if(length <= 1) return; // Base case
        
        int[] leftArray = new int[middle];
        int[] rightArray = new int[length - middle];

        int i = 0; //For left array
        int j = 0; //For right array

        for(; i<length; i++){
            if(i < middle){
                leftArray[i] = array[i];
            } else {
                rightArray[j] = array[i];
                j++;
            }
        }

        mergeSort(leftArray);
        mergeSort(rightArray);
        merge(leftArray,rightArray,array);
    }

    public static void merge(int[] leftArray,int[] rightArray, int[] array){
        int leftSize = array.length / 2;
        int rightSize = array.length - leftSize;
        
        int i = 0, l = 0, r = 0; // Control indices

        //Merge conditions
        while(l < leftSize && r < rightSize){
            if(leftArray[l] < rightArray[r]){
                array[i] = leftArray[l];
                i++;
                l++;
            } else {
                array[i] = rightArray[r];
                i++;
                r++;
            }
        }


        //In case one of the arrays has leftovers
        while(l<leftSize){
            array[i] = leftArray[l];
            i++;
            l++;
        }
        while(r < rightSize){
            array[i] = rightArray[r];
            r++;
            i++;
        }
    }
}
