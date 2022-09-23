package programmers.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 타겟 넘버
 */
public class level2_53 {

    /**
     * 숫자 2~20 개 이하
     * 각 숫자 1~50
     * 타겟 넘버 1~1000
     */
    private int ans = 0;

    public int solution(int[] numbers, int target) {

        char[] chars = new char[numbers.length];
        dfs(0, chars, numbers, target);
        return ans;
    }

    private void dfs(int i, char[] chars, int[] numbers, int target) {

        if (i == numbers.length) {

            if (target == calc(chars, numbers)) {
                ans++;
            }
            return;
        }

        chars[i] = '+';
        dfs(i + 1, chars, numbers, target);
        chars[i] = '-';
        dfs(i + 1, chars, numbers, target);

    }

    private int calc(char[] chars, int[] numbers) {

        int sum = 0;

        for (int j = 0; j < chars.length; j++) {

            if (chars[j] == '+') {
                sum += numbers[j];
            } else {
                sum -= numbers[j];
            }

        }

        return sum;
    }

    @Test
    void test() {
        Assertions.assertEquals(solution(new int[]{1,1,1,1,1},3),5);
        Assertions.assertEquals(solution(new int[]{4, 1, 2, 1},4),2);
    }
}
