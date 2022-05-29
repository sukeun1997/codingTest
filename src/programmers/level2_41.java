package programmers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 큰 수 만들기 RE2
 */
public class level2_41 {

    public String solution(String number, int k) {
        String answer = "";

        int idx = 0;
        for (int i = 0; i < number.length()-k; i++) {
            int max = 0;
            for (int j = idx; j <= k+i; j++) {
                if (number.charAt(j) - '0' > max) {
                    max = number.charAt(j) - '0';
                    idx = j + 1;
                }
            }

            answer += max;
        }
        return answer;
    }


    @Test
    void test() {
        assertEquals(solution("1924", 2), "94");
        assertEquals(solution("1231234", 3), "3234");
        assertEquals(solution("4177252841", 4), "775841");
    }
}
