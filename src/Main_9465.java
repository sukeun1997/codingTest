import java.util.Scanner;

public class Main_9465 {

    static int DP[][];
    static int list[][];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {

            DP = new int[100001][3];
            list = new int[3][100001];

            int N = sc.nextInt();

            for (int l = 1; l <= 2; l++) {
                for (int j = 1; j <= N; j++) {
                    list[l][j] = sc.nextInt();
                }
            }
            DP[1][0] = 0;
            DP[1][1] = list[1][1];
            DP[1][2] = list[2][1];
            System.out.println(SumMax(N));
        }
    }

    private static int SumMax(int n) {

        for (int i = 2; i <= n ; i++) {
            DP[i][0] = Math.max(Math.max(DP[i - 1][0], DP[i - 1][1]), DP[i-1][2]);
            DP[i][1] = Math.max(DP[i - 1][2], DP[i - 1][0]) + list[1][i];
            DP[i][2] = Math.max(DP[i - 1][1], DP[i - 1][0]) + list[2][i];
        }
        return Math.max(Math.max(DP[n][0], DP[n][1]), DP[n][2]);
    }
}
