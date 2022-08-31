package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 효율적인 해킹
 */
public class Main_1325 {

    private static int[] ans;
    private static boolean[] visited;
    private static ArrayList<Integer>[] graphs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        graphs = new ArrayList[n + 1];
        ans = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            graphs[i] = new ArrayList<>();
        }


        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graphs[from].add(to);

        }

        for (int i = 1; i <= m; i++) {
            visited = new boolean[n + 1];
            find(i);
        }

        int max = 0;
        for (int an : ans) {
            max = Math.max(an, max);
        }

        for (int i = 0; i < ans.length; i++) {
            if (ans[i] == max) {
                System.out.print(i + " ");
            }
        }
    }


    private static void find(int i) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(i);
        visited[i] = true;
        while (!queue.isEmpty()) {
            int poll = queue.poll();

            for (int integer : graphs[poll]) {
                if (!visited[integer]) {
                    visited[poll] = true;
                    ans[integer]++;
                    queue.add(integer);
                }
            }
        }

    }
}
