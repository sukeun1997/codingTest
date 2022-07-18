package leet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Leet_329_2 {

    private int move[][] = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int longestIncreasingPath(int[][] matrix) {
        int x = matrix.length;
        int y = matrix[0].length;

        int cache[][] = new int[x][y];

        int max = 0;

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                max = Math.max(dfs(cache, matrix, i, j) + 1, max);
            }
        }

        return max;
    }

    private int dfs(int[][] c, int[][] m, int i, int j) {
        if (c[i][j] != 0) {
            return c[i][j];
        }

        int max = 0;
        for (int k = 0; k < 4; k++) {
            int x = i + move[k][0];
            int y = j + move[k][1];

            if (x < 0 || y < 0 || x >= m.length || y >= m[0].length) {
                continue;
            }

            if (m[i][j] < m[x][y])
                max = Math.max(max, dfs(c, m, x, y) + 1);
        }

        c[i][j] = max;

        return max;
    }

    @Test
    void test() {
        assertEquals(longestIncreasingPath(new int[][]{{9, 9, 4}, {6, 6, 8}, {2, 1, 1}}), 4);
        assertEquals(longestIncreasingPath(new int[][]{{3, 4, 5}, {3, 2, 6}, {2, 2, 1}}), 4);
        assertEquals(longestIncreasingPath(new int[][]{{7, 8, 9}, {9, 7, 6}, {7, 2, 3}}), 6);
//        assertEquals(longestIncreasingPath(new int[][]{{1}}), 1);
    }
}
