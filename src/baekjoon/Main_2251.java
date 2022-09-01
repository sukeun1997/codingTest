package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 물통
 */
public class Main_2251 {

    private static boolean[][] visited;
    private static boolean[] ans;

    private static int[] max;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        max = new int[3];

        for (int i = 0; i < 3; i++) {
            max[i] = sc.nextInt();
        }

        visited = new boolean[201][201];
        ans = new boolean[201];

        bfs();

        for (int i = 0; i <= max[2]; i++) {
            if (ans[i]) {
                System.out.print(i + " ");
            }
        }


    }

    private static int move[][] = new int[][]{{0, 1}, {0, 2}, {1, 0}, {1, 2}, {2, 0}, {2, 1}};

    private static void bfs() {
        Queue<AB> queue = new LinkedList<>();

        queue.add(new AB(0, 0));
        visited[0][0] = true;
        ans[max[2]] = true;

        while (!queue.isEmpty()) {
            AB poll = queue.poll();
            int a1 = poll.a;
            int b1 = poll.b;
            int curC = max[2] - a1 - b1;

            for (int i = 0; i < 6; i++) {
                int[] next = new int[]{a1, b1, curC};
                int start = move[i][0];
                int to = move[i][1];

                next[to] += next[start];
                next[start] = 0;

                if (next[to] > max[to]) {
                    next[start] = next[to] - max[to];
                    next[to] = max[to];
                }

                if (!visited[next[0]][next[1]]) {
                    visited[next[0]][next[1]] = true;
                    queue.add(new AB(next[0], next[1]));

                    if (next[0] == 0) {
                        ans[next[2]] = true;
                    }
                }

            }
        }
    }

    private static class AB {
        int a, b;

        public AB(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

}
