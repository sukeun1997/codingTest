package programmers.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class level2_64 {

    private HashMap<String ,Integer> map;

    public int solution(String s) {
        int answer = 0;

        String[] split = s.split("");
        map = new HashMap<>();

        map.put("(", 0);
        map.put("[", 1);
        map.put("{", 2);

        map.put(")", 0);
        map.put("]", 1);
        map.put("}", 2);
        Queue<String> queue = new LinkedList<>();

        for (String s1 : split) {
            queue.add(s1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (isValid(queue)) {
                answer++;
            }
            queue.add(queue.poll());
        }

        return answer;
    }

    private boolean isValid(Queue<String> queue) {

        Queue<String> clone = new LinkedList<>(queue);
        Stack<String> stack = new Stack<>();

        while (!clone.isEmpty()) {
            String poll = clone.poll();

            if (poll.equals("{") || poll.equals("[") || poll.equals("(")) {
                stack.add(poll);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                String pop = stack.pop();
                if (map.get(poll) != map.get(pop)) {
                    return false;
                }
            }
        }

        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }


    @Test
    void test() {
        Assertions.assertEquals(solution("[](){}"),3);
        Assertions.assertEquals(solution("}]()[{"), 2);
        Assertions.assertEquals(solution("[)(]"), 0);
        Assertions.assertEquals(solution("([{)}]"), 0);
        Assertions.assertEquals(solution("}}}"), 0);
    }
}
