package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_11049 {

    private static int[][] matrix;
    private static boolean[] visited;
    private static int ans;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        matrix = new int[n][2];
        visited = new boolean[n];
        ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            matrix[i][0] = Integer.parseInt(s[0]);
            matrix[i][1] = Integer.parseInt(s[1]);
        }

        int[][] dp = new int[n + 1][n + 1];

        for (int k = 1; k < matrix.length; k++) {
            for (int i = 0; i + k < matrix.length; i++) {
                dp[i][i + k] = Integer.MAX_VALUE;
                for (int j = i; j < i + k; j++)
                    dp[i][i + k] = Math.min(dp[i][i + k], dp[i][j] + dp[j + 1][i + k] + matrix[i][0] * matrix[j][1] * matrix[i + k][1]);
            }
        }


    }
}
