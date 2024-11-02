package Arrays;

public class DynamicArray<T> {
    public int size = 0;
    private int capacity = 10; //By default
    private T[] array;

    //Otherwise known as ArrayList in java
    @SuppressWarnings("unchecked")
    public DynamicArray() {
        this.array = (T[]) new Object[capacity];
    }

    @SuppressWarnings("unchecked")
    public DynamicArray(int customCapacity) {
        this.capacity = customCapacity;
        this.array = (T[]) new Object[capacity];
    }

    public int search(T data){
        for (int i = 0; i < size; i++) {
            if(array[i] == data){
                return i;
            }
        }

        return -1;
    }

    public void add(T data) {
        if (size >= capacity) {
            grow();
        }
        array[size] = data;
        size++;
    }

    public void insert(int index, T data) {
        if(index > size  || index < 0){
            throw new IllegalArgumentException("The index is out of the array's range.");
        }
        if(size >= capacity){
            grow();
        }
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = data;
        size++;
    }

    public void delete(T data) {
        for (int i = 0; i < size; i++) {
            if(array[i] == data){
                for (int j = 0; j < (size - i - 1); j++) {
                    array[i+j] = array[i + j + 1];
                }
                array[size - 1] = null;
                size--;
                if(size <= (int) capacity /3){
                    shrink();
                }
                break;
            }
        }
    }

    public void deleteAt(int index){
        if(index > size || index < 0){
            throw new IllegalArgumentException("The index is out of the array's range.");
        }

        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }

        array[size - 1] = null;
        size--;

        if (size <= capacity / 3) {
            shrink();
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @SuppressWarnings("unchecked")
    private void grow() {
        capacity = (int) (capacity * 1.5); //The default growth factor in java
        T[] newArray = (T[]) new Object[capacity];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    @SuppressWarnings("unchecked")
    private void shrink() {
        int newCapacity = Math.max(size, capacity / 2);

        if (newCapacity < capacity) {
            T[] newArray = (T[]) new Object[newCapacity];

            System.arraycopy(array, 0, newArray, 0, size);

            array = newArray;
            capacity = newCapacity;
        }
    }

    public String toString() {
        String string= "";

        for (int i = 0; i < size; i++) {
            string += (array[i]) + ", ";
        }
        if(!string.isEmpty()){
            string = "[" + string.substring(0,string.length() - 2) + "]";
        }
        return string;
    }

    //Driver code in the same class to avoid creating more classes
    public static void main(String[] args) {

        DynamicArray<Integer> dynamicArray = new DynamicArray<>(4);

        dynamicArray.add(1);
        dynamicArray.add(3);
        dynamicArray.add(5);

        dynamicArray.insert(1, 69);
        dynamicArray.insert(3, 100);

        System.out.println(dynamicArray.search(3));

        System.out.println(dynamicArray);
        System.out.println("Capacity: " + dynamicArray.capacity);
        System.out.println("Size: " + dynamicArray.size);
        System.out.println("Empty: " + dynamicArray.isEmpty());

        dynamicArray.delete(1);
        dynamicArray.deleteAt(3);

        System.out.println(dynamicArray);

    }
}
