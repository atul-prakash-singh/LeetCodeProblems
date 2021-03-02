package datastructures.sorting.topological;

import java.util.ArrayList;
import java.util.Stack;

/*
https://www.geeksforgeeks.org/topological-sorting/
 */
class TopologicalSortingInGraph {

    private final int numberOfVertices;

    private final ArrayList<ArrayList<Integer>> adjacencyList;

    public TopologicalSortingInGraph(int numberOfVertices) {
        this.numberOfVertices = numberOfVertices;
        adjacencyList = new ArrayList<>(numberOfVertices);
        for (int i = 0; i < numberOfVertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    void addEdge(int v, int w) {
        adjacencyList.get(v).add(w);
    }

    void topologicalSortUtil(int v, boolean[] visited, Stack<Integer> stack) {
        visited[v] = true;

        for (Integer i : adjacencyList.get(v)) {
            if (!visited[i]) {
                topologicalSortUtil(i, visited, stack);
            }
        }

        stack.push(v);
    }

    void topologicalSort() {
        Stack<Integer> stack = new Stack<>();

        boolean[] visited = new boolean[numberOfVertices];
        for (int i = 0; i < numberOfVertices; i++) {
            visited[i] = false;
        }

        for (int i = 0; i < numberOfVertices; i++) {
            if (!visited[i]) {
                topologicalSortUtil(i, visited, stack);
            }
        }

        while (!stack.empty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    public static void main(String[] args) {
        TopologicalSortingInGraph graph = new TopologicalSortingInGraph(6);
        graph.addEdge(5, 2);
        graph.addEdge(5, 0);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);

        System.out.println("Following is a Topological sort of the given graph");
        graph.topologicalSort();
    }
}
/*
Complexity Analysis:

Time Complexity: O(V+E).
The above algorithm is simply DFS with an extra stack. So time complexity is the same as DFS which is.
Auxiliary space: O(V).
The extra space is needed for the stack.
 */