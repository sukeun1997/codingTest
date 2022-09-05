package baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 여행 가자
 */
public class Main_1976 {

    private static ArrayList<Integer>[] list;
    private static int[] parent;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        list = new ArrayList[n + 1];
        parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < n; j++) {
                int to = sc.nextInt();

                if (to == 1) {
                    list[i].add(j + 1);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < list[i].size(); j++) {
                Integer to = list[i].get(j);
                union(i, to);

            }
        }

        int end = 0;
        for (int i = 0; i < m; i++) {
            int next = sc.nextInt();

            if (end == 0) {
                end = find(next);
            } else {
                if (end != find(next)) {
                    System.out.println("NO");
                    return;
                }
            }
        }

        System.out.println("YES");

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
