package programmers.level3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 기지국 설치
 */
public class level3_24 {

    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        int start = 1;

        for (int station : stations) {
            int end = station - w;
            if (end > start) {
                if ((end - start) % (w * 2 + 1) == 0) {
                    answer += (end - start) / (w * 2 + 1);
                } else {
                    answer += (end - start) / (w * 2 + 1) + 1;
                }
            }
            start = station + w + 1;
        }

        if (start <= n) {
            int count = n - start + 1;

            if (count % (w * 2 + 1) == 0) {
                answer += count / (w * 2 + 1);
            } else {
                answer += count / (w * 2 + 1) + 1;
            }
        }
        return answer;
    }

    @Test
    void test() {
        Assertions.assertEquals(solution(11, new int[]{4, 11}, 1), 3);
        Assertions.assertEquals(solution(16, new int[]{9}, 2), 3);
    }

}
