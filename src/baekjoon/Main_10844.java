package baekjoon;

import java.util.Scanner;

public class Main_10844 {

    static long DP[][];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        DP = new long[N + 1][10];

        for (int i = 1; i < 10; i++) {
            DP[1][i] = 1;
        }
        System.out.println(Stair(N));
    }

    //DP[N][i] = DP[N-1][i-1] + DP[N-1][i+1]
    // 0 일떄는 +1 만 9 일때는 -1 만
    static long Stair(int n) {
        long count = 0;

        if (n >= 2) {
            for (int l = 2; l <= n; l++) {
                for (int i = 0; i < 10; i++) {
                    if (i == 0) {
                        DP[l][i] = DP[l - 1][i + 1];
                    } else if (i == 9) {
                        DP[l][i] = DP[l - 1][i - 1];
                    } else {
                        DP[l][i] = DP[l - 1][i - 1] + DP[l - 1][i + 1];
                    }
                        DP[l][i] %= 1000000000;
                }
            }
        }
        for (int i = 0; i < 10; i++) {
            count += DP[n][i];
        }
        return count % 1000000000;
    }
}
