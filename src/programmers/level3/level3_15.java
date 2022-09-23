package programmers.level3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class level3_15 {
    public long solution(int n, int[] times) {
        long answer = 0;

        Arrays.sort(times);

        long lo = 1;
        long hi = (long) times[times.length - 1] * n;

        while (lo < hi) {

            long mid = lo + (hi - lo) / 2;


            if (canImmigration(n, times, mid)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }


        return lo;
    }

    private boolean canImmigration(int n, int[] times, long mid) {
        long cnt = 0;

        for (int time : times) {
            cnt += mid / time;
        }

        return cnt >= n;
    }


    @Test
    void test() {
        Assertions.assertEquals(solution(6, new int[]{7, 10}), 28);
        Assertions.assertEquals(solution(10, new int[]{6,8, 10}), 30);
    }
}
