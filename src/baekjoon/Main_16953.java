package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_16953 {

    static class Node {
        long now;
        int count;

        public Node(long now, int count) {
            this.now = now;
            this.count = count;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        long start = sc.nextLong();
        long end = sc.nextLong();
        int min = Integer.MAX_VALUE;

        if (start > 5 * Math.pow(10, 8)) {
            System.out.println(-1);
            return;
        }
        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(start, 1));
        while (!queue.isEmpty()) {

            Node poll = queue.poll();
            long now = poll.now;
            int count = poll.count;

            if (now == end) {
                min = Math.min(min, count);
            }

            if (now * 2 <= Math.pow(10, 9)) {
                queue.add(new Node(now * 2, count + 1));
            }
            if (now * 10 + 1 <= Math.pow(10, 9)) {
                queue.add(new Node(now * 10 + 1, count + 1));
            }
        }

        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }
}
