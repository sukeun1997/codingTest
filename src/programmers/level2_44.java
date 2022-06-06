package programmers;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class level2_44 {

    char[] chars;
    List<Long> nums;
    List<Character> ops;
    boolean[] visited;
    long answer ;

    public long solution(String expression) {

        chars = new char[]{'*', '+', '-'};
        nums = new ArrayList<>();
        ops = new ArrayList<>();

        String num = "";
        for (char c : expression.toCharArray()) {
            if (c >= '0' && c <= '9') {
                num += c;
            } else {
                nums.add(Long.valueOf(num));
                ops.add(c);
                num = "";
            }
        }
        visited = new boolean[3];
        nums.add(Long.valueOf(num));

        dfs(0, new char[3]);
        return answer;
    }

    private void dfs(int idx, char[] charArray) {

        if (idx == 3) {
            ArrayList<Long> cNums = new ArrayList<>(nums);
            ArrayList<Character> cOps = new ArrayList<>(ops);

            for (int i = 0; i < charArray.length; i++) {
                for (int j = 0; j < cOps.size(); j++) {
                    if (charArray[i] == cOps.get(j)) {
                        long result = calc(cNums.remove(j), cNums.remove(j), cOps.remove(j));
                        cNums.add(j, result);
                        j--;
                    }
                }
            }
            answer = Math.max(answer, Math.abs(cNums.get(0)));

            return;
        }

        for (int i = 0; i < 3; i++) {
            if (!visited[i]) {
                visited[i] = true;
                charArray[idx] = chars[i];
                dfs(idx + 1, chars);
                visited[i] = false;
            }

        }
    }

    private long calc(long num1, long num2, char op) {

        long answer = 0 ;
        switch (op) {
            case '+':
                answer = num1 + num2;
                break;

            case '-':
                answer = num1 - num2;
                break;

            case '*':
                answer = num1 * num2;
                break;
        }

        return answer;
    }

    @Test
    void test() {
//        assertEquals(solution("100-200*300-500+20"),60420);
        assertEquals(solution("50*6-3*2"), 300);

    }
}
