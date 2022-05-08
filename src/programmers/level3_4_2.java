package programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * N으로 표현 2
 */
public class level3_4_2 {

    int min = Integer.MAX_VALUE;
    int n;

    public int solution(int N, int number) {
        n = N;

        dfs(0, 0, number);
        return (min == Integer.MAX_VALUE) ? -1 : min;
    }

    private void dfs(int depth, int now, int number) {
        if (depth > 8) {
            return;
        }
        if (now == number) {
            min = Math.min(min, depth);
            return;
        }


        int temp = 0;
        for (int i = 0; i < 8; i++) {
            if (depth + i < 8) {
                temp = (temp * 10) + n;
                dfs(depth + i + 1, now * temp, number);
                dfs(depth + i + 1, now / temp, number);
                dfs(depth + i + 1, now + temp, number);
                dfs(depth + i + 1, now - temp, number);
            }
        }


    }

    @Test
    void test() {
        Assertions.assertEquals(solution(5, 12), 4);
        Assertions.assertEquals(solution(2, 11), 3);
    }
}
