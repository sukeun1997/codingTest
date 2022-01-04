package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_1303 {


    private static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static String map[][];
    static boolean visited[][];
    static Queue<Node> queue = new LinkedList<>();
    static int n, m;
    static int wp = 0, bp = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.valueOf(st.nextToken()); // 가로 3
        n = Integer.valueOf(st.nextToken()); // 세로 1

        map = new String[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = split[j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    queue.add(new Node(i, j));
                    visited[i][j] = true;
                    bfs(map[i][j]);
                }
            }
        }

        System.out.print(wp + " " + bp);
    }

    private static void bfs(String color) {

        int move[][] = new int[][]{{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
        int count = 1;
        while (!queue.isEmpty()) {

            Node poll = queue.poll();
            int x = poll.x;
            int y = poll.y;

            for (int i = 0; i < 4; i++) {

                int nx = x - move[i][0];
                int ny = y - move[i][1];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                if (map[nx][ny].equals(color) && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new Node(nx, ny));
                    count++;
                }
            }
        }

        if (color.equals("W")) {
            wp += Math.pow(count, 2);
        } else {
            bp += Math.pow(count, 2);
        }
    }
}
