package datastructures.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Graph<T> {

    private final int numberOfVertices;
    private final ArrayList<ArrayList<Vertex<T>>> adjacencyList;

    public Graph(int numberOfVertices) {
        this.numberOfVertices = numberOfVertices;
        adjacencyList = new ArrayList<>(numberOfVertices);
        for (int i = 0; i < numberOfVertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    public void addEdge(Vertex<T> v, Vertex<T> u) {
        adjacencyList.get(v.getIndex()).add(u);
    }

    public void breadthFirstTraversal(Vertex<T> source) {
        boolean[] visited = new boolean[numberOfVertices];
        Queue<Vertex<T>> queue = new LinkedList<>();

        visited[source.getIndex()] = true;
        queue.add(source);

        while (!queue.isEmpty()) {
            source = queue.poll();
            System.out.print(source.getData() + " ");

            for (Vertex<T> vertex : adjacencyList.get(source.getIndex())) {
                if (!visited[vertex.getIndex()]) {
                    visited[vertex.getIndex()] = true;
                    queue.add(vertex);
                }
            }
        }
    }

    private void depthFirstTraversalUtil(Vertex<T> source, boolean[] visited) {
        visited[source.getIndex()] = true;
        System.out.print(source.getData() + " ");

        for (Vertex<T> vertex : adjacencyList.get(source.getIndex())) {
            if (!visited[vertex.getIndex()]) {
                depthFirstTraversalUtil(vertex, visited);
            }
        }
    }

    public void depthFirstTraversal(Vertex<T> source) {
        boolean[] visited = new boolean[numberOfVertices];

        depthFirstTraversalUtil(source, visited);
    }
}

class Vertex<T> {
    private static int indexCounter = 0;
    private final int index;
    private final T data;

    public Vertex(T data) {
        this.index = indexCounter++;
        this.data = data;
    }

    public int getIndex() {
        return index;
    }

    public T getData() {
        return data;
    }
}

public class GraphTraversal {

    public static void main(String[] args) {
        Vertex<Integer> vertex40 = new Vertex<>(40);
        Vertex<Integer> vertex10 = new Vertex<>(10);
        Vertex<Integer> vertex20 = new Vertex<>(20);
        Vertex<Integer> vertex30 = new Vertex<>(30);
        Vertex<Integer> vertex60 = new Vertex<>(60);
        Vertex<Integer> vertex50 = new Vertex<>(50);
        Vertex<Integer> vertex70 = new Vertex<>(70);

        Graph<Integer> graph = new Graph(7);

        graph.addEdge(vertex40, vertex10);
        graph.addEdge(vertex40, vertex20);
        graph.addEdge(vertex10, vertex30);
        graph.addEdge(vertex20, vertex10);
        graph.addEdge(vertex20, vertex30);
        graph.addEdge(vertex20, vertex60);
        graph.addEdge(vertex20, vertex50);
        graph.addEdge(vertex30, vertex60);
        graph.addEdge(vertex60, vertex70);
        graph.addEdge(vertex50, vertex70);

        System.out.print("BFS -> ");
        graph.breadthFirstTraversal(vertex40);
        System.out.println();
        System.out.print("DFS -> ");
        graph.depthFirstTraversal(vertex40);
    }
}