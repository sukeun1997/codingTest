package programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class level3_8 {

    public int solution(int m, int n, int[][] puddles) {

        final int Mod = 1000000007;

        int dp[][] = new int[n][m];
        int answer = 0;

        dp[0][0] = 1;

        for (int k = 0; k < puddles.length; k++) {
            dp[puddles[k][1]-1][puddles[k][0]-1] = -1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dp[i][j] == -1) {
                    dp[i][j] = 0;
                    continue;
                }
                if (i != 0) {
                    dp[i][j] = dp[i][j] + dp[i - 1][j] % Mod;
                }

                if (j != 0) {
                    dp[i][j] = dp[i][j] + dp[i][j - 1] % Mod;
                }
            }
        }


        return dp[n - 1][m - 1] % Mod;
    }


    @Test
    void test() {
        assertEquals(4, solution(4, 3, new int[][]{{2,2}}));
        assertEquals(7, solution(4, 4, new int[][]{{3,2}, {2,4}}));
        assertEquals(7, solution(5, 3, new int[][]{{4,2}}));
        assertEquals(0, solution(2, 2, new int[][]{{2,1}, {1, 2}}));
        assertEquals(0, solution(3, 1, new int[][]{{2,1}}));
    }
}
