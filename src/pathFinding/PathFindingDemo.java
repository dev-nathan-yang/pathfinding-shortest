package src.pathFinding;

import src.graph.Vertex;
import src.utility.GridMapToGraph;
import src.utility.MazeFileLoader;

import java.util.List;

public class PathFindingDemo
{
    MazeFileLoader mazeFileLoader;
    GridMapToGraph gridMapToGraph;
    DijkstraPathfinding dijkstraPathfinding;

    public PathFindingDemo(String filePath){
        setup(filePath);
    }

    private void setup(String filePath)
    {
        this.mazeFileLoader = new MazeFileLoader();
        this.mazeFileLoader.load(filePath);
        this.gridMapToGraph = new GridMapToGraph(this.mazeFileLoader.getMap());
        this.dijkstraPathfinding = new DijkstraPathfinding();
    }

    public int[][] getShortestPath(){
        Vertex[][] graph = gridMapToGraph.generate();

        int startRow = mazeFileLoader.getStartPointsList().get(0).row();
        int startCol = mazeFileLoader.getStartPointsList().get(0).col();

        int targetRow = mazeFileLoader.getTargetPointsList().get(0).row();
        int targetCol = mazeFileLoader.getTargetPointsList().get(0).col();


        Vertex startVertex = graph[startRow][startCol];
        Vertex targetVertex = graph[targetRow][targetCol];

        this.dijkstraPathfinding.computePaths(startVertex);
        int[][] drawedMap = getShortestPathInMap(
                graph.length,
                graph[0].length,
                this.dijkstraPathfinding
                        .getShortestPathTo(targetVertex));
        return drawedMap;
    }

    private int[][] getShortestPathInMap(
            int rows, int cols, List<Vertex> path){
        int[][] _temp = new int[rows][cols];
        for(int row = 0; row < rows ; row ++){
            for(int col = 0; col<cols; col++){
                _temp[row][col] = 0;
            }
        }

        for(Vertex v:path){
            _temp[v.getRow()][v.getCol()] = 1;
        }

        System.out.println("Shortest path in map:");
        for (int[] rowCells: _temp){
            for (int cell: rowCells){
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        return _temp;
    }
}
