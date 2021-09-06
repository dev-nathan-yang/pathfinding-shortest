package src.graph;

import java.util.ArrayList;
import java.util.List;

public class Vertex implements Comparable<Vertex> {

    private String name;
    private List<Edge> adjacencyList;
    private Vertex predecessor;
    private double distance = Double.MAX_VALUE;
    private int row = 0;
    private int col = 0;

    public Vertex(String name) {
        this.name = name;
        this.adjacencyList = new ArrayList<>();
    }

    public Vertex(int row, int col) {
        this.name = "(" + row + "," + col + ")";
        this.row = row;
        this.col = col;
        this.adjacencyList = new ArrayList<>();
    }

    public void addNeighbour(Edge e) {
        this.adjacencyList.add(e);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Edge> getAdjacencyList() {
        return adjacencyList;
    }

    public void setAdjacencyList(List<Edge> adjacencyList) {
        this.adjacencyList = adjacencyList;
    }

    public Vertex getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(Vertex predecessor) {
        this.predecessor = predecessor;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public int getRow()
    {
        return row;
    }

    public int getCol()
    {
        return col;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public int compareTo(Vertex o) {
        return Double.compare(this.distance, o.getDistance());
    }

}

