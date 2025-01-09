package org.example.AdapterImplementation_01.graphTravelers;

import java.util.Set;

public interface GraphAdapter<V, E> {
    void addVertex(V vertex);
    void addEdge(E edge, V source, V target);
    Set<V> getNeighbors(V vertex);
}