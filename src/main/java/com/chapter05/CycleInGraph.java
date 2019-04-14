package com.chapter05;

import java.util.HashSet;
import java.util.Set;

public class CycleInGraph {

    public boolean hasCycle(Graph graph) {
        Set<Vertex> remaining = new HashSet<>();
        Set<Vertex> completed = new HashSet<>();
        Set<Vertex> beingProcessed = new HashSet<>();

        for (int i = 0; i < graph.vertices.length; i++) {
            remaining.add(graph.vertices[i]);
        }
        while (!remaining.isEmpty()) {
            Vertex v = remaining.iterator().next();
            if (cycleUtil(graph, v, remaining, completed, beingProcessed)) {
                return true;
            }
        }
        return false;
    }

    private boolean cycleUtil(Graph graph, Vertex v, Set<Vertex> remaining, Set<Vertex> completed, Set<Vertex> beingProcessed) {

        remaining.remove(v);
        beingProcessed.add(v);

        for (int i = 0; i < v.adjacencyList.size(); i++) {
            if (completed.contains(graph.vertices[i])) {
                continue;
            }
            if (beingProcessed.contains(graph.vertices[i])) {
                return true;
            }
            if (cycleUtil(graph, graph.vertices[i], remaining, completed, beingProcessed)) {
                return true;
            }
        }
        beingProcessed.remove(v);
        completed.add(v);
        return false;
    }
}
