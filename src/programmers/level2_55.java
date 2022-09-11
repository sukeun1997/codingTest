package programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * K 진수에서 소수 만들기
 */
public class level2_55 {


    public int solution(int n, int k) {
        int answer = 0;

        String kbinary = convertKbinary(n, k);

        int l = 0, r = 0;

        while (r < kbinary.length()) {
            if (kbinary.charAt(r) - '0' != 0) {
                r++;
                continue;
            }

            long num = Long.parseLong(kbinary.substring(l, r));

            if (isPrime(num)) {
                answer++;
            }

            l = r;
            r++;
        }


        long num = Long.parseLong(kbinary.substring(l, r));

        if (isPrime(num)) {
            answer++;
        }

        return answer;
    }

    private String convertKbinary(int n, int k) {

        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            sb.append(n % k);
            n = n / k;
        }

        return sb.reverse().toString();

    }

    private static boolean isPrime(long num) {
        if (num == 1 || num == 0) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Test
    void test() {
        Assertions.assertEquals(solution(437674,3),3);
        Assertions.assertEquals(solution(110011,10),2);
    }
}
