package com.chapter05;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class DepthFirstSearch {

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

    public void dfs2(Graph graph) {
        if (graph == null || graph.currentSize ==0) {
            return;
        }
        dfsRecusive(graph, 0, new HashSet<>());
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
        graph.addEdge("2", "3");
        graph.addEdge("2", "5");
        graph.addEdge("3", "4");
        graph.addEdge("4", "5");


        DepthFirstSearch d = new DepthFirstSearch();
        d.dfs2(graph);
    }
}
