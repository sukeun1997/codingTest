package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_2178 {

    static int n, m, result = 0;
    static boolean visit[][];
    static int mirror[][];
    static Queue<Node> queue = new LinkedList<>();
    static int rx[] = {1, -1, 0, 0};
    static int ry[] = {0, 0, 1, -1};

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

        n = sc.nextInt();
        m = sc.nextInt();

        mirror = new int[n][m];
        visit = new boolean[n][m];

        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String[] s = sc.nextLine().split("");
            for (int j = 0; j < m; j++) {
                mirror[i][j] = Integer.parseInt(s[j]);
            }
        }

        visit[0][0] = true;
        queue.add(new Node(0, 0, 1));
        bfs();


    }

    private static void bfs() {

        while (!queue.isEmpty()) {
            Node node = queue.remove();
            int x = node.x;
            int y = node.y;
            int distance = node.distance;

            for (int i = 0; i < 4; i++) {
                int nextX = x - rx[i];
                int nextY = y - ry[i];

                if ((nextX >= 0 && nextX < n) && (nextY >= 0 && nextY < m)) {
                    if (!visit[nextX][nextY] && mirror[nextX][nextY] > 0) {
                        if (nextX == n - 1 && nextY == m - 1) {
                            System.out.println(distance + 1);
                            return;
                        }
                        visit[nextX][nextY] = true;
                        queue.add(new Node(nextX, nextY, distance + 1));
                    }
                }
            }
        }
    }
}
