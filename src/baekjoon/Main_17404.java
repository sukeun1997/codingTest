package baekjoon;

import java.util.Scanner;

public class Main_17404 {

    static int DP[][];
    static int list[][];
    static final int R=1,G=2,B=3;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        DP = new int[10002][10002];
        list = new int[10002][4];

        int N = sc.nextInt();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <=3 ; j++) {
                list[i][j] = sc.nextInt();
            }
        }

      /*  DP[1][G] = list[1][2];
        DP[1][RB] = DP[1][GB] = list[1][3];
        DP[1][GR] = DP[1][BR] = list[1][1];
*/
        DP[1][R] = list[1][1];
        DP[1][G] = list[1][2];
        DP[1][B] = list[1][3];

        System.out.println(RGB(N));
    }

    private static int RGB(int n) {

        for (int i = 2; i <= n ; i++) {
            DP[i][R] = Math.min(DP[i - 1][G], DP[i - 1][B]) + list[i][R];
            DP[i][G] = Math.min(DP[i - 1][R], DP[i - 1][B]) + list[i][G];
            DP[i][B] = Math.min(DP[i - 1][R], DP[i - 1][G]) + list[i][B];
        }
        return 0;
    }
}
