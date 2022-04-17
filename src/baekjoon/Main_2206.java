package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_2206 {

    static int move[][] = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int n, m;
    static int min = 9999;

    private static class Node {
        int x, y, count;

        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);

        int map[][] = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(split[j]);
            }
        }

        dfs(map);
        System.out.println(min == 9999 ? -1 : min);

    }

    private static void dfs(int[][] map) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    map[i][j] = 0;
                    bfs(map);
                    map[i][j] = 1;
                }
            }
        }
    }

    private static void bfs(int[][] map) {
        Queue<Node> queue = new LinkedList<>();
        boolean visited[][] = new boolean[n][m];

        queue.add(new Node(0, 0, 1));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int x = node.x;
            int y = node.y;
            int count = node.count;

            if (x == n - 1 && y == m - 1) {
                min = Math.min(min, count);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x - move[i][0];
                int ny = y - move[i][1];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }

                if (map[nx][ny] == 0) {
                    if (!visited[nx][ny]) {
                        queue.add(new Node(nx, ny, count + 1));
                        visited[nx][ny] = true;
                    }
                }
            }
        }

    }
}
