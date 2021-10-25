package baekjoon;

import java.util.Scanner;

public class Main_2193 {

    static long DP[][];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        DP = new long[91][2];
        DP[1][1] = 1;
        DP[2][0] = 1;
        System.out.println(pinary(N));
    }

    public static long pinary(int n) {
        /*
        DP[N][1] = DP[N-1][0]
        DP[N][0] = DP[N-1][1] + DP[N-1][0]
        90 개가 int 범위를 넘어가므로 long 써야함
        */
        if(n >= 3) {
            for (int i = 3; i <= n; i++) {
                DP[i][0] = DP[i - 1][0] + DP[i - 1][1];
                DP[i][1] = DP[i - 1][0];
            }
        }

        return DP[n][0] + DP[n][1];
    }
}
