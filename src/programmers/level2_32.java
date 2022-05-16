package programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 괄호 변환
 */
public class level2_32 {

        StringBuilder sb;

        public String solution(String p) {
            sb = new StringBuilder();

        String u = "";
        String v = "";
        Stack<String> queue = new Stack<>();

        int idx = 0;
        int start = 0;
        while (idx < p.length()) {
            char c = p.charAt(idx);

            u += c;
            if (isRight(u)) {
                if (check(u)) {
                    sb.append(u);
                } else {
                    sb.append("(");
                    queue.add(u);
                }
                u = "";
            }
            idx++;
        }

        while (!queue.isEmpty()) {
            String s = "";
            sb.append(")");
            String poll = queue.pop();
            String substring = poll.substring(1, poll.length() - 1);

            for (char c : substring.toCharArray()) {
                if (c == '(') {
                    s += ')';
                } else {
                    s += '(';
                }
            }
            sb.append(s);
        }



        return sb.toString();
    }

    private boolean isRight(String u) {
        int count  = 0;
        int length = u.length();
        if (length % 2 == 0) {
            for (char c : u.toCharArray()) {
                if (c == '(') {
                    count++;
                }
            }

            if (length - count == count) {
                return true;
            }
        }
        return false;
    }

    private boolean check(String u) {
        Stack<Character> stack = new Stack<>();

        for (char c : u.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (!stack.isEmpty()) {
                stack.pop();
            } else {
                return false;
            }
        }

        return true;
    }


    @Test
    void test() {

        assertEquals(solution("(()())()"),"(()())()");
        assertEquals(solution(")("),"()");
        assertEquals(solution("()))((()"),"()(())()");
        assertEquals(solution("))()(("),"()()()");
        assertEquals(solution(")()()()("),"(((())))");
        assertEquals(solution("))(()("),"(())()");
    }

}
