package programmers.level2;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class level2_15 {

    public int[] solution(int[] prices) {

        int[] answer = new int[prices.length];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < prices.length; i++) {

            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int pre = stack.pop();
                answer[pre] = i - pre;
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int current = stack.pop();
            answer[current] = prices.length - current - 1;
        }

        return answer;
    }


    @Test
    public void test() {
        assertEquals(solution(new int[]{1, 2, 3, 2, 3}),new int[]{4, 3, 1, 1, 0});
    }
}
