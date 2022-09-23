package leet;

import java.util.ArrayList;
import java.util.List;

public class Leet_50 {


    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> list = new ArrayList<>();
        findOrder(0, 0, matrix, list);
        return list;
    }

    private void findOrder(int x, int y, int[][] matrix, List<Integer> list) {

        int yLen = matrix[0].length - 1;
        int xLen = matrix.length - 1;
        if (y != yLen) {
            list.add(matrix[x][y]);
            findOrder(x, y + 1, matrix, list);
        } else if (x != xLen) {
            list.add(matrix[x][y]);
            findOrder(x + 1, y, matrix, list);
        }
    }
}
