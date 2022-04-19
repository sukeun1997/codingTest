package programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class level3_7 {
    public int solution(int[][] triangle) {
        int length = triangle.length;
        int dp[][] = new int[length][length];

        // top down

        for (int i = 0; i < length ; i++) {
            dp[length - 1][i] = triangle[length - 1][i];
        }
        for (int i = length-2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = triangle[i][j] + Math.max(dp[i + 1][j], dp[i + 1][j + 1]);
            }
        }


        return dp[0][0];
    }


    @Test
    void test() {
        assertEquals(solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}), 30);
    }

}
