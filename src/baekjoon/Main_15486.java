package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_15486 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] calender = new int[n+2][2];
        int dp[] = new int[n+2];

        for (int i = 1; i <= n; i++) {
            calender[i][0] = sc.nextInt();
            calender[i][1] = sc.nextInt();
        }

        int max = 0;
        for (int i = 1; i <= n+1 ; i++) {

            int t = calender[i][0];

            max = Math.max(max, dp[i]);

            if (i + t <= n+1) {
                dp[i + t] = Math.max(dp[i + t], max + calender[i][1]);
            }
        }

        System.out.println(dp[n+1]);
    }
}
