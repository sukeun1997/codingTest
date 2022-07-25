package leet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

public class Leet_994 {

    static class Orange {
        int x, y;

        public Orange(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    boolean visited[][];

    int move[][] = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int orangesRotting(int[][] grid) {
        int ans = 0;


        visited = new boolean[grid.length][grid[0].length];

        Queue<Orange> queue = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == 2) {
                    visited[i][j] = true;
                    queue.add(new Orange(i, j));
                }
            }
        }

        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int l = 0; l < size; l++) {
                Orange poll = queue.poll();
                int x = poll.x;
                int y = poll.y;

                for (int k = 0; k < 4; k++) {
                    int nx = move[k][0] + x;
                    int ny = move[k][1] + y;

                    if (nx < 0 || ny < 0 || nx >= grid.length || ny >= grid[0].length || grid[nx][ny] == 0) {
                        continue;
                    }

                    if (grid[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        grid[nx][ny] = 2;
                        queue.add(new Orange(nx, ny));
                    }
                }
            }
            if (!queue.isEmpty())
                ans++;

        }

        for (int[] ints : grid) {
            for (int anInt : ints) {
                if (anInt == 1) {
                    return -1;
                }
            }
        }

        return ans == 0 ? 0 : ans;
    }


    @Test
    void test() {
        Assertions.assertEquals(orangesRotting(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}), 4);
        Assertions.assertEquals(orangesRotting(new int[][]{{2, 1, 1}, {1, 1, 1}, {0, 1, 2}}), 2);
    }
}
