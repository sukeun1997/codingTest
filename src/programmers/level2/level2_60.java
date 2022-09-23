package programmers.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * N진수 게임
 */
public class level2_60 {

    // m = 인원
    // p = 순서
    // t = 갯수
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        StringBuilder ans = new StringBuilder();

        int number = 0;

        while (sb.length() < m * t) {
            sb.append(Integer.toString(number++, n));
        }

        for (int i = p - 1; i < m * t; i += m) {
            ans.append(sb.toString().charAt(i));
        }

        return ans.toString().toUpperCase();
    }

    @Test
    void test() {
//        Assertions.assertEquals(solution(2, 4, 2, 1), "0111");
        Assertions.assertEquals(solution(16, 16, 2, 1), "02468ACE11111111");
        Assertions.assertEquals(solution(16, 16, 2, 2), "13579BDF01234567");
    }
}
