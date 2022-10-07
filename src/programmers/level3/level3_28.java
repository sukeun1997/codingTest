package programmers.level3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class level3_28 {

    /**
     * 합승 택시 요금
     */

    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;

        int[][] distance = new int[n + 1][n + 1];


        for (int i = 1; i <= n; i++) {
            Arrays.fill(distance[i], 10000000);
            distance[i][i] = 0;
        }

        for (int i = 0; i < fares.length; i++) {
            int start = fares[i][0];
            int to = fares[i][1];
            int cost = fares[i][2];
            distance[start][to] = Math.min(distance[start][to], cost);
            distance[to][start] = Math.min(distance[to][start], cost);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    distance[j][k] = Math.min(distance[j][k], distance[j][i] + distance[i][k]);
                }
            }
        }


        for (int i = 1; i <= n; i++) {
            answer = Math.min(answer, distance[s][i] + distance[i][a] + distance[i][b]);
        }

        return answer;
    }

    @Test
    void test() {

        Assertions.assertEquals(solution(6, 4, 6, 2, new int[][]{{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}}), 82);
    }
}
