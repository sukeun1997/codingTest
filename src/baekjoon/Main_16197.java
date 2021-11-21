package baekjoon;

import java.util.*;

public class Main_16197 {

    static String map[][];
    static int rx[] = {1, -1, 0, 0};
    static int ry[] = {0, 0, 1, -1};
    static Queue<Coin> queue = new LinkedList<>();
    static int count = -1;

    private static class Coin {
        int x1,y1;
        int x2,y2;
        int move;

        public Coin(int x1, int y1, int x2, int y2, int move) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.move = move;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();

        map = new String[x][y];

        Queue<Integer> queue1 = new LinkedList<>();

        sc.nextLine();

        for (int i = 0; i < x; i++) {
            String s[] = sc.nextLine().split("");
            for (int j = 0; j < y; j++) {
                if (s[j].equals("o")) {
                    queue1.add(i);
                    queue1.add(j);
                }
                map[i][j] = s[j];
            }
        }

        queue.add(new Coin(queue1.remove(), queue1.remove(), queue1.remove(), queue1.remove(), 0));

        bfs(x,y);

        System.out.println(count);
    }

    private static void bfs(int n,int m) {


        while (!queue.isEmpty()) {
            Coin coin = queue.remove();
            int x1 = coin.x1;
            int y1 = coin.y1;
            int x2 = coin.x2;
            int y2 = coin.y2;
            int move = coin.move;

            for (int i = 0; i < 4; i++) {
                int out = 0;
                int nextX = x1 - rx[i];
                int nextY = y1 - ry[i];
                int nextX2 = x2 - rx[i];
                int nextY2 = y2 - ry[i];

                if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) {
                    out++;
                }
                if (nextX2 < 0 || nextX2 >= n || nextY2 < 0 || nextY2 >= m) {
                    out++;
                }
                if (out == 2) {
                    continue;
                }
                if (out == 1) {
                    count = move + 1;
                    return;
                }
                if (move >= 10) {
                    count = -1;
                    return;
                }
                if (map[nextX][nextY].equals("#")) {
                    nextX = x1;
                    nextY = y1;
                }
                if (map[nextX2][nextY2].equals("#")) {
                    nextX2 = x2;
                    nextY2 = y2;
                }

                queue.add(new Coin(nextX, nextY, nextX2, nextY2,move+1));

            }
        }
    }


}
