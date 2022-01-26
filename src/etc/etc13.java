package etc;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 효율적인 화폐 구성 (dp)
 */
public class etc13 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int list[] = new int[n + 1];
        int dp[] = new int[10001];
        Arrays.fill(dp, 10000);

        for (int i = 1; i <= n; i++) {
            list[i] = sc.nextInt();
            dp[list[i]] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = list[i]; j <= m; j++) {
                if(dp[j-list[i]] != 10000)
                    dp[j] = Math.min(dp[j - list[i]] + 1, dp[j]);
            }
        }
        System.out.println(dp[m] == 10000 ?  -1 : dp[m]);


    }

}
