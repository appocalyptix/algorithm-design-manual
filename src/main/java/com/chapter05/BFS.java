package com.chapter05;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class BFS {

    public Vertex bfs(Graph graph, String key) {
        if (graph.currentSize == 0 || key == null) {
            return null;
        }
        Queue<Vertex> queue = new ArrayDeque<>();
        Set<Vertex> set = new HashSet<>();
        queue.add(graph.vertices[0]);

        while (!queue.isEmpty()) {
            Vertex v = queue.poll();
            if (v.data.equals(key)) {
                return v;
            }

            if (set.contains(v)) {
                continue;
            }

            for (Integer i : v.adjacencyList) {
                queue.add(graph.vertices[i]);
            }
            set.add(v);

        }
        return null;
    }
}
