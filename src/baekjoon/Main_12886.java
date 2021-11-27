package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_12886 {

    static boolean visit[][];
    static Queue<Node> queue = new LinkedList<>();

    private static class Node {
        int[] number = new int[3];

        public Node(int a, int b, int c) {
            this.number[0] = a;
            this.number[1] = b;
            this.number[2] = c;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        visit = new boolean[1501][1501];

        bfs(a, b, c);
    }

    private static void bfs(int a, int b, int c) {
        if ((a + b + c) % 3 != 0) {
            System.out.println(0);
            return;
        }

        queue.add(new Node(a, b, c));
        visit[a][b] = true;

        while (!queue.isEmpty()) {
            Node remove = queue.remove();
            int A = remove.number[0];
            int B = remove.number[1];
            int C = remove.number[2];

            if (A == B && B == C) {
                System.out.println(1);
                return;
            }

            if (A != B) {
                int na = A > B ? A - B : A * 2;
                int nb = A > B ? B * 2 : B - A;
                    if (!visit[na][nb]) {
                        visit[na][nb] = true;
                        queue.add(new Node(na, nb, C));
                    }

            }
            if (A != C) {
                int na = A > C ? A - C : A * 2;
                int nb = A > C ? C * 2 : C - A;
                    if (!visit[na][nb]) {
                        visit[na][nb] = true;
                        queue.add(new Node(na, B, nb));
                    }

            }
            if (C != B) {
                int na = B > C ? B - C : B * 2;
                int nb = B > C ? C * 2 : C - B;
                    if (!visit[na][nb]) {
                        visit[na][nb] = true;
                        queue.add(new Node(A, na, nb));
                    }

            }

        }

        System.out.println(0);
    }
}
