package programmers.level3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 징검다리 건너기
 */
public class level3_29 {

    public int solution(int[] stones, int k) {
        int answer = 0;

        int l = 0;
        int r = 200000000;

        while (l < r) {
            int mid = (l + r) / 2;

            if (!canCrossBy(mid, stones, k)) {
                r = mid;
            } else {
                l = mid + 1;
            }

        }

        return l-1; // 못 건너는 첫 시작값 이므로 -1 해줘야 함
    }

    private boolean canCrossBy(int mid, int[] stones, int k) {

        int skip = 0;

        for (int stone : stones) {
            if (stone < mid) {
                skip++;
            } else {
                skip = 0;
            }

            if (skip == k) {
                return false;
            }

        }
        return true;
    }


    @Test
    void test() {
        Assertions.assertEquals(solution(new int[]{2, 4, 5, 3, 2, 1, 4, 2, 5, 1}, 3), 3);
    }
}
