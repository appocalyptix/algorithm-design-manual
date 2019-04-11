package com.chapter05;

import java.util.LinkedList;

public class Vertex {
    String data;
    LinkedList<Integer> adjacencyList;

    public Vertex(String data) {
        this.data = data;
        adjacencyList = new LinkedList<>();
    }
}
