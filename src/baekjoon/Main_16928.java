package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_16928 {

    static boolean visit[] = new boolean[101];
    static int snake[] = new int[101];
    static int ladder[] = new int[101];
    static Queue<Node> queue = new LinkedList<>();

    private static class Node {
        int x;
        int cnt;

        public Node(int x, int cnt) {
            this.x = x;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int start = 1;

        int n = sc.nextInt();
        int m = sc.nextInt();


        for (int i = 0; i < n; i++) {
            ladder[sc.nextInt()] = sc.nextInt();
        }

        for (int i = 0; i < m; i++) {
            snake[sc.nextInt()] = sc.nextInt();
        }

        bfs();

    }

    private static void bfs() {

        queue.add(new Node(1,0));

        while (!queue.isEmpty()) {

            Node node = queue.remove();
            int next = node.x;
            int cnt = node.cnt;

            for (int i = 1; i <= 6 ; i++) {
                int nextNum = next + i;
                if (nextNum == 100) {
                    System.out.println(cnt+1);
                    return;
                }
                if (nextNum <= 100) {
                    if (!visit[nextNum]) {
                        visit[nextNum] = true;
                        if (ladder[nextNum] != 0) {
                            nextNum = ladder[nextNum];
                            visit[nextNum] = true;
                        }
                        if (snake[nextNum] != 0) {
                            nextNum = snake[nextNum];
                            visit[nextNum] = true;
                        }
                        queue.add(new Node(nextNum,cnt+1));
                    }
                }
            }
        }
    }
}
