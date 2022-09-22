package programmers;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 수식 최대화
 */
public class level2_61 {

    boolean visited[];
    // exp 3~100
    public long solution(String expression) {
        long answer = 0;

        List<Long> list = Arrays.stream(expression.split("[-+ *]")).map(value -> Long.parseLong(value)).collect(Collectors.toList());
        List<String> ops = Arrays.stream(expression.replaceAll("[^-+*]", "").split("")).collect(Collectors.toList());

        visited = new boolean[3];
        int[] chars = new int[3];
        answer = Math.max(answer, dfs(0, list, ops, chars));

        return answer;
    }

    private long dfs(int i, List<Long> nums, List<String> ops, int[] chars) {
        long ans = 0;

        if (i == chars.length) {
            ArrayList<Long> numList = new ArrayList<>(nums);
            ArrayList<String> opList = new ArrayList<>(ops);

            for (int op : chars) {
                String opString = opIntToString(op);

                for (int j = 0; j < opList.size(); j++) {
                    if (opList.get(j).equals(opString)) {
                        long result = calc(numList.remove(j), numList.remove(j), opList.remove(j));
                        numList.add(j, result);
                        j--;
                    }
                }
            }

            return Math.abs(numList.get(0));
        }

        for (int j = 0; j < 3; j++) {
            if (!visited[j]) {
                visited[j] = true;
                chars[i] = j;
                ans = Math.max(ans, dfs(i + 1, nums, ops, chars));
                visited[j] = false;
            }
        }

        return ans;
    }

    private long calc(long n1, long n2, String op) {

        long ans = 0;

        switch (op) {
            case "+":
                ans = n1 + n2;
                break;
            case "-":
                ans = n1 - n2;
                break;
            default:
                ans = n1 * n2;
        }

        return ans;
    }

    private String  opIntToString(int op) {
        if (op == 0) {
            return "+";
        } else if (op == 1) {
            return "-";
        } else {
            return "*";
        }
    }


    @Test
    void test() {
/*        assertEquals(solution("100-200*300-500+20"), 60420);
        assertEquals(solution("50*6-3*2"), 300);*/
        assertEquals(solution("2*2*2*2*2-2*2*2"), 24);

    }
}
