package leet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Search a 2D Matrix
 */
public class Leet_74 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int findRow = 0;

        for (int i = 0; i < matrix.length; i++) {
            if (target <= matrix[i][matrix[0].length-1]) {
                findRow = i;
                break;
            }
        }

        int lo = 0;
        int hi = matrix[findRow].length - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (matrix[findRow][mid] == target) {
                return true;
            } else if (matrix[findRow][mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return false;
    }


    @Test
    void test() {
        Assertions.assertEquals(searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}},3),true);
        Assertions.assertEquals(searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}},13),false);
        Assertions.assertEquals(searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}},60),true);
    }
}
