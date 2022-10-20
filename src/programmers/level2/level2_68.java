package programmers.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 멀리 뛰기
 */
public class level2_68 {

    public long solution(int n) {
        long answer = 0;
        long[] dp = new long[2001];

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % 1234567;
        }
        return dp[n] % 1234567;
    }

    @Test
    void test() {
        Assertions.assertEquals(solution(4), 5);
        Assertions.assertEquals(solution(3), 3);
        Assertions.assertEquals(solution(1), 1);
        Assertions.assertEquals(solution(2), 2);
    }
}
