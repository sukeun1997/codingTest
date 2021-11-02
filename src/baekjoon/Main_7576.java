package baekjoon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_7576 {

    static int n, m;
    static int tomato[][];
    static boolean visit[][];
    static Queue<Node> queue = new LinkedList<>();
    static int rx[] = {1, -1, 0, 0};
    static int ry[] = {0, 0, 1, -1};
    static int count = 0;

    private static class Node {
        int x;
        int y;
        int distance;

        public Node(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); // y축
        m = sc.nextInt(); // x축

        tomato = new int[m][n];
        visit = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                tomato[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (!visit[i][j] && tomato[i][j] == 1) {
                    visit[i][j] = true;
                    queue.add(new Node(i, j, 0));
                }
            }
        }

        bfs();

        for (int[] ints : tomato) {
            for (int i : ints) {
                if (i == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(count);

    }

    private static void bfs() {

        while (!queue.isEmpty()) {

            Node next = queue.remove();

            int x = next.x;
            int y = next.y;
            int distance = next.distance;

            for (int k = 0; k < 4; k++) {
                int nextX = x - rx[k];
                int nextY = y - ry[k];

                if ((nextX >= 0 && nextX < m) && (nextY >= 0 && nextY < n)) {
                    if (!visit[nextX][nextY] && tomato[nextX][nextY] == 0) {
                        visit[nextX][nextY] = true;
                        tomato[nextX][nextY] = 1;
                        if (count < distance + 1) {
                            count = distance + 1;
                        }
                        queue.add(new Node(nextX, nextY, distance + 1));
                    }
                }
            }
        }
    }

}
