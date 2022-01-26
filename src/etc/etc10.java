package etc;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 1로 만들기
 */
public class etc10 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int i = sc.nextInt();

        int dp[] = new int[i + 1];

        Arrays.fill(dp, 10000);
        dp[26] = 0;

        for (int j = i - 1; j >= 1; j--) {
            dp[j] = Math.min(dp[j + 1] + 1, dp[j]);
            if (j % 5 == 0) {
                dp[j / 5] = Math.min(dp[j / 5], dp[j] + 1);
            }
            if (j % 3 == 0) {
                dp[j / 3] = Math.min(dp[j / 3], dp[j] + 1);
            }
            if (j % 2 == 0) {
                dp[j / 2] = Math.min(dp[j / 2], dp[j] + 1);
            }
        }

        System.out.println(dp[1]);


    }
}
