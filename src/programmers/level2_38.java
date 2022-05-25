package programmers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**\
 * 큰 수 만들기 RE
 */
public class level2_38 {

    public String solution(String number, int k) {

        StringBuilder sb = new StringBuilder();

        int idx = 0;

        int max = 0;

        for (int i = 0; i < number.length() - k ; i++) {


            for (int j = idx; j <= k + i; j++) {
                if (max < number.charAt(j) - '0') {
                    max = number.charAt(j) - '0';
                    idx = j + 1;
                }
            }
            sb.append(max);
            max  = 0;
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
