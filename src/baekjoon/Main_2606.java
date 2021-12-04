package baekjoon;

import java.util.*;

public class Main_2606 {

    static Queue<Integer> queue = new LinkedList<>();
    static boolean visit[];
    static ArrayList<Integer> list[];
    static int count = 0;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        visit = new boolean[n+1];

        list = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            list[n1].add(n2);
            list[n2].add(n1);
        }

        bfs();
        System.out.println(count);
    }

    private static void bfs() {

        queue.add(1);
        visit[1] = true;
        while (!queue.isEmpty()) {

            int start = queue.remove();

            for (Integer next : list[start]) {
                if (!visit[next]) {
                    visit[next] = true;
                    count++;
                    queue.add(next);
                }
            }
        }
    }
}
