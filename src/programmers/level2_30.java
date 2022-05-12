package programmers;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 수식 최대화
 */
public class level2_30 {

    boolean visited[]; // * + -
    char [] chars;
    ArrayList<Long> nums = new ArrayList<>();
    ArrayList<Character> ops = new ArrayList<>();
    long answer = 0;

    public long solution(String expression) {
        visited = new boolean[3];
        chars = new char[]{'*','+','-'};

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
        nums.add(Long.valueOf(num));
        dfs(0, new char[3]);



        return answer;
    }

    private void dfs(int count, char[] charArray) {
        if (count == 3) {
            ArrayList<Long> cNums = new ArrayList<>(nums);
            ArrayList<Character> cOps = new ArrayList<>(ops);

            for (int i = 0; i < charArray.length; i++) {
                for (int j = 0; j < cOps.size(); j++) {
                    if (charArray[i] == cOps.get(j)) {
                        long calc = calc(cNums.remove(j), cNums.remove(j), cOps.remove(j));
                        cNums.add(j, calc);
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
                charArray[count] = chars[i];
                dfs(count+1,charArray);
                visited[i] = false;
            }
        }
    }

    private long calc(long remove, long remove1, char remove2) {

        long answer = 0;
        switch (remove2) {
            case '+':
                answer = remove + remove1;
                break;
            case '-':
                answer = remove - remove1;
                break;
            default:
                answer = remove * remove1;
                break;
        }

        return answer;
    }


    @Test
    void test() {
//        assertEquals(solution("100-200*300-500+20"),60420);
        assertEquals(solution("50*6-3*2"),300);

    }
}
