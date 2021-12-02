package baekjoon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_16954 {

    static char map[][];
    static Queue<Node> queue = new LinkedList<>();
    static Queue<Node> mapQ = new LinkedList<>();
    static int rx[] = {1, 1, 1, 0, 0, 0, -1, -1, -1};
    static int ry[] = {1, -1, 0, 0, 1, -1, 1, 0, -1};

    private static class Node {
        private int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        map = new char[8][8];

        for (int i = 0; i < 8; i++) {
            map[i] = sc.nextLine().toCharArray();
        }

        bfs();
    }

    private static void bfs() {
        queue.add(new Node(7, 0));

        while (!queue.isEmpty()) {
            boolean visit[][] = new boolean[8][8];

            int size = queue.size();
            // 플레이어 이동
            for (int i = 0; i < size; i++) {

                Node remove = queue.remove();
                int x = remove.x;
                int y = remove.y;

                if (map[x][y] == '#') {
                    continue;
                }
                if (x == 0 && y == 7) {
                    System.out.println(1);
                    return;
                }

                int nx = x - rx[i];
                int ny = y - ry[i];

                if (nx < 0 || ny < 0 || nx >= 8 || ny >= 8) continue;
                if (visit[nx][ny] || map[nx][ny] == '#') continue;

                        queue.add(new Node(nx, ny));
                        visit[nx][ny] = true;


            }

            //벽 이동
            wall_move();
        }

        System.out.println(0);
    }

    private static void wall_move() {

        for (int i = 7; i >= 0; i--) {
            for (int j = 0; j < 8; j++) {
                if (map[i][j] == '#') {
                    map[i][j] = '.';

                    if (i != 7) {
                        map[i + 1][j] = '#';
                    }
                }
            }
        }
    }

}

