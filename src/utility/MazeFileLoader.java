package src.utility;

import com.sun.xml.internal.bind.v2.runtime.Coordinator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static src.utility.MazeFileConfig.*;

public class MazeFileLoader
{

    private int rows;
    private int cols;
    private int[][] map;
    private List<Coordinate> startPointsList;
    private List<Coordinate> targetPointsList;
    private List<Coordinate> blocksList;


    public MazeFileLoader()
    {
        this.startPointsList = new ArrayList<Coordinate>();
        this.targetPointsList = new ArrayList<Coordinate>();
        this.blocksList = new ArrayList<>();
    }

    public void load(String filePath)
    {

        try
        {
            System.out.printf("File path=<%s> \n", filePath);
            System.out.print("Loading file...");
            File file = new File(filePath);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuffer stringBuffer = new StringBuffer();

            String _tempLine;

            while ((_tempLine = bufferedReader.readLine()) != null)
            {
                stringBuffer.append(_tempLine);
                stringBuffer.append(LINE_REGEX);
            }
            fileReader.close();
            System.out.print("completed.\n");
            System.out.println(LINE_DIVIDER);
            processRawString(stringBuffer.toString());
        } catch (IOException e)
        {
            System.out.printf("Error happen. \nCannot load File from '%s'", filePath);
            System.exit(1);
        }
    }

    private void processRawString(String raw)
    {
        System.out.println("Processing file content...");
        String[] rawLines = raw.split(LINE_REGEX);
        for (String line : rawLines)
        {
           lineProcess(line);
        }

        System.out.println("Processing file content completed.");
        System.out.println(LINE_DIVIDER);
        initMap();
        setBlocks();
        showInfo();
    }

    private void showInfo()
    {
        System.out.println("Start point(s):");
        for (Coordinate startPoint : this.startPointsList){
            System.out.println(startPoint);
        }
        System.out.println(LINE_DIVIDER);

        System.out.println("End point(s):");
        for (Coordinate targetPoint :this.targetPointsList){
            System.out.println(targetPoint);
        }
        System.out.println(LINE_DIVIDER);

        System.out.println("Map visualization:");
        for (int[] row :this.map){
            for (int cell: row){
                System.out.print(cell+" ");
            }
            System.out.println();
        }
        System.out.println(LINE_DIVIDER);
    }

    private void setBlocks()
    {
        System.out.print("Adding blocks...");
        for(Coordinate c: this.blocksList){
            this.map[c.row()][c.col()] = IS_BLOCK;
        }
        System.out.print("completed.\n");
        System.out.println(LINE_DIVIDER);
    }

    private void lineProcess(String line){
        String data = line.split(KEY_REGEX)[1];
        switch (line.charAt(0))
        {
            case ROWS_KEY:
                System.out.println(line + " case " + ROWS_KEY);
                this.rows = stringToNumber(data);
                break;
            case COLS_KEY:
                System.out.println(line + " case " + COLS_KEY);
                this.cols = stringToNumber(data);
                break;
            case START_COORDINATE_KEY:
                System.out.println(line + " case " + START_COORDINATE_KEY);
                String[] coordinates1 = data.split(DATA_REGEX);
                this.startPointsList.add(new Coordinate(
                        stringToNumber(coordinates1[0]),
                        stringToNumber(coordinates1[1])
                ));
                break;

            case TARGET_COORDINATE_KEY:
                System.out.println(line + " case " + TARGET_COORDINATE_KEY);
                String[] coordinates2 = data.split(DATA_REGEX);
                this.targetPointsList.add(new Coordinate(
                        stringToNumber(coordinates2[0]),
                        stringToNumber(coordinates2[1])
                ));
                break;

            case BLOCK_COORDINATE_KEY:
                System.out.println(line + " case " + BLOCK_COORDINATE_KEY);
                String[] wallCoordinates = data.split(DATA_REGEX);
                this.blocksList.add(new Coordinate(
                        stringToNumber(wallCoordinates[0]),
                        stringToNumber(wallCoordinates[1])
                ));
                break;

            default:
                System.out.println(DEFAULT_LINE);
                break;
        }
    }


    private int stringToNumber(String strNum){
        try
        {
            return Integer.parseInt(strNum);
        }catch (NumberFormatException e){
            System.out.println("Error:"+strNum+" is not number.");
            return -1;
        }
    }

    private void initMap()
    {
        if(rows<=0 || cols<=0)
        {
            System.out.println("Not valid rows and cols.");
            return;
        }
        System.out.print("Initializing map...");
        this.map = new int[rows][cols];
        for (int row = 0; row < rows; row++)
        {
            for (int col = 0; col < cols; col++)
            {
                this.map[row][col] = IS_WAY;
            }
        }
        System.out.print("completed.\n");
        System.out.println(LINE_DIVIDER);
    }


    public int[][] getMap()
    {
        return map;
    }

    public List<Coordinate> getStartPointsList()
    {
        return startPointsList;
    }

    public List<Coordinate> getTargetPointsList()
    {
        return targetPointsList;
    }

    public class Coordinate
    {

        private final int row;
        private final int col;

        public Coordinate(int row, int col)
        {
            this.row = row;
            this.col = col;
        }

        public int row()
        {
            return row;
        }

        public int col()
        {
            return col;
        }

        @Override
        public String toString()
        {
            return "(" + row + "," + col + ")";
        }
    }
}
