package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_7562 {

    static int chess[][];
    static boolean visited[][];
    static int t, n;
    static Queue<Node> queue = new LinkedList<>();
    static int rx[] = {1, 1, 2, 2, -1, -1, -2, -2};
    static int ry[] = {2, -2, 1, -1, 2, -2, 1, -1};
    private static class Node {

        int x;
        int y;
        int moveCount;

        public Node(int x, int y, int moveCount) {
            this.x = x;
            this.y = y;
            this.moveCount = moveCount;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        t = sc.nextInt();

        for (int i = 0; i < t; i++) {

            n = sc.nextInt();
            chess = new int[n][n];
            visited = new boolean[n][n];
            int startX = sc.nextInt();
            int startY = sc.nextInt();
            int findX = sc.nextInt();
            int findY = sc.nextInt();

            if (startX == findX && startY == findY) {
                System.out.println(0);
                continue;
            }
            bfs(startX, startY,findX,findY);
            queue.clear();
        }
    }

    private static void bfs(int startX, int startY, int findX, int findY) {

        visited[startX][startY] = true;
        queue.add(new Node(startX, startY, 0));

        while (!queue.isEmpty()) {
            Node node = queue.remove();

            int x = node.x;
            int y = node.y;
            int moveCount = node.moveCount;

            for (int i = 0; i < 8; i++) {
                int nextX = x - rx[i];
                int nextY = y - ry[i];

                if ((nextX >= 0 && nextX < n) && (nextY >= 0 && nextY < n)) {
                    if (nextX == findX && nextY == findY) {
                        System.out.println(moveCount + 1);
                        return;
                    }
                    if (!visited[nextX][nextY]) {
                        visited[nextX][nextY] = true;
                        queue.add(new Node(nextX, nextY, moveCount + 1));
                    }
                }
            }

        }

    }
}
