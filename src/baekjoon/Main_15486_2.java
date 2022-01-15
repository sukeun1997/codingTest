package baekjoon;

import java.util.Scanner;

public class Main_15486_2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int i = sc.nextInt();

        int list[][] = new int[i+2][2];
        for (int j = 1; j <= i; j++) {
            list[j][0] = sc.nextInt();
            list[j][1] = sc.nextInt();
        }

        int dp[] = new int[i + 2];

        int finish = 0;
        for (int j = 1; j <= i+1 ; j++) {

            if (dp[j] > finish) {
                finish = dp[j];
            }

            int next = list[j][0];
            int work = list[j][1];

            if (j + next <= i+1) {
                dp[j + next] = Math.max(dp[j+next], finish + work);
            }
        }

        System.out.println(dp[i+1]);
    }
}
