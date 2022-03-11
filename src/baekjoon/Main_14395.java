package baekjoon;

import java.util.*;

public class Main_14395 {

    public static final int MAX = 1000000000;

    static class Node {

        long now;
        String print;

        public Node(long now, String print) {
            this.now = now;
            this.print = print;
        }
    }

    static Set<Long> visited = new HashSet<>();
    static Queue<Node> queue = new LinkedList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int s = sc.nextInt();
        int t = sc.nextInt();

        if (s == t) {
            System.out.println(0);
            return;
        }

        queue.add(new Node(s, ""));
        visited.add((long) s);

        bfs(t);
    }

    private static void bfs(int t ) {

        while (!queue.isEmpty()) {

            Node poll = queue.poll();
            long now = poll.now;
            String print = poll.print;

            if (now == t) {
                System.out.println(poll.print);
                return;
            }

            if (now < MAX && !visited.contains(now*now)) {
                visited.add(now*now);
                queue.add(new Node(now*now, print + "*"));
            }
            if (now < MAX && !visited.contains(now*2)) {
                visited.add(now * 2);
                queue.add(new Node(now * 2, print + "+"));
            }
            if (!visited.contains(now/now)) {
                visited.add(now/now);
                queue.add(new Node(now/now, print + "/"));
            }
        }
        System.out.println(-1);

    }


}
