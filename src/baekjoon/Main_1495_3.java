package baekjoon;

import java.util.Scanner;

/**
 * 기타리스트 RE
 */
public class Main_1495_3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int s = sc.nextInt();
        int m = sc.nextInt();

        int list[] = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = sc.nextInt();
        }

        boolean dp[][] = new boolean[n + 1][10001];

        dp[0][s] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (dp[i - 1][j]) {
                    if (j - list[i] >= 0) {
                        dp[i][j - list[i]] = true;
                    }

                    if (j + list[i] <= m) {
                        dp[i][j + list[i]] = true;
                    }
                }
            }
        }


        for (int i = m; i >= 0; i--) {
            if (dp[n][i]) {
                System.out.println(i);
                return;
            }
        }

        System.out.println(-1);
    }
}
