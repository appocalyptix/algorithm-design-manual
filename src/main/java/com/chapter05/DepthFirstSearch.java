package com.chapter05;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class DeapthFirstSearch {

    public Vertex dfs(Graph graph, String key) {
        if (graph.currentSize == 0 || key == null) {
            return null;
        }

        Stack<Vertex> stack = new Stack<>();
        Set<Vertex> set = new HashSet<>();
        stack.add(graph.vertices[0]);

        while (!stack.isEmpty()) {
            Vertex v = stack.pop();

            if (set.contains(v)) {
                continue;
            }
            if (v.data.equals(key)) {
                return v;
            }

            for (Integer i : v.adjacencyList) {
                stack.push(graph.vertices[i]);
            }
            set.add(v);
        }
        return null;
    }

    private void dfsRecusive(Graph graph, int i, Set<Vertex> set) {

        if (set.contains(graph.vertices[i])) {
            return;
        }

        set.add(graph.vertices[i]);
        System.out.println(graph.vertices[i].data);
        for (Integer j : graph.vertices[i].adjacencyList) {
            dfsRecusive(graph, j, set);
        }
    }
}
