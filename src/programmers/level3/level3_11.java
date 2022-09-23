package programmers.level3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 이중 우선순위 큐
 */
public class level3_11 {

    public int[] solution(String[] operations) {
        int[] answer = {0,0};

        PriorityQueue<Integer> maxpq = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (String operation : operations) {
            String[] s = operation.split(" ");
            String s0 = s[0];
            Integer value = Integer.valueOf(s[1]);

            if (pq.isEmpty() && s0.equals("D")) {
                continue;
            }
            if (s0.equals("I")) {
                pq.add(value);
                maxpq.add(value);
                continue;
            }

            if (value < 0) {
                Integer poll = pq.poll();
                maxpq.remove(poll);
                continue;
            }

            Integer poll = maxpq.poll();
            pq.remove(poll);
        }

        if (!pq.isEmpty()) {
            answer = new int[]{maxpq.poll(), pq.poll()};
        }
        return answer;
    }


    @Test
    void test() {
        Assertions.assertArrayEquals(solution(new String[]{"I 16","D 1"}), new int[]{0,0});
        Assertions.assertArrayEquals(solution(new String[]{"I 7","I 5","I -5","D -1"}), new int[]{7,5});
    }
}
