package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.SortedMap;

public class Main_1012 {

    static int move[][] = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int m,n;
    static int count;
    private static class Node {
        int x,y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            count = 0;
            String[] split = br.readLine().split(" ");
            m = Integer.parseInt(split[0]);
            n = Integer.parseInt(split[1]);
            int k = Integer.parseInt(split[2]);

            int map[][] = new int[n][m];
            boolean visited[][] = new boolean[n][m];

            for (int j = 0; j < k; j++) {
                String[] strings = br.readLine().split(" ");
                int x = Integer.parseInt(strings[0]);
                int y = Integer.parseInt(strings[1]);

                map[y][x] = 1;
            }

            for (int j = 0; j < n; j++) {
                for (int l = 0; l < m; l++) {
                    if (!visited[j][l] && map[j][l] == 1) {
                        bfs(l,j,visited,map);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    private static void bfs(int l, int j, boolean[][] visited, int[][] map) {
        Queue<Node> queue = new LinkedList<>();

        visited[j][l] = true;
        queue.add(new Node(j, l));

        while (!queue.isEmpty()) {

            Node poll = queue.poll();

            int x = poll.x;
            int y = poll.y;

            for (int i = 0; i < 4; i++) {
                int nx = x - move[i][0];
                int ny = y - move[i][1];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }

                if (map[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new Node(nx, ny));
                }
            }
        }
    }

}
