package com.chapter05;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class TopologicalSort {

    public List<Vertex> topSort(Graph graph) {
        if (graph.currentSize == 0) {
            return null;
        }

        Stack<Vertex> stack = new Stack<>();
        Set<Vertex> visited = new HashSet<>();

        for (int i = 0; i < graph.currentSize; i++) {
            topUtil(graph, graph.vertices[i], visited, stack);
        }

        List<Vertex> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }

    private void topUtil(Graph g, Vertex v, Set<Vertex> visited, Stack<Vertex> stack) {
        if (visited.contains(v)) {
            return;
        }
        visited.add(v);
        for (Integer i : v.adjacencyList) {
            topUtil(g, g.vertices[i], visited, stack);
        }
        stack.add(v);
    }

    public static void main(String[] args) {
        TopologicalSort ts = new TopologicalSort();
        Graph g = new Graph(7, true);
        g.addVertex("G");
        g.addVertex("A");
        g.addVertex("B");
        g.addVertex("C");
        g.addVertex("D");
        g.addVertex("E");
        g.addVertex("F");

        g.addEdge("G", "F");
        g.addEdge("F", "E");
        g.addEdge("E", "D");
        g.addEdge("G", "A");
        g.addEdge("A", "B");
        g.addEdge("B", "D");
        g.addEdge("A", "C");
        g.addEdge("C", "F");
        g.addEdge("C", "E");

        List<Vertex> l = ts.topSort(g);

        for (Vertex v : l) {
            System.out.println(v.data);
        }
    }
}
