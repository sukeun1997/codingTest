package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 최소 스패닝 트리
 */
public class Main_1197 {

    static class Node {
        int to , count;

        public Node(int to, int count) {
            this.to = to;
            this.count = count;
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Node> arrayList[] = new ArrayList[n+1];

        for (int i = 1; i <= n; i++) {
            arrayList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            arrayList[a].add(new Node(b, c));
            arrayList[b].add(new Node(a, c));
        }


        prim(n, arrayList);
    }

    private static void prim(int n, ArrayList<Node>[] arrayList) {
        boolean visited[] = new boolean[n + 1];

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.count));

        pq.add(new Node(1, 0));

        int distance = 0;
        while (!pq.isEmpty()) {
            Node poll = pq.poll();

            int to = poll.to;
            int count = poll.count;

            if (visited[to]) {
                continue;
            }

            visited[to] = true;
            distance += count;

            for (Node node : arrayList[to]) {
                if (!visited[node.to]) {
                    pq.add(new Node(node.to, node.count));
                }
            }
        }

        System.out.println(distance);
    }
}
