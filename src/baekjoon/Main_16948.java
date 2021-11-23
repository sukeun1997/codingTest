package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_16948 {


    static int rx[] = {-2, -2, 0, 0, 2, 2};
    static int ry[] = {-1, 1, -2, 2, -1, 1};
    static int n;
    static int death[];
    static boolean visit[][];
    static int count = -1;
    static Queue<Node> queue = new LinkedList<>();

    private static class Node {
        int x,y;
        int move;

        public Node(int x, int y, int move) {
            this.x = x;
            this.y = y;
            this.move = move;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        n = sc.nextInt();

        death = new int[n];
        visit = new boolean[n][n];

        for (int i = 0; i < 4; i++) {
            death[i] = sc.nextInt();
        }

        bfs();
        System.out.println(count);

    }

    private static void bfs() {

        queue.add(new Node(death[0], death[1], 0));
        visit[death[0]][death[1]] = true;

        while (!queue.isEmpty()) {
            Node remove = queue.remove();
            int x = remove.x;
            int y = remove.y;
            int move = remove.move;


            for (int i = 0; i < 6; i++) {
                int nextX = x - rx[i];
                int nextY = y - ry[i];

                if (nextX == death[2] && nextY == death[3]) {
                    count = move + 1;
                    return;
                }


                if ((nextX >= 0 && nextX < n) && (nextY >= 0 && nextY < n)) {
                    if (!visit[nextX][nextY]) {
                        visit[nextX][nextY] = true;
                        queue.add(new Node(nextX, nextY, move + 1));
                    }
                }
            }
        }
    }
}
