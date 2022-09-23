package programmers.level2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class level2_9 {

    public String solution(int n) {

        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            int a = n % 3;
            n = n / 3;

            if (a == 0) {
                a = 4;
                n -= 1;
            }
            sb.insert(0, a);
        }

        return sb.toString();
    }

   @Test
    public void test() {
       assertEquals(solution(1), 1);
       assertEquals(solution(2), 2);
       assertEquals(solution(3), 4);
       assertEquals(solution(4), 11);
       assertEquals(solution(5), 12);
       assertEquals(solution(6), 14);
       assertEquals(solution(7), 21);
       assertEquals(solution(8), 22);
       assertEquals(solution(9), 24);
       assertEquals(solution(10), 41);
   }
}
