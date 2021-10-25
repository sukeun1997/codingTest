package baekjoon;

import java.util.Scanner;

public class Main_11057 {

    public static final int MOD = 10007;
    static long DP[][];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        DP = new long[100008][10];
        for (int i = 0; i <= 9 ; i++) {
            DP[1][i] = 1;
        }
        System.out.println(Stair(N) % MOD);
    }

    /*0 <= I <= 9
    DP[N][I] = DP[N-1][0~I]*/
    private static long Stair(int n) {

        long sum = 0;
        for (int i = 2; i <= n ; i++) {
            for (int j = 0; j <= 9 ; j++) {
                for (int k = 0; k <= j ; k++) {
                    DP[i][j] += DP[i - 1][k];
                    DP[i][j] %= MOD;
                }
            }
        }

        for (int i = 0; i <= 9 ; i++) {
            sum += DP[n][i];
        }

        return sum;
    }
}
