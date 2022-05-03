package programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 도둑질
 */
public class level4_1 {

    public int solution(int[] money) {

        int length = money.length;
        int dp[] = new int[length +1];
        dp[0] = money[0];
        dp[1] = Math.max(dp[0], money[1]);

        int answer = 0;
        for (int i = 2; i < length; i++) {
            if (i == length - 1) {
                dp[i] = Math.max(dp[i - 2], dp[i - 1]);
                break;
            }
            dp[i] = Math.max(dp[i - 2] + money[i], dp[i - 1]);
        }

        answer = dp[length - 1];

        dp[0] = 0;
        dp[1] = money[1];
        for (int i = 2; i <length ; i++) {
            dp[i] = Math.max(dp[i - 2] + money[i], dp[i - 1]);
        }

        answer = Math.max(answer, dp[length - 1]);
        return answer;
    }

    @Test
    public void test() {
        assertEquals(solution(new int[]{1, 2, 3, 1}),4);
        assertEquals(solution(new int[]{1, 2, 3, 1}), 4);
        assertEquals(solution(new int[]{1, 1, 4, 1, 4}), 8);
        assertEquals(solution(new int[]{1000, 0, 0, 1000, 0, 0, 1000, 0, 0, 1000}), 3000);
        assertEquals(solution(new int[]{1000, 1, 0, 1, 2, 1000, 0}), 2001);
        assertEquals(solution(new int[]{1000, 0, 0, 0, 0, 1000, 0, 0, 0, 0, 0, 1000}), 2000);
        assertEquals(solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}), 30);
        assertEquals(solution(new int[]{0, 0, 0, 0, 100, 0, 0, 100, 0, 0, 1, 1}), 201);
        assertEquals(solution(new int[]{11, 0, 2, 5, 100, 100, 85, 1}), 198);
        assertEquals(solution(new int[]{1, 2, 3}), 3);
        assertEquals(solution(new int[]{91, 90, 5, 7, 5, 7}), 104);
        assertEquals(solution(new int[]{90, 0, 0, 95, 1, 1}), 185);
    }

}
