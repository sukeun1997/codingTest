package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_17086 {

    static class Node {

        int x,y, count;

        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    static int max = 0;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int map[][] = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    bfs(i,j,n, m, map);
                }
            }
        }

        System.out.println(max);
    }

    private static void bfs(int x1, int y1, int n, int m, int[][] map) {
        int move[][] = new int[][]{{1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, 0}, {-1, -1}, {0, 1}, {0, -1}};
        Queue<Node> queue = new LinkedList<>();
        boolean visited[][] = new boolean[n][m];
        queue.add(new Node(x1, y1, 0));

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int x = poll.x;
            int y = poll.y;
            int count = poll.count;


            for (int i = 0; i < 8; i++) {

                int nx = x - move[i][0];
                int ny = y - move[i][1];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }


                if (!visited[nx][ny]) {
                    if (map[nx][ny] == 1) {
                        max = Math.max(max, count + 1);
                        return;
                    } else {
                        queue.add(new Node(nx, ny, count+1));
                    }
                    visited[nx][ny] = true;

                }
            }
        }
    }
}
