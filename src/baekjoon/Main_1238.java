package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1238 {

    /**
     * N = 1000
     * M = 10000
     * T = 1~100
     * 1초 => 1억
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int x = Integer.parseInt(s[2]);

        ArrayList<Town>[] edges = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges[start].add(new Town(end, cost));
        }

        int[][] dist = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        for (int i = 1; i <= n; i++) {
            boolean[] visited = new boolean[n + 1];
            findMinLoad(edges, dist, i, visited);
        }

        int max = 0;

        for (int j = 1; j <= n; j++) {
            if (max < dist[x][j] + dist[j][x]) {
                max = dist[x][j] + dist[j][x];
            }
        }

        System.out.println(max);
    }

    private static void findMinLoad(ArrayList<Town>[] edges, int[][] dist, int start, boolean[] visited) {
        Queue<Town> queue = new PriorityQueue<>();

        dist[start][start] = 0;
        queue.add(new Town(start, 0));

        while (!queue.isEmpty()) {

            Town poll = queue.poll();
            int end = poll.end;
            int cost = poll.cost;
            if (visited[end]) {
                continue;
            }

            visited[end] = true;

            for (Town town : edges[end]) {
                if (dist[start][town.end] > cost + town.cost) {
                    dist[start][town.end] = cost + town.cost;
                    queue.add(new Town(town.end, cost + town.cost));
                }
            }
        }
    }

    private static class Town implements Comparable<Town>{
        int end, cost;

        public Town(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Town o) {
            return this.cost-o.cost;
        }
    }
}
