package com.chapter05;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Shortest path in a connected graph using breadth-first search
 */
public class ShortestPath {

    public List<Vertex> getShortestPAth(Graph graph, String src, String dest) {
        if (graph.currentSize == 0 || src == null || dest == null) {
            return null;
        }
        Queue<Vertex> queue = new ArrayDeque<>();
        Set<Vertex> set = new HashSet<>();
        Map<Vertex, Integer> map = new HashMap<>();
        int[] parents = new int[graph.maxSize];
        Arrays.fill(parents, -1);
        boolean[] discovered = new boolean[graph.maxSize];

        List<Vertex> list = new ArrayList<>();
        int srcIndex = -1;
        for (int i = 0; i < graph.vertices.length; i++) {
            if (src.equals(graph.vertices[i].data)) {
                queue.add(graph.vertices[i]);
                map.put(graph.vertices[i], i);
                list.add(graph.vertices[i]);
                srcIndex = i;
                break;
            }
        }

        if (srcIndex == -1) {
            return null;
        }
        Vertex destination = null;
        while (!queue.isEmpty()) {
            Vertex v = queue.poll();
            if (set.contains(v)) {
                continue;
            }

            if (v.data.equals(dest)) {
                destination = v;
                break;
            }
            for (Integer i : v.adjacencyList) {
                map.put(graph.vertices[i], i);
                queue.add(graph.vertices[i]);
                if (!discovered[i]) {
                    parents[i] = map.get(v);
                    discovered[i] = true;
                }
            }
            set.add(v);
        }

        if (destination == null) {
            return null;
        }

        int parentIndex = map.get(destination);

        while (parentIndex != srcIndex) {
            list.add(1, graph.vertices[parentIndex]);
            parentIndex = parents[parentIndex];
        }
        return list;
    }

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addVertex("1");
        graph.addVertex("2");
        graph.addVertex("3");
        graph.addVertex("4");
        graph.addVertex("5");
        graph.addVertex("6");

        graph.addEdge("1", "2");
        graph.addEdge("1", "5");
        graph.addEdge("1", "6");
        graph.addEdge("2", "5");
        graph.addEdge("2", "3");
        graph.addEdge("3", "4");
        graph.addEdge("4", "5");

        graph.addEdge("2", "1");
        graph.addEdge("5", "1");
        graph.addEdge("6", "1");
        graph.addEdge("5", "2");
        graph.addEdge("3", "2");
        graph.addEdge("4", "3");
        graph.addEdge("5", "4");

        ShortestPath sp = new ShortestPath();
        List<Vertex> l = sp.getShortestPAth(graph, "1", "4");

        for (Vertex v : l) {
            System.out.println(v.data);
        }
    }
}
