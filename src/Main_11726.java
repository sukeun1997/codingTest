import java.util.Scanner;

// DP[N] = DP[N-1] + DP[N-2]
public class Main_11726 {

    static int dp[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        dp = new int[N + 1];
        System.out.println(Tile(N));
    }

    public static int Tile(int n) {
        if (n <= 3) {
            return n;
        }
        if (dp[n] > 0) {
            return dp[n];
        }
        dp[n] = ((Tile(n - 1) % 10007) + (Tile(n - 2) % 10007)) % 10007;
        return dp[n];
    }
}
