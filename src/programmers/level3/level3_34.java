package programmers.level3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.SortedSet;

public class level3_34 {

    public long solution(int n, int[] works) {
        long answer = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        int worksCount = 0;

        for (int work : works) {
            queue.add(work);
            worksCount += work;
        }

        while (worksCount > 0 && n != 0) {
            Integer poll = queue.poll();
            queue.add(poll - 1);
            worksCount--;
            n--;
        }

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            answer += poll * poll;
        }

        return answer;
    }


    @Test
    void test() {

        Assertions.assertEquals(solution(4, new int[]{4, 3, 3}), 12);
        Assertions.assertEquals(solution(1, new int[]{2, 1, 2}), 6);
        Assertions.assertEquals(solution(3, new int[]{1, 1}), 0);
    }
}
