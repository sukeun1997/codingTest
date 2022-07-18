package leet;

/**
 * Where Will the Ball Fall
 */
public class Leet_1706 {

    public int[] findBall(int[][] grid) {


        int balls = grid[0].length;

        int[] ar = new int[balls];

        for (int i = 0; i < balls; i++) {
            ar[i] = dfs(grid, 0, i);
        }

        return ar;
    }

    private int dfs(int[][] grid, int x, int y) {

        if (x == grid.length) {
            return y;
        }

        if (y < 0 || y >= grid[0].length) {
            return -1;
        }

        if (grid[x][y] == 1 && y + 1 < grid[0].length && grid[x][y + 1] == 1) {
            return dfs(grid, x + 1, y + 1);
        } else if (grid[x][y] == -1 && y - 1 >= 0 && grid[x][y - 1] == -1) {
            return dfs(grid, x + 1, y - 1);
        }

        return -1;
    }
}
