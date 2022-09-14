package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * K번째 최단경로 찾기
 */
public class Main_1854 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int k = Integer.parseInt(s[2]);


        ArrayList<Node>[] nodes = new ArrayList[n + 1];
        PriorityQueue<Integer>[] distance = new PriorityQueue[n + 1];

        for (int i = 1; i <= n; i++) {
            distance[i] = new PriorityQueue<>(k, (o1, o2) -> o2 - o1);
        }

        for (int i = 1; i <= n; i++) {
            nodes[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            nodes[start].add(new Node(to, value));
        }


        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(1, 0));
        distance[1].add(0);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int to = node.to;
            int value = node.value;


            for (Node next : nodes[to]) {

                if (distance[next.to].size() < k) {
                    distance[next.to].add(next.value + value);
                    queue.add(new Node(next.to, value + next.value));
                } else {
                    if (distance[next.to].peek() > next.value + value) {
                        distance[next.to].poll();
                        distance[next.to].add(next.value + value);
                        queue.add(new Node(next.to, value + next.value));
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (distance[i].size() != k) {
                sb.append(-1).append("\n");
            } else {
                sb.append(distance[i].peek()).append("\n");
            }
        }

        System.out.println(sb);
    }

    private static class Node implements Comparable<Node> {
        int to;
        int value;

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
