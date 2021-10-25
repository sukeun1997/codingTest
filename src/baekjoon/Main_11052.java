package baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class Main_11052 {

    static int A[];
    static int DP[];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        DP = new int[N + 1];
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = sc.nextInt();
        }

        System.out.println(MaxPrice(N));
    }

    static int MaxPrice(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                DP[i] = Math.max(DP[i], DP[i - j] + A[j]);
            }
        }
        return DP[n];
    }
}
