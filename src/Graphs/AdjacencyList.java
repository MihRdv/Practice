package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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


    public static void main(String[] args) {
        AdjacencyList graph = new AdjacencyList();

        // Add nodes
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");

        // Add edges
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("A","A");
        graph.addEdge("B", "C");
        graph.addEdge("C", "D");

        // Print initial graph
        System.out.println("Initial Graph:");
        graph.printList();

        // Delete an edge
        System.out.println("\nAfter deleting edge A -> C:");
        graph.deleteEdge("A", "C");
        graph.printList();

        // Delete a node
        System.out.println("\nAfter deleting node B:");
        graph.deleteNode("B");
        graph.printList();
    }
}
