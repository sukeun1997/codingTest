package programmers.level3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 스티커 모으기(2)
 */
public class level3_31 {

    // 1~100,000
    // 1~100 이하 자연수
    // 1 과 length-1 이 연결됨
    public int solution(int sticker[]) {
        int answer = 0;

        int length = sticker.length;
        int[][] dp = new int[2][length + 1];

        if (length == 1) {
            return sticker[0];
        }

        // 처음 스티커를 고르는 경우
        dp[0][1] = sticker[0];

        for (int i = 1; i < length - 1; i++) {
            dp[0][i + 1] = Math.max(dp[0][i], dp[0][i - 1] + sticker[i]);
        }

        // 마지막 스티커를 포함하는 경우
        dp[1][2] = sticker[1];


        for (int i = 2; i < length; i++) {
            dp[1][i + 1] = Math.max(dp[1][i], dp[1][i - 1] + sticker[i]);
        }

        return Math.max(dp[0][length-1] , dp[1][length]);
    }

    @Test
    void test() {
        Assertions.assertEquals(solution(new int[]{14, 6, 5, 11, 3, 9, 2, 10}), 36);
        Assertions.assertEquals(solution(new int[]{1, 3, 2, 5, 4}), 8);
        Assertions.assertEquals(solution(new int[]{1,2}), 2);
        Assertions.assertEquals(solution(new int[]{1}), 1);

    }
}
