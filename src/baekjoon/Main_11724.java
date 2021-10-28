package baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class Main_11724 {


    static ArrayList<Integer> arrayList[];
    static boolean visit[];
    static int n;
    static int m;
    static int ans = 0;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        arrayList = new ArrayList[n+1];
        visit = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            arrayList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            arrayList[n1].add(n2);
            arrayList[n2].add(n1);
        }

        for (int i = 1; i <= n; i++) {
            if (!visit[i]) {
                dfs(i);
                ans++;
            }
        }
        System.out.println(ans);

    }

    private static void dfs(int i) {

        visit[i] = true;

        for (int next : arrayList[i]) {
            if (!visit[next]) {
                visit[next] = true;
                dfs(next);
            }
        }

    }
}
