package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main_13398 {

    static int dp[][];
    static int list[];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        dp = new int[100002][2];
        list = new int[100002];

        for (int i = 1; i <= n; i++) {
            list[i] = sc.nextInt();
        }
        dp[1][0] = dp[1][1] = list[1];
        System.out.println(SeqNum(n));

    }

    // dp[n] = n 번째 에서의 최대 연속 합
    // dp[n][0] = 기존 연속 합
    // dp[n][1] = 하나의 수를 뺀 연속 합
    private static int SeqNum(int n) {

        if (n == 1) {
            return dp[1][1];
        }
        int maxdp = Integer.MIN_VALUE;
        for (int i = 2; i <= n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0] + list[i], list[i]);
            dp[i][1] = Math.max(dp[i - 1][1] + list[i], dp[i-1][0]);
            maxdp = Math.max(maxdp, Math.max(dp[i][0], dp[i][1]));
        }
        return maxdp;
    }
}
