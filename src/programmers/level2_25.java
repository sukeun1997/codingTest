package programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;

/**
 * 구명보트
 */
public class level2_25 {

    public int solution(int[] people, int limit) {

        Arrays.sort(people);
        Deque<Integer> deque = new ArrayDeque<>();

        for (int person : people) {
            deque.add(person);
        }


        int answer = 0;
        int weight = 0;

        while (!deque.isEmpty()) {

            Integer integer = deque.removeLast();

            weight = integer;
            answer ++;

            if (deque.isEmpty()) {
                break;
            }

            if (deque.getFirst() + weight <= limit) {
                deque.removeFirst();
            }

        }




        return answer;
    }

    @Test
    void test() {
        Assertions.assertEquals(solution(new int[]{70,50,80,50},100),3);
        Assertions.assertEquals(solution(new int[]{70,80,50},100),3);
        Assertions.assertEquals(solution(new int[]{40,50,150,160},200),2);
        Assertions.assertEquals(solution(new int[]{100,500,500,900,950},1000),3);
        Assertions.assertEquals(solution(new int[]{40,50,60,90},100),3);
    }
}
