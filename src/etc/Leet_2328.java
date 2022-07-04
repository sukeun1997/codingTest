package etc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Leet_2328 {

    private int mod = 1000000007;

    public int countPaths(int[][] grid) {


        int answer = 0;
        int cache[][] = new int[1000][1000];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                answer = ((answer % mod) + (dfs(cache, grid, i, j, -1) % mod)) % mod;
            }
        }

        return answer;
    }

    private int dfs(int[][] cache, int[][] grid, int i, int j, int pre) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return 0;
        }
        if (grid[i][j] <= pre) {
            return 0;
        }
        if (cache[i][j] != 0) {
            return cache[i][j];
        }


        int i1 = dfs(cache, grid, i + 1, j, grid[i][j]);
        int i2 = dfs(cache, grid, i - 1, j, grid[i][j]);
        int i3 = dfs(cache, grid, i, j + 1, grid[i][j]);
        int i4 = dfs(cache, grid, i, j - 1, grid[i][j]);

        return cache[i][j] = (1 + i1 + i2 + i3 + i4) % mod;
    }


    @Test
    void test() {
        Assertions.assertEquals(countPaths(new int[][]{{1, 1}, {3, 4}}), 8);
    }
}
