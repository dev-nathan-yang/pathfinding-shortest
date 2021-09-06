package src.graph;

public class Edge {

    private final double weight;
    private final Vertex startVertex;
    private final Vertex targetVertex;

    public Edge(double weight, Vertex start, Vertex target) {
        this.weight = weight;
        this.startVertex = start;
        this.targetVertex = target;
    }

    public double getWeight() {
        return weight;
    }

    public Vertex getStartVertex() {
        return startVertex;
    }

    public Vertex getTargetVertex() {
        return targetVertex;
    }
}