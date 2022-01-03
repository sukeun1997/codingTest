package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_17070 {

    private static class Node {
        int x, y, state;

        public Node(int x, int y, int state) {
            this.x = x;
            this.y = y;
            this.state = state;
        }
    }


    static Queue<Node> queue = new LinkedList<>();
    static boolean visited[][];
    static int map[][];
    static int rx[] = new int[]{0, 1, 1};
    static int ry[] = new int[]{1, 1, 0};
    static int n, count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        if (map[n - 1][n - 1] == 1) {
            System.out.println(0);
            return;
        }
        bfs();

        System.out.println(count);
    }

    private static void bfs() {
        queue.add(new Node(0, 1, 0));


        while (!queue.isEmpty()) {

            Node poll = queue.poll();
            int x = poll.x;
            int y = poll.y;
            int state = poll.state;


            if (x == n - 1 && y == n - 1) {
                count++;
                continue;
            }

            int start = 0;
            int end = 3;
            if (state == 0) {
                end = 2;
            } else if (state == 2) {
                start = 1;
            }


            for (int i = start; i < end; i++) {

                int nextx = x + rx[i];
                int nexty = y + ry[i];


                if (nextx < 0 || nextx >= n || nexty < 0 || nexty >= n) {
                    continue;
                }
                if (i == 1) {
                    if (map[nextx][nexty] != 1 && map[nextx - 1][nexty] != 1 && map[nextx][nexty - 1] != 1) {
                        queue.add(new Node(nextx, nexty, i));
                    }
                } else {
                    if (map[nextx][nexty] != 1) {
                        queue.add(new Node(nextx, nexty, i));
                    }
                }
            }
        }
    }
}
