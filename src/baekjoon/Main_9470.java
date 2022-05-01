package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main_9470 {

    private static class Node implements Comparable<Node> {
        int to , count;

        public Node(int to, int count) {
            this.to = to;
            this.count = count;
        }

        @Override
        public int compareTo(Node o) {
            return this.count - o.count;
        }
    }

    static PriorityQueue<Node> priorityQueue = new PriorityQueue<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            int m = sc.nextInt();
            int p = sc.nextInt();

            List<Integer> list[] = new List[m + 1];

            for (int j = 0; j <= m; j++) {
                list[j] = new ArrayList<>();
            }

            for (int j = 0; j < p; j++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                list[start].add(end);
            }
            sb.append(t).append(" ").append(Strahler(list, m)).append("\n");
            System.out.println(sb);
        }
    }

    private static int Strahler(List<Integer>[] list, int m) {

        int count  = 0;
        priorityQueue.add(new Node(1, 1));

        while (!priorityQueue.isEmpty()) {

            Node poll = priorityQueue.poll();

            count = Math.max(count, poll.count);

            if (list[poll.to] != null) {
                for (Integer next : list[poll.to]) {


                            priorityQueue.add(new Node(next, poll.count ));


                }
            }
        }
        return count;
    }
}
