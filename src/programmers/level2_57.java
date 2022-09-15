package programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 두 큐 합 같게 만들기
 */
public class level2_57 {


    public int solution(int[] queue1, int[] queue2) {

        int count = 0;

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        long fSum = 0;
        long sSum = 0;

        for (int i : queue1) {
            q1.add(i);
            fSum += i;
        }
        for (int i : queue2) {
            q2.add(i);
            sSum += i;
        }

        if ((fSum + sSum) % 2 == 1) {
            return -1;
        }

        while (fSum != sSum) {
            count++;

            if (fSum > sSum) {
                Integer poll = q1.poll();
                sSum += poll;
                fSum -= poll;
                q2.add(poll);
            } else {
                Integer poll = q2.poll();
                fSum += poll;
                sSum -= poll;
                q1.add(poll);
            }

            if (count > (q1.size()+q2.size()) * 2) {
                return -1;
            }
        }


        return count;
    }

    @Test
    void test() {
        Assertions.assertEquals(solution(new int[]{3, 2, 7, 2}, new int[]{4, 6, 5, 1}), 2);
        Assertions.assertEquals(solution(new int[]{1, 2, 1, 2}, new int[]{1, 10, 1, 2}), 7);
        Assertions.assertEquals(solution(new int[]{1, 1}, new int[]{1, 5}), -1);
    }
}
