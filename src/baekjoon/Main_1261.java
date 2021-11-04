package baekjoon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_1261 {

    static Queue<Wall> queue = new LinkedList<>();
    static int visited[][];
    static int walls[][];

    static int rx[] = {1, -1, 0, 0};
    static int ry[] = {0, 0, 1, -1};
    static int m,n;
    static int min = Integer.MAX_VALUE;


    private static class Wall {
        int x;
        int y;
        int count;

        public Wall(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        n = sc.nextInt();

        visited = new int[n][m];
        walls = new int[n][m];

        sc.nextLine();

        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i],-1);
        }

        for (int i = 0; i < n; i++) {
            String wallInput[] = sc.nextLine().split("");
            for (int j = 0; j < m; j++) {
                walls[i][j] = Integer.parseInt(wallInput[j]);
            }
        }

        bfs();
        System.out.println(min == Integer.MAX_VALUE ? 0 : min);


    }

    private static void bfs() {

        queue.add(new Wall(0, 0, 0));
        visited[0][0] = 0;

        while (!queue.isEmpty()) {

            Wall wall = queue.remove();
            int x = wall.x;
            int y = wall.y;
            int count = wall.count;

            for (int i = 0; i < 4; i++) {
                int nextX = x - rx[i];
                int nextY = y - ry[i];
                if ((nextX >= 0 && nextX < n) && (nextY >= 0 && nextY < m)) {
                    if (nextX == n - 1 && nextY == m - 1) {
                        if (min > count) {
                            min = count;
                        }
                    }
                    if (visited[nextX][nextY] == -1 || visited[nextX][nextY] > count) {
                        visited[nextX][nextY] = count;
                        if (walls[nextX][nextY] == 0) {
                            queue.add(new Wall(nextX, nextY, count));
                        } else {
                            queue.add(new Wall(nextX, nextY, count+1));
                        }
                    }
                }
            }
        }
    }
}
