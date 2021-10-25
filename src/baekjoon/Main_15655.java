package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main_15655 {

    static int n, m;
    static int[] result;
    static int[] list;
    static boolean[] visit;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        list = new int[n];
        result = new int[m];
        visit = new boolean[n+1];
        for (int i = 0; i < n; i++) {
            list[i] = sc.nextInt();
        }
        list = Arrays.stream(list).sorted().toArray();

        go(0);
    }

    private static void go(int start) {
        if (start == m) {
            for (int i = 0; i < m-1; i++) {
                if (result[i] > result[i + 1]) {
                    return;
                }
            }
            for (int i = 0; i < result.length; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < n ; i++) {
            if (!visit[i]) {
                visit[i] = true;
                result[start] = list[i];
                go(start+1);
                visit[i] = false;
            }
        }
    }
}
