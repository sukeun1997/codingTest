package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 최단경로
 */
public class Main_1753 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int start = Integer.parseInt(br.readLine());

        ArrayList<Node>[] lists = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            lists[i] = new ArrayList<>();
        }

        boolean[] visited = new boolean[n + 1];

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            lists[Integer.parseInt(st.nextToken())].add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        PriorityQueue<Node> queue = new PriorityQueue<>();

        queue.add(new Node(start, 0));

        int[] distance = new int[n + 1];

        Arrays.fill(distance, Integer.MAX_VALUE);

        while (!queue.isEmpty()) {

            Node poll = queue.poll();
            int to = poll.to;
            int value = poll.value;

            if (visited[to]) {
                continue;
            }

            if (distance[to] > value) {
                distance[to] = value;
            }

            visited[to] = true;

            for (Node node : lists[to]) {
                if (distance[node.to] > value + node.value) {
                    queue.add(new Node(node.to, value + node.value));
                }
            }
        }


        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(distance[i] == Integer.MAX_VALUE ? "INF" : distance[i]).append("\n");
        }

        System.out.println(sb.toString());
    }

    private static class Node implements Comparable<Node> {

        int to, value;

        public Node(int to, int value) {
            this.to = to;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }
    }
}
