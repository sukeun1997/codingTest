package leet;


public class Leet_74_2 {

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

}
