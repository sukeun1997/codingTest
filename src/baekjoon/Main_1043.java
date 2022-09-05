package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 거짓말
 */
public class Main_1043 {

    static boolean[] know;
    static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int n = sc.nextInt();
        int m = sc.nextInt();

        know = new boolean[n + 1];
        parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        int count = sc.nextInt();

        for (int i = 0; i < count; i++) {
            int trueP = sc.nextInt();

            know[trueP] = true;
        }


        int ans = 0;

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int seq = sc.nextInt();
            int start = 0;

            for (int j = 0; j < seq; j++) {
                int next = sc.nextInt();
                if (start == 0) {
                    start = next;
                    continue;
                }
                union(next, start);
            }
            list.add(start);
        }


        for (Integer integer : list) {
            boolean possible = true;
            for (int i = 1; i <= n; i++) {
                if (know[i]) {
                    if (find(integer) == find(i)) {
                        possible = false;
                        break;
                    }
                }
            }

            if (possible) {
                ans++;
            }

        }

        System.out.println(ans);
    }


    private static int find(int a) {
        if (a == parent[a]) {
            return a;
        }
        parent[a] = find(parent[a]);
        return parent[a];
    }

    private static void union(int a, int b) {

        int aRoot = find(a);
        int bRoot = find(b);

        if (aRoot != bRoot) {
            parent[aRoot] = b;
        } else {
            return;
        }
    }
}
