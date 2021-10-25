package baekjoon;

import java.util.Scanner;

public class Main_2225 {

    static long DP[][];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        DP = new long[201][201];

        for (int i = 0; i <= N ; i++) {
            DP[1][i] = 1;
        }

        System.out.println(Plus(K,N));
    }


    // DP[K][N] = DP[K-1][N-L]
    // 0 <= L <= N
    static long Plus(int k, int n) {

        if (DP[k][n] != 0) {
            return DP[k][n];
        }
        for (int i = 0; i <= n ; i++) {
            DP[k][n] += Plus(k-1,n-i) % 1000000000;
        }

        return DP[k][n] % 1000000000;
    }
}
