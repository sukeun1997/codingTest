package programmers.level3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class level3_36 {

    public int solution(int alp, int cop, int[][] problems) {
        int answer = 0;

        int maxAlp = 0;
        int maxCop = 0;

        for (int[] problem : problems) {
            maxAlp = Math.max(maxAlp, problem[0]);
            maxCop = Math.max(maxCop, problem[1]);
        }


        int[][] dp = new int[maxAlp + 2][maxCop + 2];

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        dp[alp][cop] = 0;

        for (int i = alp; i <= maxAlp; i++) {
            for (int j = cop; j <= maxCop; j++) {
                dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + 1);
                dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j] + 1);

                for (int[] problem : problems) {
                    int reqA = problem[0];
                    int reqC = problem[1];

                    if (i >= reqA && j >= reqC) {
                        int rewardA = problem[2];
                        int rewardC = problem[3];
                        int cost = problem[4];

                        if (i + rewardA > maxAlp && j + rewardC > maxCop) {
                            dp[maxAlp][maxCop] = Math.min(dp[maxAlp][maxCop], dp[i][j] + cost);
                        } else if (i + rewardA > maxAlp) {
                            dp[maxAlp][j + rewardC] = Math.min(dp[maxAlp][j + rewardC], dp[i][j] + cost);
                        } else if (j + rewardC > maxCop) {
                            dp[i + rewardA][maxCop] = Math.min(dp[i + rewardA][maxCop], dp[i][j] + cost);
                        } else {
                            dp[i + rewardA][j + rewardC] = Math.min(dp[i + rewardA][j + rewardC], dp[i][j] + cost);
                        }
                    }
                }

            }
        }

        return dp[maxAlp][maxCop];
    }


    @Test
    void test() {
        Assertions.assertEquals(solution(10,10,new int[][]{{10,15,2,1,2},{20,20,3,3,4}}),15);
        Assertions.assertEquals(solution(0,0,new int[][]{{0,0,2,1,2},{4,5,3,1,2},{4,11,4,0,2},{10,4,0,4,2}}),13);
    }
}
