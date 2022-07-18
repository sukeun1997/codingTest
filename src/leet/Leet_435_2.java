package leet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Non-overlapping Intervals
 */
public class Leet_435_2 {

    public int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));

        int idx = 0;
        int next = Integer.MIN_VALUE;
        int remove = 0;
        while (idx < intervals.length) {

            if (next > intervals[idx][0]) {
                remove++;
                idx++;
                continue;
            }

            next = intervals[idx][1];
            idx++;
        }


        return remove;
    }

    @Test
    void test() {
        Assertions.assertEquals(eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}}), 1);
        Assertions.assertEquals(eraseOverlapIntervals(new int[][]{{1, 2}, {1, 2}, {1, 2}}), 2);
        Assertions.assertEquals(eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}, {3, 4}}), 0);
        Assertions.assertEquals(eraseOverlapIntervals(new int[][]{{1, 100}, {11, 22}, {1, 11}, {2, 12}}), 2);
        Assertions.assertEquals(eraseOverlapIntervals(new int[][]{{0, 2}, {1, 3}, {2, 4}, {3, 5}, {4, 6}}), 2);
        Assertions.assertEquals(eraseOverlapIntervals(new int[][]{{1,2},{2,3},{3,4},{-100,-2},{5,7}}), 0);
    }
}
