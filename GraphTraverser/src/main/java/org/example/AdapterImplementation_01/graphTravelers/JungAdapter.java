package org.example.AdapterImplementation_01.graphTravelers;

import edu.uci.ics.jung.graph.SparseMultigraph;

import java.util.Set;
import java.util.stream.Collectors;

public class JungAdapter implements GraphAdapter<Integer, String> {
    private final SparseMultigraph<Integer, String> graph;

    public JungAdapter() {
        this.graph = new SparseMultigraph<>();
    }

    @Override
    public void addVertex(Integer vertex) {
        graph.addVertex(vertex);
    }

    @Override
    public void addEdge(String edge, Integer source, Integer target) {
        graph.addEdge(edge, source, target);
    }

    @Override
    public Set<Integer> getNeighbors(Integer vertex) {
        return graph.getNeighbors(vertex).stream().collect(Collectors.toSet());
    }
}