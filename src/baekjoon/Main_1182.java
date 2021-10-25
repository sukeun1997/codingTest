package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main_1182 {

    static int n;
    static int result;
    static int list[];
    static boolean visit[];
    static int get[];
    static int count = 0 ;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        result = sc.nextInt();

        list = new int[n + 1];
        visit = new boolean[n + 1];
        get = new int[n];
        for (int i = 1; i <= n ; i++) {
            list[i] = sc.nextInt();
        }

        go(0);
        System.out.println();
    }

    private static void go(int i) {
        if (i == n) {
            Arrays.stream(get).forEach(value -> System.out.print(value));
            System.out.println();
            return;
        }

        for (int j = 1; j <= n ; j++) {
            if (!visit[j]) {
                visit[j] = true;
                get[i] = list[j];
                if (Arrays.stream(get).sum() == result) {
                    count++;
                }
                go(i + 1);
                visit[j] = false;
            }
        }
    }
}
