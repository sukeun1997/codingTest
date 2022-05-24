package programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 땅따먹기
 */
public class level2_37 {

    int solution(int[][] land) {

        for (int i = 1; i < land.length; i++) {
            land[i][0] += Math.max(Math.max(land[i - 1][1], land[i - 1][2]), land[i - 1][3]);
            land[i][1] += Math.max(Math.max(land[i - 1][2], land[i - 1][3]), land[i - 1][0]);
            land[i][2] += Math.max(Math.max(land[i - 1][3], land[i - 1][0]), land[i - 1][1]);
            land[i][3] += Math.max(Math.max(land[i - 1][0], land[i - 1][1]), land[i - 1][2]);
        }
        int answer = 0;
        for (int i : land[land.length-1]) {
            answer = Math.max(i, answer);
        }
        return answer;
    }

    @Test
    void test() {
        Assertions.assertEquals(solution(new int[][]{{1,2,3,5},{5,6,7,8},{4,3,2,1}}), 16);
    }
}
