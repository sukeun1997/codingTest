package programmers.level3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * 순위
 */
public class level3_12 {



    public int solution(int n, int[][] results) {
        int answer = 0;
        boolean result[][] = new boolean[n][n];

        for (int[] ints : results) {
            int a = ints[0] - 1;
            int b = ints[1] - 1;
            result[a][b] = true;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (result[j][i] == true && result[i][k] == true) {

                        result[j][k] = true;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if (result[i][j] || result[j][i]) {
                    sum++;
                }
            }

            if (sum == n - 1) {
                answer++;
            }
        }
        return answer;
    }

    @Test
    void test() {
        Assertions.assertEquals(solution(5, new int[][]{{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}}), 2);
    }
}
