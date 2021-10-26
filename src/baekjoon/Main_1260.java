package baekjoon;

import java.util.*;
import java.util.stream.Collectors;

public class Main_1260 {

    static int n,m, v;
    static boolean visit[];
    static ArrayList<Integer> list[];


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        v = sc.nextInt();

        list = new ArrayList[1001];
        visit = new boolean[1001];

        for (int i = 1; i <= n ; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            list[n1].add(n2);
            list[n2].add(n1);
        }
        for (int i=1; i<=n; i++) {
            Collections.sort(list[i]);
        }
        dfs(v);
        System.out.println();
        visit = new boolean[n+1];
        bfs(v);
        System.out.println();
    }

    private static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(v);
        visit[v] = true;
        while (!queue.isEmpty()) {
            int x = queue.remove();
            System.out.print(x + " ");
            for (Integer next : list[x]) {
                if (!visit[next]) {
                    visit[next] = true;
                    queue.add(next);
                }
            }
        }
    }

    private static void dfs(int v) {

        if (visit[v]) {
            return;
        }
        visit[v] = true;
        System.out.print(v +" ");


        for (Integer next : list[v]) {
            if (!visit[next]) {
                dfs(next);
            }
        }
    }
}
