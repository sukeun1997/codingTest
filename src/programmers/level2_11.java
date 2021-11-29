package programmers;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class level2_11 {

    public int solution(String s) {
        int answer = -1;

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {

            if (!stack.isEmpty()) {
                if (stack.peek() == c) {
                    stack.pop();
                    continue;
                }
            }

            stack.push(c);
        }

        answer = stack.isEmpty() ? 1 : 0;
        return answer;
    }

    @Test
    public void test() {
        assertEquals(solution("baabaa"), 1);
        assertEquals(solution("cdcd"), 0);
    }
}
