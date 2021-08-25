import java.util.Scanner;

public class Main_1010 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int i = 1; i <= T; i++) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            int DP[][] = new int[M + 1][M + 1];
            for (int x = 1; x <= M; x++) {
                DP[x][0] = 1;
                DP[x][x] = 1;
            }
            for (int l = 2; l <= M; l++) {
                for (int m = 1; m < M; m++) {
                    DP[l][m] =  DP[l-1][m-1] + DP[l-1][m];
                }
            }
            System.out.println(DP[M][N]);
        }
    }
}
