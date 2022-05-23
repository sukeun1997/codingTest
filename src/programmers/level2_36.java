package programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 예상 대진표
 */
public class level2_36 {

    public int solution(int n, int a, int b)
    {
        int answer = 0;


        while (a != b) {
            answer++;

            a = getInt(a);
            b = getInt(b);
        }

        return answer;
    }

    private int getInt(int a) {
        if (a % 2 == 0) {
            a = a / 2;
        } else {
            a = a / 2 + (a % 2);
        }
        return a;
    }

    @Test
    void test() {
        Assertions.assertEquals(solution(8,4,7),3);
    }
}
