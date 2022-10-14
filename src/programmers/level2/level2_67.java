package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 줄 서는 방법
 */
public class level2_67 {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();


        long sum1 = 0;
        long sum2 = 0;

        for (int i : queue1) {
            q1.add(i);
            sum1 += i;
        }


        for (int i : queue2) {
            q2.add(i);
            sum2 += i;
        }


        int count = 0;
        while ((queue1.length + queue2.length) * 2 > count) {

            if (sum1 == sum2) {
                return count;
            }

            if (sum1 > sum2) {
                Integer poll = q1.poll();
                q2.add(poll);
                sum1 -= poll;
                sum2 += poll;
            } else {
                Integer poll = q2.poll();
                q1.add(poll);
                sum1 += poll;
                sum2 -= poll;
            }

            count++;
        }




        return -1;
    }

}
