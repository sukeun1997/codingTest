package baekjoon;

import java.lang.management.MonitorInfo;
import java.util.*;

public class Main_12851 {

    public static final int MAX = 100000;

    static class Node {

        int now, count;

        public Node(int now, int count) {
            this.now = now;
            this.count = count;
        }
    }

    static Queue<Node> queue = new LinkedList<>();
    static boolean visited[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        visited = new boolean[200001];
        int min_count[] = new int[200001];
        int min = 0;

        visited[N] = true;
        queue.add(new Node(N, 0));

        Arrays.fill(min_count, Integer.MAX_VALUE);

        while (!queue.isEmpty()) {

            Node poll = queue.poll();

            int count = poll.count;
            int now = poll.now;

            if (min_count[now] > count) {
                min_count[now] = count;
            }

            if (now == K && count == min_count[K]) {
                min++;
            }

            int next = now + 1;
            if (next <= MAX) {
                if (!visited[next] || min_count[now] < min_count[next]) {
                    visited[next] = true;
                    queue.add(new Node(next, count + 1));
                }
            }
            next = now - 1;
            if (next >= 0) {
                if (!visited[next] || min_count[now] < min_count[next]) {
                    visited[next] = true;
                    queue.add(new Node(next, count + 1));
                }
            }

            next = now * 2;
            if (next <= MAX) {
                if (!visited[next] || min_count[now] < min_count[next]) {
                    visited[next] = true;
                    queue.add(new Node(next, count + 1));
                }
            }
        }

        System.out.println(min_count[K]);
        System.out.println(min);
    }
}
