package baekjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 줄 세우기
 */
public class Main_2252 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<Integer>[] lists = new ArrayList[n + 1];
        int[] counts = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int to = sc.nextInt();
            int start = sc.nextInt();
            lists[start].add(to);
            counts[to]++;
        }

        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if (counts[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            Integer now = queue.poll();

            ans.add(now);

            for (Integer next : lists[now]) {
                counts[next]--;
                if (counts[next] == 0) {
                    queue.add(next);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = ans.size() - 1; i >= 0; i--) {
            sb.append(ans.get(i)).append(" ");
        }

        System.out.println(sb.toString());

    }
}
