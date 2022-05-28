package programmers;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 디스크 컨트롤러 RE
 */
public class level3_14 {


    public int solution(int[][] jobs) {
        int answer = 0;

        Arrays.sort(jobs, Comparator.comparingInt(o -> o[0]));

        int end = 0; // 수행되고난 직후의 시간
        int jobsIdx = 0; // jobs 배열의 인덱스
        int count = 0; // 수행된 요청 갯수

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(value -> value[1]));

        int length = jobs.length;
        while (count < length) {

            while (jobsIdx < length && jobs[jobsIdx][0] <= end) {
                priorityQueue.add(jobs[jobsIdx++]);
            }

            if (priorityQueue.isEmpty()) {
                end = jobs[jobsIdx][0];
            } else {
                int[] poll = priorityQueue.poll();
                answer += end - poll[0] + poll[1];
                end = end + poll[1];
                count++;
            }

        }
        return answer / length;
    }


    @Test
    void test() {
        assertEquals(solution(new int[][]{{0,3},{1,9},{2,6}}), 9);
        assertEquals(solution(new int[][]{{0, 10}, {2, 10}, {9, 10}, {15, 2}}), 14);
        assertEquals(solution(new int[][]{{0,1},{0,1},{0,1}}), 2);
        assertEquals(solution(new int[][]{{0, 3}, {1, 9}, {2, 6}, {30, 3}}), 7);
        assertEquals(solution(new int[][]{{0, 10}, {4, 10}, {15, 2}, {5, 11}}), 15);
        assertEquals(solution(new int[][]{{10, 10}, {30, 10}, {50, 2}, {51, 2}}), 6);
    }
}
