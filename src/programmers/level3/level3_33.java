package programmers.level3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;
import java.util.Stack;

/**
 * 셔틀버스
 */
public class level3_33 {

    public String solution(int n, int t, int m, String[] timetable) {
        int answer = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        addChangedTimeToQueue(timetable, queue);

        int startTime = 9 * 60;

        Stack<Integer> boarding = new Stack<>();

        for (int i = 0; i < n; i++) {
            int count = m;


            count = getBoardedCountBy(queue, startTime, boarding, count);

            if (isLastBus(n, i)) {
                answer = getLastBoardTime(startTime, boarding, count);
            }

            startTime += t;
        }

        return String.format("%02d:%02d", answer / 60, answer % 60);
    }

    private boolean isLastBus(int n, int i) {
        return i == n - 1;
    }

    private int getLastBoardTime(int startTime, Stack<Integer> boarding, int count) {
        int answer;
        if (count == 0) {
            answer = boarding.peek() - 1;
        } else {
            answer = startTime;
        }
        return answer;
    }

    private int getBoardedCountBy(PriorityQueue<Integer> queue, int startTime, Stack<Integer> boarding, int count) {
        while (count > 0 && !queue.isEmpty()) {

            if (queue.peek() > startTime) {
                break;
            }
            boarding.add(queue.poll());
            count--;
        }
        return count;
    }

    private void addChangedTimeToQueue(String[] timetable, PriorityQueue<Integer> queue) {
        for (String time : timetable) {
            int timeToInt = 0;
            String[] s = time.split(":");
            timeToInt = Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
            queue.add(timeToInt);
        }
    }


    @Test
    void test() {

        Assertions.assertEquals(solution(1, 1, 5, new String[]{"08:00", "08:01", "08:02", "08:03"}), "09:00");
        Assertions.assertEquals(solution(2, 10, 2, new String[]{"09:10", "09:09", "08:00"}), "09:09");
        Assertions.assertEquals(solution(2, 1, 2, new String[]{"09:00", "09:00", "09:00", "09:00"}), "08:59");
        Assertions.assertEquals(solution(1, 1, 5, new String[]{"00:01", "00:01", "00:01", "00:01", "00:01"}), "00:00");
        Assertions.assertEquals(solution(1, 1, 1, new String[]{"23:59"}), "09:00");
        Assertions.assertEquals(solution(10, 60, 45, new String[]{"23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"}), "18:00");
    }
}
