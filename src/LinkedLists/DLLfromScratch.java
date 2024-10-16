package LinkedLists;
//Making a Doubly Linked list for practice, Unlike the singly linked list, this one has reference to
//both previous and next

class DLLNode{
    int data;

    DLLNode next;
    DLLNode previous;

    public DLLNode(int data){
        this.data = data;
        this.next = null;
        this.previous = null;
    }
}

class DoublyLinkedList{
    private DLLNode head;
    private DLLNode tail;

    public void insertAtEnd(int data){
        DLLNode newNode = new DLLNode(data);

        if(head == null){
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
    }

    public void insertAtStart(int data){
        DLLNode newNode = new DLLNode(data);

        if(head == null){
            head = tail =  newNode;
        } else {
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        }
    }

    public void delete(int target){
        if (head == null){
            System.out.println("List is empty.");
            return;
        }

        DLLNode current = head;

        if(head.data == target){
            if(head == tail){
                head = tail = null;
                return;
            } else {
                head = head.next;
                head.previous = null;
            }
            return;
        }

        while(current != null && current.data != target){
            current = current.next;
        }

        if(current == null){
            System.out.println("Element not found.");
            return;
        }

        if(current == tail){
            tail = tail.previous;
            tail.next = null;
        }

       current.previous.next = current.next;
        if(current.next != null){
            current.next.previous = current.previous;
        }
    }

    public void printListForward() {
        DLLNode current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public void printListBackward() {
        DLLNode current = tail;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.previous;
        }
        System.out.println("null");
    }

}

public class DLLfromScratch {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();

        // Insert elements at the end
        dll.insertAtEnd(10);
        dll.insertAtEnd(20);
        dll.insertAtEnd(30);

        // Insert elements at the beginning
        dll.insertAtStart(5);
        dll.insertAtStart(1);

        // Print the list forward
        System.out.println("List printed forward:");
        dll.printListForward();  // 1 -> 5 -> 10 -> 20 -> 30 -> null

        // Print the list backward
        System.out.println("\nList printed backward:");
        dll.printListBackward();  // 30 -> 20 -> 10 -> 5 -> 1 -> null

        // Delete an element from the list
        System.out.println("\nDeleting 10 from the list:");
        dll.delete(10);
        dll.printListForward();  // 1 -> 5 -> 20 -> 30 -> null

        // Delete the first element
        System.out.println("\nDeleting 1 from the list:");
        dll.delete(1);
        dll.printListForward();  // 5 -> 20 -> 30 -> null

        // Delete the last element
        System.out.println("\nDeleting 30 from the list:");
        dll.delete(30);
        dll.printListForward();  // 5 -> 20 -> null

    }
}
