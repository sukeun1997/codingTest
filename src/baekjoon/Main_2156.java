package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main_2156 {

    static int dp[];
    static int list[];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        list = new int[10001];
        dp = new int[10001];
        for (int i = 1; i <= T ; i++) {
            list[i] = sc.nextInt();
        }

        dp[1] = list[1];
        dp[2] = list[2] + list[1];
        System.out.println(Grape(T));
    }

    private static int Grape(int n) {

        for (int i = 3; i <= n ; i++) {
            dp[i] = Math.max(Math.max(dp[i - 1], dp[i - 3] + list[i] + list[i - 1]), dp[i-2]+list[i]);
        }
        return dp[n];

    }
}
