package programmers.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class level2_18 {

    public int solution(int[] priorities, int location) {
        int answer = 0;

        Deque<int[]> stack = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            stack.add(new int[]{i, priorities[i]});
        }

        Arrays.sort(priorities);

        int max = priorities.length-1;

        while (!stack.isEmpty()) {

            int[] pop = stack.pop();

            if (pop[1] == priorities[max]) {
                max--;
                answer++;
                if (pop[0] == location) {
                    break;
                }
            } else {
                stack.addLast(pop);
            }

        }
        return answer;
    }


    @Test
    public void test() {
        Assertions.assertEquals(solution(new int[]{2,1,3,2},2), 1);
        Assertions.assertEquals(solution(new int[]{1, 1, 9, 1, 1, 1},0), 5);
    }
}
