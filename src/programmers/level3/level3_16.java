package programmers.level3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 추석 트래픽
 */
public class level3_16 {

    static class Time {
        long start, end;

        public Time(long start, long end) {
            this.start = start;
            this.end = end;
        }

    }


    public int solution(String[] lines) {
        int answer = 0;

        List<Time> list = new ArrayList<>();

        for (String line : lines) {
            String[] time = line.split(" ");
            long end = 0;
            long start = 0;

            long hour = Long.parseLong(time[1].substring(0, 2)) * 60 * 60 * 1000;
            long min = Long.parseLong(time[1].substring(3, 5)) * 60 * 1000;
            long sec = Long.parseLong(time[1].substring(6, 8)) * 1000;
            long mil = Long.parseLong(time[1].substring(9));

            long t = Long.parseLong(time[2].substring(0, 1)) * 1000;

            if (time[2].indexOf('.') != -1) {
                t += Long.parseLong(time[2].substring(2, time[2].length() - 1));
            }
            end = hour + min + sec + mil;
            start = end - t + 1;

            list.add(new Time(start, end));
        }

        for (int i = 0; i < lines.length; i++) {
            int cnt = 0;

            long end = list.get(i).end;
            for (int j = i; j < lines.length; j++) {
                if (list.get(j).start < end + 1000) {
                    cnt++;
                }
            }

            answer = Math.max(answer, cnt);
        }
        return answer;
    }

    /**
     * 다른 풀이
     */
/*    public enum TType {
        START(0), END(1);

        private int value;

        TType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public static class TimeMark implements Comparable<TimeMark> {
        int time;
        TType type;

        TimeMark(int time, TType type) {
            this.time = time;
            this.type = type;
        }

        @Override
        public int compareTo(TimeMark o) {

            if (this.time != o.time) {
                return this.time - o.time;
            }
            return this.type.getValue() - o.type.getValue();
        }
    }

    public static int solution(String[] lines) {

        PriorityQueue<TimeMark> pq = new PriorityQueue<>();

        for (String line : lines) {

            String[] parts = line.split(" ");
            String[] strEnds = parts[1].split("[:.]");

            int end = Integer.parseInt(strEnds[0]);
            end = end * 60 + Integer.parseInt(strEnds[1]);
            end = end * 60 + Integer.parseInt(strEnds[2]);
            end = end * 1000 + Integer.parseInt(strEnds[3]);
            pq.add(new TimeMark(end + 999, TType.END));

            String format = String.format("%-4s", parts[2].replaceAll("[.s]", ""));
            String strTime = format.replace(' ', '0');
            int start = end - Integer.parseInt(strTime) + 1;
            pq.add(new TimeMark(start, TType.START));
        }

        int maxCnt = 0;
        int cnt = 0;
        while (!pq.isEmpty()) {

            TimeMark tm = pq.poll();
            if (tm.type == TType.START) {
                ++cnt;
            } else {
                --cnt;
            }
            maxCnt = Math.max(maxCnt, cnt);
        }
        return maxCnt;
    }*/

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
