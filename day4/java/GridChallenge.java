package day4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * sort rows
 * if columns are also sorted
 * return YES
 * else NO
 */

public class GridChallenge {
    public static void main(String[] args) {
        List<String> grid = new ArrayList<>();
        grid.add("ebacd");
        grid.add("fghij");
        grid.add("olmkn");
        grid.add("trpqs");
        grid.add("xywuv");
        System.out.println(gridChallenge(grid));
    }

    public static String gridChallenge(List<String> grid) {
        // Write your code here
        int numRows = grid.size();
        int numCols = grid.get(0).length();
        for (int rowNum = 0; rowNum < numRows; rowNum++) {
            char[] letters = grid.get(rowNum).toCharArray();
            Arrays.sort(letters);
            grid.set(rowNum, String.valueOf(letters));
        }
        for (int colNum = 0; colNum < numCols; colNum++) {
            for (int rowNum = 0; rowNum < numRows-1; rowNum++) {
                if ( grid.get(rowNum).charAt(colNum) > grid.get(rowNum+1).charAt(colNum) ) {
                    return "NO";
                }
            }
        }
        return "YES";
    }
}
