package programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 순위 RE
 */
public class level3_13 {

    public int solution(int n, int[][] results) {
        int answer = 0;

        int[][] game = new int[n][n];
        for (int i = 0; i < results.length; i++) {
            int n1 = results[i][0] - 1;
            int n2 = results[i][1] - 1;

            game[n1][n2] = 1;
            game[n2][n1] = -1;
        }


        for (int i = 0; i < n; i++) { // 1~5
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (game[j][i] == 1 && game[i][k] == 1) {
                        game[j][k] = 1;
                    } else  if (game[j][i] == -1 && game[i][k] == -1) {
                        game[j][k] = -1;
                    }
                }
            }
        }

        for (int[] ints : game) {

            long count = Arrays.stream(ints).filter(value -> value == 0).count();
            if (count == 1) {
                answer++;
            }
        }
        return answer;
    }

    @Test
    void test() {
        assertEquals(solution(5,new int[][]{{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}}),2);
    }
}
