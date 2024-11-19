package Trees;

public class BST {

    Node root;

    public void insert(int data){
        Node node = new Node(data);
        root = insertHelper(root,node);
    }
    private Node insertHelper(Node root,Node node){
        int data = node.data;

        if (root == null){
            root = node;
            return root;
        } else if (data < root.data) {
            root.left = insertHelper(root.left,node);
        } else {
            root.right = insertHelper(root.right,node);
        }

        return root;
    }

    public void display(){
        displayHelper(root);
    }
    private void displayHelper(Node root){
        if(root != null){
            displayHelper(root.left);
            System.out.println(root.data);
            displayHelper(root.right);
        }
    }

    public boolean contains(int data){
        return containsHelper(root,data);
    }
    private boolean containsHelper(Node root,int data){
        if(root == null){
            return false;
        } else if (root.data == data) {
            return true;
        } else if (root.data > data) {
            return containsHelper(root.left,data);
        } else {
            return containsHelper(root.right,data);
        }
    }

    public void remove(int data){
        if(contains(data)){
            root = removeHelper(root,data);
        }
    }
    private Node removeHelper(Node root, int data) {
        if (root == null) {
            return root;
        }

        if (data < root.data) {
            root.left = removeHelper(root.left, data);
        } else if (data > root.data) {
            root.right = removeHelper(root.right, data);
        } else { // Node to remove found
            if (root.left == null && root.right == null) { // Leaf node
                return null;
            } else if (root.right != null) { // Node has a right child
                root.data = successor(root); // Replace with successor
                root.right = removeHelper(root.right, successor(root)); // Remove successor
            } else { // Node has a left child
                root.data = predecessor(root); // Replace with predecessor
                root.left = removeHelper(root.left, predecessor(root)); // Remove predecessor
            }
        }

        return root;
    }


    private int successor(Node root){//Find the left-most of the right child node
        root = root.right;
        while(root.left != null){
            root = root.left;
        }

        return root.data;
    }
    private int predecessor(Node root){//Find the right-most of the lift child node
        root = root.left;
        while(root.right != null){
            root = root.right;
        }
        return root.data;
    }

    public static void main(String[] args) {
        BST tree = new BST();

        // Test 1: Insert and Display
        System.out.println("Test 1: Insert and Display");
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);
        System.out.println("In-order Traversal (Expected: 20, 30, 40, 50, 60, 70, 80):");
        tree.display();
        System.out.println();

        // Test 2: Contains/Search
        System.out.println("Test 2: Contains/Search");
        System.out.println("Contains 30 (Expected: true): " + tree.contains(30));
        System.out.println("Contains 90 (Expected: false): " + tree.contains(90));
        System.out.println();

        // Test 3: Remove Leaf Node
        System.out.println("Test 3: Remove Leaf Node");
        tree.remove(20); // Leaf node
        System.out.println("In-order Traversal after removing 20 (Expected: 30, 40, 50, 60, 70, 80):");
        tree.display();
        System.out.println();

        // Test 4: Remove Node with One Child
        System.out.println("Test 4: Remove Node with One Child");
        tree.remove(30); // Node with one child
        System.out.println("In-order Traversal after removing 30 (Expected: 40, 50, 60, 70, 80):");
        tree.display();
        System.out.println();

        // Test 5: Remove Node with Two Children
        System.out.println("Test 5: Remove Node with Two Children");
        tree.remove(50); // Node with two children
        System.out.println("In-order Traversal after removing 50 (Expected: 40, 60, 70, 80):");
        tree.display();
        System.out.println();

        // Test 6: Remove Root Node (Special Case)
        System.out.println("Test 6: Remove Root Node");
        tree.remove(60); // New root
        System.out.println("In-order Traversal after removing root 60 (Expected: 40, 70, 80):");
        tree.display();
        System.out.println();

        // Test 7: Removing Non-existent Element
        System.out.println("Test 7: Removing Non-existent Element");
        tree.remove(100); // Should not affect the tree
        System.out.println("In-order Traversal after attempting to remove 100 (Expected: 40, 70, 80):");
        tree.display();
        System.out.println();

        // Final Tree State
        System.out.println("Final Tree State (In-order Traversal):");
        tree.display();
    }
}
