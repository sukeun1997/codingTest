package programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 내적
 */
public class level1_9 {

    public int solution(int[] a, int[] b) {
        int answer = 0;

        for (int i = 0; i < a.length; i++) {
            answer += a[i] * b[i];
        }
        return answer;
    }

    @Test
    void test() {
        assertEquals(solution(new int[]{1,2,3,4},new int[]{-3,-1,0,2}),3);
        assertEquals(solution(new int[]{-1,0,1},new int[]{1,0,-1}),-2);
    }
}
