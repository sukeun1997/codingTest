package baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class Main_13023 {

    static ArrayList<Integer>[] list;
    static boolean[] v;
    static int n;
    static int m;
    static int ans = 0;
    // 친구관계 : 간선 , 사람 : 정점
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        v = new boolean[n];
        list = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();

        }
        for (int i = 0; i < m; i++) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            list[n1].add(n2);
            list[n2].add(n1);
        }
        for (int i = 0; i <n ; i++) {
            if(ans==0)
            go(i,0);
        }
        System.out.println(ans);
    }

    private static void go(int i,int depth) {
        if (depth == 4) {
            ans = 1;
            return;
        }

            v[i] = true;
            for (Integer next : list[i]) {
                if (!v[next]) {
                    go(next,depth+1);
                }
            }
            v[i] = false;

    }
}
