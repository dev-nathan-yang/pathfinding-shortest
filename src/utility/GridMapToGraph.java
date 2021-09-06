package src.utility;


import src.graph.Vertex;
import src.graph.Edge;

import java.util.ArrayList;
import java.util.List;

import static src.utility.MazeFileConfig.IS_WAY;

public class GridMapToGraph {

    /**
     * Take in a two-dimensional integer array as map to generate graph(vertexes)
     *
     * @param map
     * @return
     */

//	private static final int WALL = 1;
//    private static final int WAY = 0;
//	private static final int WALL = 1;

    int ROWS ;
    int COLS ;
    int[][] map;
    Vertex[][] _temp;

    public GridMapToGraph(int[][] map) {
        ROWS = map.length;
        COLS = map[0].length;
        this.map = map;
        _temp = new Vertex[ROWS][COLS];

    }


    public Vertex[][] generate() {

        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                int value = map[row][col];
                if (isWAY(value)) {
                    _temp[row][col] = new Vertex(row, col);
                }
            }
        }

        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[0].length; col++) {
                for (int[] coordinates : getNeighbours(row, col, map)) {
                    if(_temp[row][col]!=null && _temp[coordinates[0]][coordinates[1]]!=null) {
                        _temp[row][col].addNeighbour(new Edge(
                                1,
                                _temp[row][col],
                                _temp[coordinates[0]][coordinates[1]]));
                    }
                }
            }
        }

//        for (Vertex[] theRow: _temp){
//            for (Vertex theCell : theRow){
//                System.out.print(theCell);
//            }
//            System.out.println();
//        }
        return _temp;
    }



    private  boolean isWAY(int input) {
        return input == IS_WAY;
    }

    private  boolean isInMap(int row, int col, int[][] map) {
        return row >= 0 && row < map.length && col >= 0 && col < map[0].length;
    }

    private  List<int[]> getNeighbours(int row, int col, int[][] map) {

        List<int[]> temp_ = new ArrayList<>();

        int[] up = {row -1 , col};
        int[] down = {row +1 , col};
        int[] left = {row  , col - 1};
        int[] right = {row  , col + 1};
        int[][] neighbours = {up, down, left, right};

        for(int[] neighbour: neighbours) {
            if(isInMap(neighbour[0], neighbour[1], map)) {
                if(isWAY(map[neighbour[0]][neighbour[1]])) {
                    temp_.add(neighbour);
                }
            }
        }
        return temp_;
    }
}

