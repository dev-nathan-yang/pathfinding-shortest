package src.pathFinding;

import src.graph.Vertex;
import src.graph.Edge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraPathfinding
{

    public void computePaths(Vertex sourceVertex)
    {

        if (sourceVertex == null)
        {
            System.out.println("Null source vertex received, error.");
            return;
        }

        sourceVertex.setDistance(0);
        PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(sourceVertex);

        while (!priorityQueue.isEmpty())
        {
            Vertex actualVertex = priorityQueue.poll();

            for (Edge e : actualVertex.getAdjacencyList())
            {
                Vertex v = e.getTargetVertex();
                double newDistance = actualVertex.getDistance() + e.getWeight();

                if (newDistance < v.getDistance())
                {
                    priorityQueue.remove(v);
                    v.setDistance(newDistance);
                    v.setPredecessor(actualVertex);
                    priorityQueue.add(v);
                }
            }
        }
    }

    public List<Vertex> getShortestPathTo(Vertex targetVertex)
    {

        if (targetVertex == null)
        {
            System.out.println("Null target vertex received, error.");
            return null;
        }
        List<Vertex> shortestPathToTarget = new ArrayList<>();

        for (Vertex vertex = targetVertex; vertex != null; vertex = vertex.getPredecessor())
        {
            shortestPathToTarget.add(vertex);
        }

        Collections.reverse(shortestPathToTarget);
        System.out.println("Shortest path from " +
                shortestPathToTarget.get(0) +
                " to " +
                shortestPathToTarget.get(shortestPathToTarget.size() - 1) + ":");
        for (int i = 0; i < shortestPathToTarget.size(); i++)
        {
            if (i < shortestPathToTarget.size() - 1)
            {
                System.out.print(shortestPathToTarget.get(i) + " -> ");
            } else
            {
                System.out.print(shortestPathToTarget.get(i)+"\n");
            }
        }
        return shortestPathToTarget;
    }
}
