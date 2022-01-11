package baekjoon;

import java.util.Scanner;

public class Main_11058 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long dp[] = new long[101];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        if (n <= 3) {
            System.out.println(dp[n]);
            return;
        }

        for (int i = 4; i <= n ; i++) {
            dp[i] = dp[i - 1] + 1;

            if (i > 6) {
                for (int j = 2; j < 5; j++) {
                    dp[i] = Math.max(dp[i], j * dp[i - (j + 1)]);
                }
            }
        }

        System.out.println(dp[n]);
    }
}
