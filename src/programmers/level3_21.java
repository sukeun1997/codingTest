package programmers;

import java.util.Arrays;

/**
 * 코딩 테스트 공부
 */
public class level3_21 {

    /**
     * 알고력 1 = 1시간
     * 코딩력 1 = 1시간
     * <p>
     * 문제당 올라가는 알고력 , 코딩력이 있다
     * 문제를 푸는데 문제가 요구하는 시간이 소요 , 여러번 푸는것도 가능
     * <p>
     * <p>
     * => 주어진 모든 문제들을 풀 수 있는 알고력과 코딩력을 얻는 최단 시간
     * <p>
     * alp , cop  = 0~150
     * problems = 1~100
     */
    public int solution(int alp, int cop, int[][] problems) {
        int answer = 0;

        int max_alp = 0;
        int max_cop = 0;

        for (int[] problem : problems) {
            max_alp = Math.max(max_alp, problem[0]);
            max_cop = Math.max(max_cop, problem[1]);
        }


        if (max_alp <= alp && max_cop <= cop) {
            return 0;
        }

        if (alp >= max_alp) {
            alp = max_alp;
        }
        if (cop >= max_cop) {
            cop = max_cop;
        }


        int[][] dp = new int[max_alp + 2][max_cop + 2];

        for (int i = 0; i <= max_alp; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        dp[alp][cop] = 0;

        for (int i = alp; i <= max_alp; i++) {
            for (int j = cop; j <= max_cop; j++) {
                dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + 1);
                dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j] + 1);

                for (int[] problem : problems) {
                    int reqA = problem[0];
                    int reqC = problem[1];
                    if (i >= reqA && j >= reqC) {
                        int rewardA = problem[2];
                        int rewardC = problem[3];
                        int cost = problem[4];

                        if (i + rewardA > max_alp && j + rewardC > max_cop) {
                            dp[max_alp][max_cop] = Math.min(dp[max_alp][max_cop], dp[i][j] + cost);
                        } else if (i + rewardA > max_alp) {
                            dp[max_alp][j + rewardC] = Math.min(dp[max_alp][j + rewardC], dp[i][j] + cost);
                        } else if (j + rewardC > max_cop) {
                            dp[i + rewardA][max_cop] = Math.min(dp[i + rewardA][max_cop], dp[i][j] + cost);
                        } else {
                            dp[i + rewardA][j + rewardC] = Math.min(dp[i + rewardA][j + rewardC], dp[i][j] + cost);
                        }
                    }
                }
            }
        }


        return dp[max_alp][max_cop];
    }
}
