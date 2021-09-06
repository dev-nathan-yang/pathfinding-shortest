package src.bin;

import src.graph.Vertex;
import src.pathFinding.DijkstraPathfinding;
import src.utility.GridMapToGraph;
import src.utility.MazeFileLoader;

public class App
{
    public static void main(String[] args)
    {
        MazeFileLoader mazeFileLoader = new MazeFileLoader();

        mazeFileLoader.load("src/examples/example1.in");
        GridMapToGraph gmtg = new GridMapToGraph(mazeFileLoader.getMap());
        Vertex[][] graph = gmtg.generate();

        int startRow = mazeFileLoader.getStartPointsList().get(0).row();
        int startCol = mazeFileLoader.getStartPointsList().get(0).col();

        int targetRow = mazeFileLoader.getTargetPointsList().get(0).row();
        int targetCol = mazeFileLoader.getTargetPointsList().get(0).col();


        Vertex startVertex = graph[startRow][startCol];
        Vertex targetVertex = graph[targetRow][targetCol];

        DijkstraPathfinding jdpf = new DijkstraPathfinding();

        jdpf.computePaths(startVertex);
        jdpf.getShortestPathTo(targetVertex);
    }
}
