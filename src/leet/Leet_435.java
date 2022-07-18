package leet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * Non-overlapping Intervals
 */
public class Leet_435 {

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[1] - o2[1]);

        int cur[] = intervals[0];
        int answer = 1;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= cur[1]) {
                cur = intervals[i];
                answer++;
            }
        }
        return intervals.length - answer;
    }

    @Test
    void test() {
        Assertions.assertEquals(eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}}), 1);
        Assertions.assertEquals(eraseOverlapIntervals(new int[][]{{1, 2}, {1, 2}, {1, 2}}), 2);
        Assertions.assertEquals(eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}, {3, 4}}), 0);
        Assertions.assertEquals(eraseOverlapIntervals(new int[][]{{1, 100}, {11, 22}, {1, 11}, {2, 12}}), 2);
        Assertions.assertEquals(eraseOverlapIntervals(new int[][]{{0, 2}, {1, 3}, {2, 4}, {3, 5}, {4, 6}}), 2);
    }
}
