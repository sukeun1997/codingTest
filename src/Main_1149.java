import java.util.Scanner;

public class Main_1149 {

    static int DP[][];
    static int RGB[][];
    static final int R = 1, G = 2, B = 3;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        DP = new int[1001][4];
        RGB = new int[1001][4];

        for (int i = 1; i <= N ; i++) {
            for (int j = 1; j <= 3; j++) {
                RGB[i][j] = sc.nextInt();
            }
        }
        DP[1][R] = RGB[1][R];
        DP[1][G] = RGB[1][G];
        DP[1][B] = RGB[1][B];
        System.out.println(Color(N));
    }

    private static int Color(int n) {
        int min;

        for (int i = 2; i <= n ; i++) {
            DP[i][R] = Math.min(DP[i-1][G], DP[i - 1][B]) + RGB[i][R];
            DP[i][G] = Math.min(DP[i-1][R], DP[i - 1][B]) + RGB[i][G];
            DP[i][B] = Math.min(DP[i-1][R], DP[i - 1][G]) + RGB[i][B];
        }
        min = Math.min(DP[n][R], Math.min(DP[n][G], DP[n][B]));


        return min;
    }
}
