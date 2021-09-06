package src.bin;

import src.pathFinding.PathFindingDemo;

public class Test
{
    public static void main(String[] args)
    {
        PathFindingDemo pathFindingDemo =
                new PathFindingDemo("src/examples/example1.in");
        pathFindingDemo.getShortestPath();
    }
}
