import java.util.Scanner;

// DP[N] = DP[N-1] + 2 * DP[N-2]
public class Main_11727 {

    static int dp[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        dp = new int[1001];
        dp[2] = 3;
        dp[3] = 5;
        System.out.println(Tile(N));
    }

    public static int Tile(int n) {
        if (n <= 1) {
            return n;
        }
        if (dp[n] > 0) {
            return dp[n];
        }
        dp[n] = ((Tile(n - 1) % 10007) + (2 * Tile(n - 2) % 10007)) % 10007;
        return dp[n];
    }
}
