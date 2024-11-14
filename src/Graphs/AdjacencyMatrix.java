package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdjacencyMatrix {
    private int[][] matrix;
    private Map<String, Integer> nodeIndexMap;
    private List<String> nodeNames;
    private int size;

    public AdjacencyMatrix(){
        this.size = 0;
        this.matrix = new int[size][size];
        this.nodeNames = new ArrayList<>();
        this.nodeIndexMap = new HashMap<>();
    }

    public void addNode(String name){
        if(nodeIndexMap.containsKey(name)){
            throw new IllegalArgumentException("Node already exists");
        }

        nodeIndexMap.put(name,size);
        nodeNames.add(name);
        size++;

        int[][] newMatrix = new int[size][size];
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1; j++) {
                newMatrix[i][j] = matrix[i][j];
            }
        }
        matrix = newMatrix;
    }

    public void addEdge(String source, String direction){
        if(!nodeIndexMap.containsKey(source)){
            throw new IllegalArgumentException("Source node does not exist");
        }

        if(!nodeIndexMap.containsKey(direction)){
            throw new IllegalArgumentException("Direction node does not exist");
        }

        Integer sourceIndex = nodeIndexMap.get(source);
        Integer directionIndex = nodeIndexMap.get(direction);

        matrix[sourceIndex][directionIndex] = 1;
    }

    public void deleteEdge(String source, String direction){
        if(!nodeIndexMap.containsKey(source)){
            throw new IllegalArgumentException("Source node does not exist");
        }

        if(!nodeIndexMap.containsKey(direction)){
            throw new IllegalArgumentException("Direction node does not exist");
        }

        Integer sourceIndex = nodeIndexMap.get(source);
        Integer directionIndex = nodeIndexMap.get(direction);

        matrix[sourceIndex][directionIndex] = 0;
    }

    public void deleteNode(String name){
        if(!nodeIndexMap.containsKey(name)){
            throw new IllegalArgumentException("Node does not exist");
        }

        int indexToRemove = nodeIndexMap.get(name);
        nodeNames.remove(name);
        nodeIndexMap.remove(name);

        for(Map.Entry<String, Integer> entry : nodeIndexMap.entrySet()){
            if(entry.getValue() > indexToRemove){
                nodeIndexMap.put(entry.getKey(), entry.getValue() - 1);
            }
        }

        int[][] newMatrix = new int[size - 1][size - 1];
        for (int i = 0, newI = 0; i < size; i++) {
            if (i == indexToRemove) continue; // Skip the row of the removed node
            for (int j = 0, newJ = 0; j < size; j++) {
                if (j == indexToRemove) continue; // Skip the column of the removed node
                newMatrix[newI][newJ] = matrix[i][j];
                newJ++;
            }
            newI++;
        }

        matrix = newMatrix;
        size--;
    }

    public void printMatrix(){
        System.out.print("    ");
        for (String nodeName : nodeNames) {
            System.out.print(nodeName + " ");
        }
        System.out.println();

        for (int i = 0; i < size; i++) {
            System.out.print(nodeNames.get(i) + " | ");
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        AdjacencyMatrix graph = new AdjacencyMatrix();

        // Adding nodes
        System.out.println("Adding nodes A, B, C, D, and E");
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addNode("E");

        // Adding edges
        System.out.println("\nAdding edges A -> B, A -> C, B -> C, C -> D, D -> E");
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "C");
        graph.addEdge("C", "D");
        graph.addEdge("D", "E");

        // Printing matrix
        System.out.println("\nAdjacency Matrix after adding nodes and edges:");
        graph.printMatrix();

        // Adding more edges
        System.out.println("\nAdding edges B -> D and E -> A");
        graph.addEdge("B", "D");
        graph.addEdge("E", "A");

        // Printing matrix after more edges
        System.out.println("\nAdjacency Matrix after adding more edges:");
        graph.printMatrix();

        // Deleting an edge
        System.out.println("\nDeleting edge A -> C");
        graph.deleteEdge("A", "C");

        // Printing matrix after deleting an edge
        System.out.println("\nAdjacency Matrix after deleting edge A -> C:");
        graph.printMatrix();

        // Deleting a node
        System.out.println("\nDeleting node C");
        graph.deleteNode("C");

        // Printing matrix after deleting a node
        System.out.println("\nAdjacency Matrix after deleting node C:");
        graph.printMatrix();

        // Final matrix state after all operations
        System.out.println("\nFinal Adjacency Matrix:");
        graph.printMatrix();
    }

}
