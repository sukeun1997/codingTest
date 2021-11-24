package baekjoon;

import java.util.*;

public class Main_14502 {

    static int n,m;
    static boolean barrier[][];
    static int rx[] = {1, -1, 0, 0};
    static int ry[] = {0, 0, 1, -1};
    static int max = Integer.MIN_VALUE;

    private static class Node{
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        int map[][] = new int[n][m];
        barrier = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        dfs(0,map);

        System.out.println(max);
    }

    private static void dfs(int depth, int[][] map) {

        if (depth == 3) {

            int[][] copy = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    copy[i][j] = map[i][j];
                }
            }

            boolean[][] visit = new boolean[n][m];
            Queue<Node> queue = new LinkedList<>();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == 2 && !visit[i][j]) {
                        queue.add(new Node(i, j));
                        visit[i][j] = true;
                    }
                }
            }

            bfs(queue, visit, copy);
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(depth + 1, map);
                    map[i][j] = 0;
                }
            }
        }

    }

    private static void bfs(Queue<Node> queue, boolean[][] visit, int[][] map) {

        while (!queue.isEmpty()) {
            Node remove = queue.remove();
            int x = remove.x;
            int y = remove.y;

            for (int i = 0; i < 4; i++) {

                int nextX = x - rx[i];
                int nextY = y - ry[i];

                if ((nextX >= 0 && nextX < n) && (nextY >= 0 && nextY < m)) {
                    if (!visit[nextX][nextY] && map[nextX][nextY] == 0) {
                        visit[nextX][nextY] = true;
                        map[nextX][nextY] = 3;
                        queue.add(new Node(nextX, nextY));
                    }
                }
            }
        }

        int count  = 0;
        for (int[] ints : map) {
            for (int anInt : ints) {
                if (anInt == 0) {
                    count++;
                }
            }
        }

        max = Math.max(max, count);

    }
}
