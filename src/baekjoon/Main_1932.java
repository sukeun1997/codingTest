package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main_1932 {

    static int dp[][];
    static int list[][];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        dp = new int[502][502];
        list = new int[502][502];
        for (int i = 1; i <= N ; i++) {
            for (int j = 1; j <= i ; j++) {
                list[i][j] = sc.nextInt();
            }
        }
        System.out.println(Tringle(N));

    }

    // 위에서 부터 최대 합 = 아래서 부터 맨 위까지 최대합
    // i = n~1 , j = 1~i
    //DP[i][j] = list[i][j] + math.max(dp[i+1][j], dp[i+1][j+1])
    private static int Tringle(int n) {

        for (int i = n; i >= 1 ; i--) {
            for (int j = 1; j <= n ; j++) {
                    dp[i][j] = list[i][j]+ Math.max(dp[i+1][j],dp[i+1][j+1]);
            }
        }
        return Arrays.stream(dp[1]).max().getAsInt();
    }

}
