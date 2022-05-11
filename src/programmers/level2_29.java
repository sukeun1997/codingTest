package programmers;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 큰 수 만들기
 */
public class level2_29 {

    public String solution(String number, int k) {

        StringBuilder sb = new StringBuilder();

        int idx = 0;
        int max = 0;

        for (int i = 0; i < number.length() -k; i++) {

            max = 0;

            for (int j = idx; j <= k + i; j++) {
                if (max < number.charAt(j) - 48) {
                    max = number.charAt(j) - 48;
                    idx = j + 1;
                }
            }
            sb.append(max);
        }

        return sb.toString();
    }


    @Test
    void test() {
        assertEquals(solution("1924", 2), "94");
        assertEquals(solution("1231234", 3), "3234");
        assertEquals(solution("4177252841", 4), "775841");
    }
}
