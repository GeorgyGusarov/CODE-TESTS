package AlgorithmsAndDatastructures.DataStructures;

import java.util.Stack;

public class Graph {

    // вершина графа (ака узел)
    private class Vertex {
        char label;
        boolean wasVisited;

        public Vertex(char label) {
            this.label = label;
            this.wasVisited = false;
        }

        @Override
        public String toString() {
            return "Vertex{" +
                    "label=" + label +
                    '}';
        }
    }

    private final int MAX_VERTICES = 32; // максимальное количество вершин по умолчанию
    private Vertex[] vertexList; // лист вершин
    private int[][] adjMatrix; // матрица смежностей
    private int size; // текущий размер

    public Graph() {
        vertexList = new Vertex[MAX_VERTICES];
        adjMatrix = new int[MAX_VERTICES][MAX_VERTICES];
        size = 0;
    }

    // добавить узел
    public void addVertex(char label) {
        vertexList[size++] = new Vertex(label);
    }

    // добавление ребра (связи между двумя узлами (вершинами))
    public void addEdge(int start, int end) {
        adjMatrix[start][end] = 1;
        adjMatrix[end][start] = 1;
    }

    public void displayAdjMatrix() {

    }

    // вывод информации о запрашиваемой вершине
    public void displayVertex(int vertex) {
        System.out.println(vertexList[vertex]);
    }

    public int getUnvisitedVertex(int vertex) {
        for (int i = 0; i < size; i++) {
            if (adjMatrix[vertex][i] == 1 && !vertexList[i].wasVisited) return i;
        }
        return -1;
    }

    // обход в глубину
    public void depthTraverse() {
        StackTest stack = new StackTest(MAX_VERTICES);
        vertexList[0].wasVisited = true;
        displayVertex(0);
        stack.push(0);

        while (!stack.isEmpty()) {
            int v = getUnvisitedVertex(stack.peek());
            if (v == -1) {
                stack.pop();
            } else {
                vertexList[v].wasVisited = true;
                displayVertex(v);
                stack.push(v);
            }
        }
        resetFlags();
    }

    // обход в ширину
    public void widthTravers() {
        QueueTest queue = new QueueTest(MAX_VERTICES);
        vertexList[0].wasVisited = true;
        displayVertex(0);
        queue.insert(0);

        while (!queue.isEmpty()) {
            int vCurrent = queue.remove();
            displayVertex(vCurrent);
            int vNext;
            while ((vNext = getUnvisitedVertex(vCurrent)) != -1) {
                vertexList[vNext].wasVisited = true;
                queue.insert(vNext);
            }
        }
    }

    private void resetFlags() {
        for (int i = 0; i < size; i++) {
            vertexList[i].wasVisited = false;
        }
    }
}
