package OtherDS;


//Implementing a stack data structure from scratch
public class Stack {
    private int top;
    private final int maxSize;
    private final int[] stackArray;

    //Constructor
    public Stack(int size){
        this.maxSize = size;
        this.top = -1;
        this.stackArray = new int[size];
    }

    //Checks if the top is equal to -1, which would mean there are no elements in the stack
    public boolean isEmpty() {
        return top == -1;
    }

    //Push action, storing the data in the stack array and incrementing the top
    public void push(int data){
        if(top == maxSize - 1){
            throw new IllegalArgumentException("Stack is full, cannot execute push.");
        } else {
            top++;
            stackArray[top] = data;
        }
    }

    //Pop action, removing the element from memory by setting its value to 0 and reducing the top by 1
    public int pop(){
        if(isEmpty()){
            throw new IllegalArgumentException("Stack is empty, cannot execute pop.");
        } else {
            int value = stackArray[top];
            stackArray[top--] = 0;
            return value;
        }
    }

    //Returns the top element
    public int peek(){
        if(isEmpty()){
            throw new IllegalArgumentException("Stack is empty, cannot execute peek.");
        } else {
            System.out.println(stackArray[top]);
            return stackArray[top];
        }
    }

    //Prints stack
    public void printStack(){
        if(isEmpty()){
            throw new IllegalArgumentException("Stack is empty, cannot print.");
        }
        for (int i = 0; i <= top; i++) {
            System.out.print(stackArray[i] + " ");
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack(10);

        stack.push(2);
        stack.push(4);
        stack.push(6);
        stack.peek();
        int poppedElement = stack.pop();
        System.out.println(poppedElement);
        stack.printStack();
    }
}
