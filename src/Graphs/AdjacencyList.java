package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class AdjacencyList {

    private final ArrayList<LinkedList<String>> adjacencyList;
    private final List<String> nodeNames = new ArrayList<>();

    public AdjacencyList(){
        this.adjacencyList = new ArrayList<>();
    }

    public void addNode(String name){
        if(nodeNames.contains(name)){
            throw new IllegalArgumentException("Node already exists");
        }

        adjacencyList.add(new LinkedList<>());
        nodeNames.add(name);
    }

    public void addEdge(String source, String destination){
        if(!nodeNames.contains(source)){
            throw new IllegalArgumentException("Source node does not exist");
        }

        if(!nodeNames.contains(destination)){
            throw new IllegalArgumentException("Destination node does not exist");
        }

        adjacencyList.get(nodeNames.indexOf(source)).add(destination);
    }


    public void deleteNode(String name) {
        int index = nodeNames.indexOf(name);
        if (index == -1) {
            throw new IllegalArgumentException("Node does not exist");
        }

        nodeNames.remove(index);
        adjacencyList.remove(index);

        for (LinkedList<String> edges : adjacencyList) {
            edges.remove(name);
        }
    }


    public void deleteEdge(String source, String destination) {
        if (!nodeNames.contains(source)) {
            throw new IllegalArgumentException("Source node does not exist");
        }
        if (!nodeNames.contains(destination)) {
            throw new IllegalArgumentException("Destination node does not exist");
        }

        int sourceIndex = nodeNames.indexOf(source);
        adjacencyList.get(sourceIndex).remove(destination);
    }


    public void printList() {
        for (int i = 0; i < nodeNames.size(); i++) {
            System.out.print(nodeNames.get(i) + " -> ");
            for (String neighbor : adjacencyList.get(i)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    public void iterativeDFS(String source){
        if(!nodeNames.contains(source)){
            throw new IllegalArgumentException("Source node does not exist");
        }

        List<String> visited = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        stack.push(source);

        while(!stack.isEmpty()){

            String currentNode = stack.pop();

            if(!visited.contains(currentNode)){
                visited.add(currentNode);
                System.out.println(currentNode + " ");

                int index = nodeNames.indexOf(currentNode);
                LinkedList<String> neighbours = adjacencyList.get(index);

                for (int i = neighbours.size() - 1; i >= 0 ; i--) {
                    String neighbour = neighbours.get(i);
                    if (!visited.contains(neighbour)) {
                        stack.push(neighbour);
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        AdjacencyList graph = new AdjacencyList();

        // Add nodes
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addNode("E");
        graph.addNode("F");
        graph.addNode("G");
        graph.addNode("H");
        graph.addNode("I");
        graph.addNode("J");
        graph.addNode("K");
        graph.addNode("L");
        graph.addNode("M");
        graph.addNode("N");

        // Add edges
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("I", "A");
        graph.addEdge("B", "D");
        graph.addEdge("B", "E");
        graph.addEdge("C", "F");
        graph.addEdge("C", "G");
        graph.addEdge("D", "H");
        graph.addEdge("E", "I");
        graph.addEdge("F", "J");
        graph.addEdge("G", "K");
        graph.addEdge("H", "L");
        graph.addEdge("I", "M");
        graph.addEdge("J", "N");
        graph.addEdge("L", "A"); // Edge to form a cycle
        graph.addEdge("M", "C"); // Edge to form another cycle

        // Print initial graph
        System.out.println("Initial Graph:");
        graph.printList();

//        // Delete an edge
//        System.out.println("\nAfter deleting edge A -> C:");
//        graph.deleteEdge("A", "C");
//        graph.printList();
//
//        // Delete a node
//        System.out.println("\nAfter deleting node B:");
//        graph.deleteNode("B");
//        graph.printList();

        System.out.println("DFS Starting at:");
        graph.iterativeDFS("I");
    }
}
