package programmers.level3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * N으로 표현
 */
public class level3_4 {

    static int n;
    static int min = Integer.MAX_VALUE;

    public int solution(int N, int number) {
        int answer = 0;

        n = N;

        dfs(0, 0,number);

        return (min == Integer.MAX_VALUE) ? -1 : min;
    }

    private void dfs(int idx, int now, int number) {

        if (idx > 8) {
            return;
        }
        if (number == now) {
            min = Math.min(idx, min);
            return;
        }

        int temp = 0;

        for (int i = 0; i < 8; i++) {
            if (idx + i < 8) {
                temp = (temp * 10) + n;
                dfs(idx + i + 1, now + temp, number);
                dfs(idx + i + 1, now - temp, number);
                dfs(idx + i + 1, now / temp, number);
                dfs(idx + i + 1, now * temp, number);
            }
        }
    }

    @Test
    void test() {
        Assertions.assertEquals(solution(5, 12), 4);
        Assertions.assertEquals(solution(2, 11), 3);
    }
}
