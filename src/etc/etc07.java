package etc;

import java.util.Scanner;

/**
 * 게임 개발 1초
 */
public class etc07 {

    static int move[][] = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int d = sc.nextInt();

        int map[][] = new int[n][m];
        boolean visited[][] = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        visited[a][b] = true;

        int count = 1;
        int turn = 0;
        while (true) {
            d = selectDirect(d);

            int nextX = a + move[d][0];
            int nextY = b + move[d][1];

            if (nextX < 0 || nextY < 0 || nextY >= m || nextX >= m) {
                continue;
            }
            if (map[nextX][nextY] == 0 && !visited[nextX][nextY]) {
                count++;
                turn = 0;
                visited[nextX][nextY] = true;
                a = nextX;
                b = nextY;
            } else {
                turn += 1;
            }

            if (turn == 4) {
                nextX = a - move[d][0];
                nextY = b - move[d][1];

                if (map[nextX][nextY] == 0) {
                    a = nextX;
                    b = nextY;
                } else {
                    System.out.println(count);
                    return;
                }
                turn = 0;
            }
        }
    }

    private static int selectDirect(int d) {
        d = d - 1;
        if (d < 0) {
            d = 3;
        }

        return d;
    }

}
