package programmers.level3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 단속 카메라
 */
public class level3_6 {

    public int solution(int[][] routes) {

        Arrays.sort(routes,(o1, o2) -> {
            return o1[1] - o2[1];
        });

        int answer = 0;
        int now = 0;

        for (int i = 0; i < routes.length; i++) {
            if (i == 0) {
                now = routes[i][1];
                answer++;
                continue;
            }

            int start = routes[i][0];
            int end = routes[i][1];

            if (now >= start) {
                continue;
            }

            now = end;
            answer++;

        }



        return answer;
    }


    @Test
    void test() {

        assertEquals(solution(new int[][]{{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}}),2);
        assertEquals(solution(new int[][]{{-20,-15},{-20,15}, {-14,-5}, {-18,-13}, {-5,-3}}),2);
        assertEquals(solution(new int[][]{{-20,15},{-14,-5}, {-18,-13}, {-5,-3}}),2);
    }
}
