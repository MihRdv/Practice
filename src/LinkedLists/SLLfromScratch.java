package LinkedLists;

class SLLNode {
    int data;
    SLLNode next;

    // Constructor
    public SLLNode(int data) {
        this.data = data;
        this.next = null;
    }
}

class SinglyLinkedList{
    private SLLNode head;

    public void insertAtEnd(int data){
        SLLNode newNode = new SLLNode(data);

        if(head == null){
            head = newNode;
        } else {
            SLLNode current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void insertAtStart(int data){
        SLLNode newNode = new SLLNode(data);

        newNode.next = head;
        head = newNode;
    }

    public void delete(int data){
        if(head == null){
            System.out.println("List is empty");
            return;
        } else if (head.data == data) {
            head = head.next;
            return;
        }

        SLLNode current = head;
        while (current.next != null && current.next.data != data) {
            current = current.next;  // Move to the next node
        }

        if (current.next == null) {
            System.out.println("Element not found");
        } else {
            // Remove the node by changing the `next` pointer of the current node
            current.next = current.next.next;
        }
    }

    public void printList() {
        // If the list is empty
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        // Traverse the list and print each node's data
        SLLNode current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");  // Print the current node's data
            current = current.next;  // Move to the next node
        }
        System.out.println("null");  // End of the list
    }
}

public class SLLfromScratch {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        // Insert some elements
        list.insertAtEnd(10);  // Add 10 at the end
        list.insertAtEnd(20);  // Add 20 at the end
        list.insertAtStart(5);  // Add 5 at the beginning
        list.insertAtEnd(30);  // Add 30 at the end

        // Print the list
        System.out.println("Current Linked List:");
        list.printList();  // Prints: 5 -> 10 -> 20 -> 30 -> null

        // Delete an element
        System.out.println("\nDeleting 20 from the list:");
        list.delete(20);  // Deletes the node with value 20
        list.printList();  // Prints: 5 -> 10 -> 30 -> null

        // Try deleting a non-existing element
        System.out.println("\nTrying to delete 40:");
        list.delete(40);  // Element 40 doesn't exist in the list
        list.printList();  // Prints: 5 -> 10 -> 30 -> null
    }

}
