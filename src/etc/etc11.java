package etc;

import java.util.Scanner;

/**
 * 개미 전사
 */
public class etc11 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int list[] = new int[n + 1];

        for (int i = 1; i <= n ; i++) {
            list[i] = sc.nextInt();
        }

        int dp[] = new int[n + 1];

        dp[1] = list[1];
        dp[2] = list[2];

        for (int i = 3; i <= n ; i++) {
            dp[n] = Math.max(list[n] + dp[n - 2], dp[n - 1]);
        }

        System.out.println(dp[n]);
    }
}
