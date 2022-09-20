package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11657 {

    /**
     * N = 1~500
     * M = 1~6000
     */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);

        Node[] nodes = new Node[m + 1];

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            nodes[i] = new Node(start, end, cost);
        }

        long[] ans = new long[n + 1];

        Arrays.fill(ans, Integer.MAX_VALUE);

        ans[1] = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Node node = nodes[j];

                if (ans[node.start] != Integer.MAX_VALUE && ans[node.end] > node.cost + ans[node.start]) {
                    ans[node.end] = node.cost + ans[node.start];
                }
            }
        }

        for (int i = 0; i < m; i++) {
            Node node = nodes[i];

            if (ans[node.start] != Integer.MAX_VALUE && ans[node.end] > node.cost + ans[node.start]) {
                System.out.println(-1);
                return;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= n; i++) {
            sb.append(ans[i] == Integer.MAX_VALUE ? -1 : ans[i]).append("\n");
        }
        System.out.println(sb.toString());

    }


    private static class Node {
        int start, end, cost;

        public Node(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }
}
