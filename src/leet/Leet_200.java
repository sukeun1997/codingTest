package leet;

import java.util.LinkedList;
import java.util.Queue;

public class Leet_200 {

    /**
     * 더 빠른 풀이 BFS
     *
     * public class Solution {
     *
     * private int n;
     * private int m;
     *
     * public int numIslands(char[][] grid) {
     *     int count = 0;
     *     n = grid.length;
     *     if (n == 0) return 0;
     *     m = grid[0].length;
     *     for (int i = 0; i < n; i++){
     *         for (int j = 0; j < m; j++)
     *             if (grid[i][j] == '1') {
     *                 DFSMarking(grid, i, j);
     *                 ++count;
     *             }
     *     }
     *     return count;
     * }
     *
     * private void DFSMarking(char[][] grid, int i, int j) {
     *     if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1') return;
     *     grid[i][j] = '0';
     *     DFSMarking(grid, i + 1, j);
     *     DFSMarking(grid, i - 1, j);
     *     DFSMarking(grid, i, j + 1);
     *     DFSMarking(grid, i, j - 1);
     * }
     */
    int[][] move = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int numIslands(char[][] grid) {
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    count++;
                    bfs(grid, visited, i, j);
                }
            }
        }

        return count;
    }

    private void bfs(char[][] grid, boolean[][] visited, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int cx = poll[0];
            int cy = poll[1];


            for (int i = 0; i < 4; i++) {
                int nx = move[i][0] + cx;
                int ny = move[i][1] + cy;

                if (nx < 0 || ny < 0 || nx >= visited.length || ny >= visited[0].length) {
                    continue;
                }

                if (!visited[nx][ny] && grid[nx][ny] == '1') {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }
}
