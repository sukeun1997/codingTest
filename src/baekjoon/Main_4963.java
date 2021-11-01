package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_4963 {

    static int land[][];
    static boolean visit[][];
    static int rx[] = {1, 1, -1, -1, 1, -1, 0, 0};
    static int ry[] = {1, -1, 1, -1, 0, 0, 1, -1};
    static int landCount = 0;
    static Queue<Integer> queue = new LinkedList();
    static int n;
    static int m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            landCount = 0;
            n = sc.nextInt();
            m = sc.nextInt();

            if (n == 0 && m == 0) {
                return;
            }

            land = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    land[i][j] = sc.nextInt();
                }
            }
            visit = new boolean[m][n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visit[i][j] && land[i][j] > 0) {
                        bfs(i,j);
                    }
                }
            }
            System.out.println(landCount);

        }
    }

    private static void bfs(int i, int j) {
        visit[i][j] = true;
        queue.add(i);
        queue.add(j);
        landCount++;
        while (!queue.isEmpty()) {
            int x = queue.remove();
            int y = queue.remove();

            for (int k = 0; k < 8; k++) {
                int nextX = x - rx[k];
                int nextY = y - ry[k];

                if ( (nextX >= 0 && nextX < m) && (nextY >= 0 && nextY < n)) {
                    if (!visit[nextX][nextY] && land[nextX][nextY] > 0) {
                        visit[nextX][nextY] = true;
                        queue.add(nextX);
                        queue.add(nextY);
                    }
                }
            }
        }
    }
}
