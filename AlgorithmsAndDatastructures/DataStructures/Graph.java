package AlgorithmsAndDatastructures.DataStructures;

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
}
