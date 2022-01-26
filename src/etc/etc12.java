package etc;

import java.util.Scanner;

/**
 * 바닥 공사 (dp)
 */
public class etc12 {

    public static final int DIVIDE = 796796;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        long dp[] = new long[n + 1];

        dp[1] = 1;
        dp[2] = 3;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 2] * 2 + dp[i - 1]) % DIVIDE;
        }

        System.out.println(dp[n] % DIVIDE);
    }
}
