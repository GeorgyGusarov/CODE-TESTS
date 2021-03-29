package AlgorithmsAndDatastructures.DataStructures;

import java.io.IOException;
import java.util.Stack;

public class Graph {

    // вершина графа (ака узел)
    private class Vertex {
        char label;
        Vertex parent;
        boolean wasVisited;

        public Vertex(char label) {
            this.label = label;
            wasVisited = false;
        }

        @Override
        public String toString() {
            return "V: " + label;
        }
    }

    private final int MAX_VERTICES; // максимальное количество вершин по умолчанию
    private Vertex[] vertexList; // лист вершин
    private int[][] adjMatrix; // матрица смежностей
    private int size; // текущий размер

    public Graph(int maxVertices) {
        MAX_VERTICES = maxVertices;
        vertexList = new Vertex[MAX_VERTICES];
        adjMatrix = new int[MAX_VERTICES][MAX_VERTICES];
        this.size = 0;
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

    // вывод информации о запрашиваемой вершине
    public void displayVertex(int vertex) {
        System.out.print(vertexList[vertex] + "-> ");
    }

    public int getUnvisitedVertex(int vertex) {
        for (int i = 0; i < size; i++) {
            if (adjMatrix[vertex][i] == 1 && !vertexList[i].wasVisited) return i;
        }
        return -1;
    }

    // обход в глубину
    public void depthTraverse() throws IOException {
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
                displayVertex(vNext);
                queue.insert(vNext);
            }
        }
        resetFlags();
    }

    public QueueTest widthTraversPath(char from, char to) {
        int start = getIndex(from);
        int stop = getIndex(to);

        QueueTest queue = new QueueTest(MAX_VERTICES);
        vertexList[start].wasVisited = true;
        queue.insert(start);
        boolean done = false;
        while (!queue.isEmpty()) {
            int v1 = queue.remove();
            int v2;
            while ((v2 = getUnvisitedVertex(v1)) != -1) {
                vertexList[v2].wasVisited = true;

                if (v2 == stop) {
                    done = true;
                    break;
                }
                queue.insert(v2);
            }
        }
        resetFlags();
        if (done)
            return queue;
        else
            return null;
    }

    private int getIndex(char c) {
        for (int i = 0; i < vertexList.length; i++) {
            if (vertexList[i].label == c)
                return i;
        }
        return -1;
    }

    private void resetFlags() {
        for (int i = 0; i < size; i++) {
            vertexList[i].wasVisited = false;
        }
    }

    StackTest shortWay(char from, char to) {            //граф не взвешен
        StackTest result = new StackTest(MAX_VERTICES);
        QueueTest queue = new QueueTest(MAX_VERTICES);

        int start = getIndex(from);
        int stop = getIndex(to);
        if (start == -1 || stop == -1 || start == stop)
            return null;

        vertexList[start].wasVisited = true;
        queue.insert(start);

        while (!queue.isEmpty()) {                  // ищем узел, помечаем родителей
            int vCur = queue.remove();
            int vNxt;
            while ((vNxt = getUnvisitedVertex(vCur)) != -1) {
                vertexList[vNxt].parent = vertexList[vCur];
                vertexList[vNxt].wasVisited = true;
                if (vNxt == stop) break;
                queue.insert(vNxt);
            }
            if (vNxt == stop) break;
        }
        if (!vertexList[stop].wasVisited) return null;

        result.push(vertexList[stop].label);
        int current = stop;

        while (vertexList[current].parent != null)        // идём обратно к старту по родителям
            for (int i = 0; i < vertexList.length; i++)
                if(vertexList[current].parent == vertexList[i]) {
                    result.push(vertexList[i].label);
                    current = i;
                    break;
                }

        for (int i = 0; i < size; i++) {
            vertexList[i].wasVisited = false;
            vertexList[i].parent = null;
        }
        return result;
    }
}
