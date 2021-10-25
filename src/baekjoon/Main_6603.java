package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main_6603 {

    static int[] list;
    static int[] result;
    static int N;
    static boolean[] visit;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while ((N = sc.nextInt()) != 0) {
            list = new int[N];
            visit = new boolean[N];
            result = new int[6];
            for (int i = 0; i < N; i++) {
                list[i] = sc.nextInt();
            }
            go(0);
            System.out.println();
        }
    }

    private static void go(int i) {
        if (i == 6) {
            Arrays.stream(result).forEach(n -> System.out.print(n+" "));
            System.out.println();
            return;
        }

        for (int j = 0; j < N; j++) {
            if (!visit[j]) {
                if (i > 0 && list[j] < result[i-1]) {
                    continue;
                }
                visit[j] = true;
                result[i] = list[j];
                go(i+1);
                visit[j] = false;
            }

        }
    }
}
