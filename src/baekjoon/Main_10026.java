package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 적록색약
 */
public class Main_10026 {

    static String map[][];
    static boolean visited[][] ;
    static int n ;

    static int move[][] = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    static class Node {
        int x, y;
        String color;

        public Node(int x, int y, String color) {
            this.x = x;
            this.y = y;
            this.color = color;
        }
    }
    static int count  = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


         n = Integer.parseInt(br.readLine());

        map = new String[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                map[i][j] = split[j];
            }
        }

        // 노 색맹

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    count++;
                    bfs(i,j);
                }
            }
        }

        System.out.print(count + " ");

        // 색맹
        visited = new boolean[n][n];
        count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j].equals("G")) {
                    map[i][j] = "R";
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    count++;
                    bfs(i,j);
                }
            }
        }

        System.out.print(count + " ");


    }

    private static void bfs(int x, int y) {

        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(x, y, map[x][y]));

        while (!queue.isEmpty()) {

            Node poll = queue.poll();
            int x1 = poll.x;
            int y1 = poll.y;
            String color1 = poll.color;

            for (int i = 0; i < 4; i++) {

                int nx = x1 - move[i][0];
                int ny = y1 - move[i][1];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                    continue;
                }

                if (!visited[nx][ny]) {
                    if (map[nx][ny].equals(color1)) {
                        queue.add(new Node(nx, ny, color1));
                        visited[nx][ny] = true;
                    }
                }

            }
        }

    }
}
