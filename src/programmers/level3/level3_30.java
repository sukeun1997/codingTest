package programmers.level3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 추석 트래픽
 */
public class level3_30 {

    public int solution(String[] lines) {
        int answer = 0;

        Queue<Traffic> queue = new LinkedList<>();

        for (String line : lines) {
            String[] input = line.split(" ");
            String[] time = input[1].replace(".", "").split(":");
            long end = Long.parseLong(time[0]) * 60 * 60 * 1000 + Long.parseLong(time[1]) * 60 * 1000 + Long.parseLong(time[2]);

            long t = Long.parseLong(input[2].substring(0, 1)) * 1000;

            if (input[2].indexOf('.') != -1) {
                t += Long.parseLong(input[2].substring(2, input[2].length() - 1));
            }

            long start = end - t + 1;

            queue.add(new Traffic(start, end));
        }


        while (!queue.isEmpty()) {

            Traffic traffic = queue.poll();

            long count = queue.stream().filter(next -> next.start <= traffic.end + 999).count() + 1;

            answer = (int) Math.max(count, answer);

        }


        return answer;
    }

    private class Traffic {
        long start, end;


        public Traffic(long start, long end) {
            this.start = start;
            this.end = end;
        }
    }

    @Test
    void test() {
        Assertions.assertEquals(solution(new String[]{"2016-09-15 01:00:04.001 2.0s",
                "2016-09-15 01:00:07.000 2s"}), 1);
        Assertions.assertEquals(solution(new String[]{"2016-09-15 01:00:04.002 2.0s",
                "2016-09-15 01:00:07.000 2s"}), 2);
        Assertions.assertEquals(solution(new String[]{"2016-09-15 20:59:57.421 0.351s",
                "2016-09-15 20:59:58.233 1.181s",
                "2016-09-15 20:59:58.299 0.8s",
                "2016-09-15 20:59:58.688 1.041s",
                "2016-09-15 20:59:59.591 1.412s",
                "2016-09-15 21:00:00.464 1.466s",
                "2016-09-15 21:00:00.741 1.581s",
                "2016-09-15 21:00:00.748 2.31s",
                "2016-09-15 21:00:00.966 0.381s",
                "2016-09-15 21:00:02.066 2.62s"}), 7);
    }
}
