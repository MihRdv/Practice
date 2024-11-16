package Graphs;

import java.util.*;

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

    public void recursiveDFS(String source){
        if(!nodeIndexMap.containsKey(source)){
            throw new IllegalArgumentException("Source node does not exist");
        }

        boolean[] visited = new boolean[size];
        System.out.println("(DFS Recursive) Starting from node: "+ source);
        dfsHelper(nodeIndexMap.get(source), visited);
    }

    private void dfsHelper(int currentNode, boolean[] visited){
        visited[currentNode] = true;
        System.out.println(nodeNames.get(currentNode) + " ");

        for (int i = 0; i < size; i++) {
            if(matrix[currentNode][i] == 1 && !visited[i]){
                dfsHelper(i,visited);
            }
        }
    }

    public void iterativeDFS(String source){
        if(!nodeIndexMap.containsKey(source)){
            throw new IllegalArgumentException("Source node does not exist");
        }

        boolean[] visited = new boolean[size];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(nodeIndexMap.get(source));

        System.out.println("(Iterative DFS) Starting from node: "+ source);

        while(!queue.isEmpty()){
            int currentNode = queue.poll();

            if (!visited[currentNode]) {
                visited[currentNode] = true;
                System.out.println(nodeNames.get(currentNode));

                for (int i = 0; i < size; i++) {
                    if (matrix[currentNode][i] == 1 && !visited[i]) {
                        queue.add(i);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        AdjacencyMatrix graph = new AdjacencyMatrix();

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
        graph.addEdge("I", "A");
        graph.addEdge("J", "N");
        graph.addEdge("L", "A");
        graph.addEdge("M", "C");


//        // Deleting an edge
//        System.out.println("\nDeleting edge A -> C");
//        graph.deleteEdge("A", "C");
//
//        // Printing matrix after deleting an edge
//        System.out.println("\nAdjacency Matrix after deleting edge A -> C:");
//        graph.printMatrix();
//
//        // Deleting a node
//        System.out.println("\nDeleting node C");
//        graph.deleteNode("C");
//
//        // Printing matrix after deleting a node
//        System.out.println("\nAdjacency Matrix after deleting node C:");
//        graph.printMatrix();
//
//        // Final matrix state after all operations
//        System.out.println("\nFinal Adjacency Matrix:");
//        graph.printMatrix();


        System.out.println();
        graph.recursiveDFS("C");
        System.out.println();
        graph.iterativeDFS("I");
    }

}
