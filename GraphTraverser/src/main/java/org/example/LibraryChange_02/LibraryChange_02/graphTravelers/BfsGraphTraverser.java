package org.example.LibraryChange_02.graphTravelers;

import java.util.*;

public class BfsGraphTraverser implements Traverser {
    private final GraphAdapter<Integer, String> graph;

    public BfsGraphTraverser(GraphAdapter<Integer, String> graph) {
        this.graph = graph;
    }

    @Override
    public List<Integer> traverse(Integer startVertex) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.add(startVertex);
        visited.add(startVertex);

        while (!queue.isEmpty()) {
            Integer vertex = queue.poll();
            result.add(vertex);

            // Get neighbors and sort them for deterministic output
            List<Integer> neighbors = new ArrayList<>(graph.getNeighbors(vertex));
            neighbors.sort(Comparator.naturalOrder());

            for (Integer neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        return result;
    }
}