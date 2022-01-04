package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_1743 {

    private static class Node{
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int map[][];
    static boolean visited[][];
    static int col , row;
    static Queue<Node> queue = new LinkedList<>();
    static int max = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        row = sc.nextInt();
        col = sc.nextInt();
        int count = sc.nextInt();

        map = new int[row][col];
        visited = new boolean[row][col];

        for (int i = 0; i < count; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            map[x - 1][y - 1] = 1;
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    visited[i][j] = true;
                    queue.add(new Node(i, j));
                    bfs();
                }
            }
        }

        System.out.println(max);
    }

    private static void bfs() {
        int move[][] = new int[][]{{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
        int count = 1;
        while (!queue.isEmpty()) {

            Node poll = queue.poll();
            int x = poll.x;
            int y = poll.y;

            for (int i = 0; i < 4; i++) {
                int nx = x - move[i][0];
                int ny = y - move[i][1];

                if (nx < 0 || ny < 0 || nx >= row || ny >= col) {
                    continue;
                }

                if (!visited[nx][ny] && map[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    queue.add(new Node(nx, ny));
                    count++;
                }
            }
        }

        max = Math.max(max, count);
    }
}
