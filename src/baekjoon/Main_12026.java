package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_12026 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        char[] chars = br.readLine().toCharArray();
        char[] array = new char[]{'B', 'O', 'J'};
        int dp[] = new int[n + 1];

        Arrays.fill(dp, 2100000000);

        dp[0] = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (chars[i] == 'B') {
                    if (chars[j] == array[1]) {
                        dp[j] = Math.min(dp[j], dp[i] + (int) Math.pow(j - i, 2));
                    }
                } else if (chars[i] == 'O') {
                    if (chars[j] == array[2]) {
                        dp[j] = Math.min(dp[j], dp[i] + (int) Math.pow(j - i, 2));
                    }
                } else {
                    if (chars[j] == array[0]) {
                        dp[j] = Math.min(dp[j], dp[i] + (int) Math.pow(j - i, 2));
                    }
                }
            }
        }


        System.out.println(dp[n - 1] < 2100000000 ? dp[n - 1] : -1);

    }
}
