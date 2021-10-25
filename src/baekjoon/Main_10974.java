package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

/*

public class baekjoon.Main_10974 {

    static int n;
    static boolean[] visit;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        visit = new boolean[n+1];
        String s = "";
        go(1, s);
    }

    private static void go(int start, String s) {

        if (start == n+1) {
            System.out.println(s);
            return;
        }

        for (int i = 1; i <=n ; i++) {
            if (!visit[i]) {
                visit[i] = true;
                go(start + 1, s + i + " ");
                visit[i] = false;
            }
        }
    }
}
*/


public class Main_10974 {

    static int n;
    static int list[];
    static boolean[] visit;
    static int result[];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        list = new int[n];
        visit = new boolean[n];
        result = new int[n];

        for (int i = 0; i < n; i++) {
            list[i] = i + 1;
        }

        go(0);
    }

    private static void go(int start) {

        if (start == n) {
            Arrays.stream(result).forEach(value -> System.out.print(value+" "));
            System.out.println();
            return;
        }

        for (int i = 0; i < n ; i++) {
            if (!visit[i]) {
                visit[i] = true;
                result[start] = list[i];
                go(start + 1);
                visit[i] = false;
            }
        }

    }
}
