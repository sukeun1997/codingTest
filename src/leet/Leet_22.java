package leet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * Generate Parentheses
 */
public class Leet_22 {
    public List<String> generateParenthesis(int n) {
        List<String> list = new LinkedList<>();

        dfs(0, n, 0, list, "");
        return list;
    }

    private void dfs(int count, int n, int sum, List<String> list, String now) {
        if (count == n * 2) {
            if (sum == 0) {
                list.add(now);
            }
            return;
        }

        if (sum < n) {
            dfs(count + 1, n, sum + 1, list, now + "(");
        }

        if (sum > 0) {
            dfs(count + 1, n, sum - 1, list, now + ")");
        }


    }


    @Test
    void test() {
        Assertions.assertEquals(generateParenthesis(3), List.of("((()))", "(()())", "(())()", "()(())", "()()()"));
    }
}
