
import java.util.Arrays;
import java.util.Scanner;

public class Main_11722 {

    static int dp[];
    static int list[];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        dp = new int[10001];
        list = new int[10001];

        for (int i = 1; i <= N; i++) {
            list[i] = sc.nextInt();
        }

        dp[N] = 1;
        System.out.println(DecreaseSeq(N));
    }
    // dp[n] = n 번째 에서 최대 많은 감소 수열의 길이
    // n = n~1
    private static int DecreaseSeq(int n) {

        for (int i = n-1; i >= 1 ; i--) {
            for (int j = n; j >= i+1; j--) {
                if (list[i] > list[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (dp[i] == 0) {
                dp[i] = 1;
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}
