import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main_11055 {

    static int dp[];
    static int list[];
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        dp = new int[1001];
        list = new int[1001];
        for (int i = 1; i <= n; i++) {
            list[i] = sc.nextInt();
        }
        dp[1] = list[1];
        System.out.println(SumSeq(n));
    }

    private static int SumSeq(int n) {

        for (int i = 2; i <= n; i++) {
            for (int j = i; j >= 1; j--) {
                if (list[i] > list[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + list[i]);
                }
            }
            if (dp[i] == 0) {
                dp[i] = list[i];
            }
        }

        return Arrays.stream(dp).max().getAsInt();
    }
}
