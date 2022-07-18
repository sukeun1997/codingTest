package leet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Leet_329 {


    int max = 0;
    int move[][] = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int visited[][];
    public int longestIncreasingPath(int[][] matrix) {

        int length = matrix.length;
        int length1 = matrix[0].length;

        visited = new int[length][length1];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length1; j++) {
                max = Math.max(max, dfs(i, j, length, length1, matrix));
            }
        }

        return max;
    }

    private int dfs(int i, int j, int length, int length1, int[][] matrix) {

        if (visited[i][j] != 0) {
            return visited[i][j];
        }
        int max = 1;
        for (int k = 0; k < 4; k++) {
            int nx = move[k][0] + i;
            int ny = move[k][1] + j;

            if (nx < 0 || ny < 0 || nx >= length || ny >= length1) {
                continue;
            }

            if (matrix[i][j] < matrix[nx][ny]) {
                int len = 1 + dfs(nx, ny, length, length1, matrix);
                max = Math.max(max,len);
            }
        }

        visited[i][j] = max;

        return max;


    }


    @Test
    void test() {
        assertEquals(longestIncreasingPath(new int[][]{{9, 9, 4}, {6, 6, 8}, {2, 1, 1}}), 4);
        assertEquals(longestIncreasingPath(new int[][]{{3,4,5},{3,2,6},{2,2,1}}), 4);
        assertEquals(longestIncreasingPath(new int[][]{{7,8,9},{9,7,6},{7,2,3}}), 6);
//        assertEquals(longestIncreasingPath(new int[][]{{1}}), 1);
    }
}
