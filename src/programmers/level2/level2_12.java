package programmers.level2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class level2_12 {


    static int number;
    static boolean visit[];

    public int solution(String numbers) {

        String[] split = numbers.split("");
        int count[] = new int[10];
        for (String s : split) {
            count[Integer.valueOf(s)]++;
        }

        number = 0;
        visit = new boolean[(int) Math.pow(10, split.length)];
        dfs(count, "");


        return number;
    }

    private void dfs(int[] count, String s) {

        if (!s.isEmpty()) {
            int a = Integer.parseInt(s);
            if (prime(a) && !visit[a]) {
                number++;
                visit[a] = true;
            }
        }
        for (int i = 0; i < 10; i++) {
            if (count[i] != 0) {
                count[i]--;
                dfs(count, s + String.valueOf(i));
                count[i]++;
            }
        }
    }

    boolean prime(int n) {
        if (n < 2) {
            return false;
        }

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        assertEquals(solution("17"), 3);
        assertEquals(solution("011"), 2);
    }
}
