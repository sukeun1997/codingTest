import java.util.Arrays;
import java.util.Scanner;

public class Main_1309 {
    static long Dp[][];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Dp = new long[100001][4];

        Dp[1][0] = 1;
        Dp[1][1] = 1;
        Dp[1][2] = 1;
        System.out.println(Rion(N));
    }

    // 안칠하는 경우 0 , 1번째만 칠하는경우 1, 2번째만 칠하는경우 2
    private static long Rion(int n) {

        for (int i = 2; i <= n; i++) {
            Dp[i][0] = (Dp[i - 1][0] + Dp[i - 1][1] + Dp[i - 1][2]) % 9901;
            Dp[i][1] = (Dp[i - 1][0] + Dp[i - 1][2]) % 9901;
            Dp[i][2] = (Dp[i - 1][0] + Dp[i - 1][2]) % 9901;
        }
        return (Dp[n][0] + Dp[n][1] + Dp[n][2]) % 9901;
    }
}
