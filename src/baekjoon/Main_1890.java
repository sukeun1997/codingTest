package baekjoon;

import java.util.Scanner;

public class Main_1890 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int map[][] = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }


        long dp[][] = new long[n][n];


        dp[0][0] =1;

        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n; j++) {
                if (i == n - 1 && j == n - 1) {
                    continue;
                }
                int next = map[i][j];

                    if (next + i < n) {
                            dp[next + i][j] += dp[i][j];
                    }

                    if (next + j < n) {
                            dp[i][next + j] += dp[i][j];
                    }

            }
        }

        System.out.println(dp[n-1][n-1]);
    }


}
