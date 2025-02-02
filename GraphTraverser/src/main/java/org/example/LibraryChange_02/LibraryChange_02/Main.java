package org.example.LibraryChange_02;

import org.example.LibraryChange_02.graphTravelers.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Change the adapter implementation to JGraphT
        GraphAdapter<Integer, String> graph = new Adapter();

        // Add vertices
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);

        // Add edges
        graph.addEdge("E1", 1, 2);
        graph.addEdge("E2", 1, 3);
        graph.addEdge("E3", 2, 4);
        graph.addEdge("E4", 3, 5);
        graph.addEdge("E5", 4, 5);

        Traverser dfsGraphTraveler = new DfsGraphTraverser(graph);
        Traverser bfsGraphTraveler = new BfsGraphTraverser(graph);

        List<Integer> dfsPath = dfsGraphTraveler.traverse(1);
        List<Integer> bfsPath = bfsGraphTraveler.traverse(1);

        System.out.println("Graph-DFS From node 1 is : " + dfsPath);
        System.out.println("Graph-BFS From node 1 is : " + bfsPath);
    }
}