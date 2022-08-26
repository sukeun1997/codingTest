package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 트리의 지름
 */
public class Main_1167 {

    private static class Node {

        int to, dist;

        public Node(int to, int dist) {
            this.to = to;
            this.dist = dist;
        }
    }

    private static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        ArrayList<Node>[] list = new ArrayList[n + 1];

        StringTokenizer st;

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());

            while (true) {
                int b = Integer.parseInt(st.nextToken());

                if (b == -1) {
                    break;
                }

                list[a].add(new Node(b, Integer.parseInt(st.nextToken())));
            }
        }

        boolean[] visited = new boolean[n + 1];
        int next = bfs(1, visited, list);

        visited = new boolean[n + 1];
        bfs(next, visited, list);

        System.out.println(max);
    }

    private static int bfs(int i, boolean[] visited, ArrayList<Node>[] list) {
        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> o2.dist - o1.dist);
        queue.add(new Node(i, 0));

        int next = 0;
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int to = poll.to;
            int dist = poll.dist;

            visited[to] = true;

            if (max < dist) {
                max = dist;
                next = to;
            }

            for (Node node : list[to]) {
                if (!visited[node.to]) {
                    queue.add(new Node(node.to, dist + node.dist));
                }
            }
        }

        return next;
    }
}
