package Arrays;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class SecondLargest {

    static int findSecondLargest(int[] arr){
        Set<Integer> filtered = new TreeSet<>();
        for(int i: arr){
            filtered.add(i);
        }

        if(filtered.size() < 2){
            return -1;
        }

        Integer[] uniqueArray = filtered.toArray(new Integer[0]);
        return uniqueArray[uniqueArray.length - 2];
    }

    public static void main(String[] args) {
        int[] array = {10 ,5 ,10};

        System.out.println(findSecondLargest(array));
    }
}
