package com.chapter05;

public class Graph {

    int maxSize;
    int currentSize;
    Vertex[] vertices;

    public Graph(int maxSize) {
        this.maxSize = maxSize;
        this.currentSize = 0;
        this.vertices = new Vertex[maxSize];
    }

    public boolean addVertex(String data) {
        if (maxSize == currentSize) {
            return false;
        }
        this.vertices[currentSize] = new Vertex(data);
        currentSize++;
        return true;
    }

    public void addEdge(String src, String dest) {
        Vertex sVertex = getVertex(src);
        int dIndex = getIndex(dest);

        if (sVertex == null || dIndex == -1) {
            return;
        }
        sVertex.adjacencyList.add(dIndex);

    }

    public Vertex getVertex(String key) {
        if (key == null || currentSize == 0) {
            return null;
        }

        for (int i = 0; i < currentSize; i++) {
            if (vertices[i].data.equals(key)) {
                return vertices[i];
            }
        }
        return null;
    }

    public int getIndex(String key) {
        if (key == null || currentSize == 0) {
            return -1;
        }

        for (int i = 0; i < currentSize; i++) {
            if (vertices[i].data.equals(key)) {
                return i;
            }
        }
        return -1;
    }
}
