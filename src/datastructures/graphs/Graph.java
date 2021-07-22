package datastructures.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {

    private final int numberOfVertices;
    private final ArrayList<ArrayList<Integer>> adjacencyList;

    public Graph(int numberOfVertices) {
        this.numberOfVertices = numberOfVertices;
        adjacencyList = new ArrayList<>(numberOfVertices);
        for (int i = 0; i < numberOfVertices; i++){
            adjacencyList.add(new ArrayList<>());
        }
    }

    public void addEdge(int v, int u) {
        adjacencyList.get(v).add(u);
    }

    public void breadthFirstTraversal(int source) {
        boolean[] visited = new boolean[numberOfVertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[source] = true;
        queue.add(source);

        while (!queue.isEmpty()) {
            source = queue.poll();
            System.out.print(source + " ");

            for (Integer i : adjacencyList.get(source)) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(4);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal (starting from vertex 2)");

        graph.breadthFirstTraversal(2);
    }
}
