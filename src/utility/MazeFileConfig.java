package src.utility;

class MazeFileConfig
{

    final static int IS_BLOCK = 1;
    final static int IS_WAY = 0;
    final static String LINE_REGEX = "\n";
    final static String KEY_REGEX = " ";
    final static String DATA_REGEX = ",";
    final static char ROWS_KEY = 'R';
    final static char COLS_KEY = 'C';
    final static char START_COORDINATE_KEY = 'S';
    final static char TARGET_COORDINATE_KEY = 'T';
    final static char BLOCK_COORDINATE_KEY = 'B';
    final static String DEFAULT_LINE = "This is default line.";
    final static String LINE_DIVIDER = "---------------------";
}
