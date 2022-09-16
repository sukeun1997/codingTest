package baekjoon;

import java.util.Scanner;

public class Main_2193_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();


        int[][] dp = new int[n + 1][2];

        dp[1][1] = 1;
        dp[2][0] = 1;

        if (n <= 2) {
            System.out.println(dp[n][0] + dp[n][1]);
        }


        for (int i = 3; i <= n; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
            dp[i][1] = dp[i - 1][0];
        }

        System.out.println(dp[n][0] + dp[n][1]);
    }
}
