package org.example.LibraryChange_02.graphTravelers;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultUndirectedGraph;

import java.util.Set;
import java.util.stream.Collectors;

public class Adapter implements GraphAdapter<Integer, String> {
    private final Graph<Integer, DefaultEdge> graph;

    public Adapter() {
        this.graph = new DefaultUndirectedGraph<>(DefaultEdge.class);
    }

    @Override
    public void addVertex(Integer vertex) {
        graph.addVertex(vertex);
    }

    @Override
    public void addEdge(String edge, Integer source, Integer target) {
        graph.addEdge(source, target); // JGraphT does not use string identifiers for edges
    }

    @Override
    public Set<Integer> getNeighbors(Integer vertex) {
        return graph.edgesOf(vertex).stream()
                .map(edge -> graph.getEdgeSource(edge).equals(vertex) ?
                        graph.getEdgeTarget(edge) : graph.getEdgeSource(edge))
                .collect(Collectors.toSet());
    }
}