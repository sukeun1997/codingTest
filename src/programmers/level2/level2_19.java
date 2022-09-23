package programmers.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class level2_19 {


    public int solution(int bridge_length, int weight, int[] truck_weights) {

        int answer = 0;
        Queue<int[]> queue = new LinkedList<>();
        Queue<int[]> wait = new LinkedList<>();

        for (int truck_weight : truck_weights) {
            wait.add(new int[]{0, truck_weight});
        }

        while (!wait.isEmpty()) {

            if (!queue.isEmpty()) {
                int co = queue.size();
                for (int i = 0; i < co; i++) {
                    int[] remove = queue.remove();
                    int time = remove[0];
                    int now = remove[1];

                    if (time + 1 != bridge_length) {
                        queue.add(new int[]{time + 1, now});
                    }
                }
            }

            if (queue.stream().mapToInt(value -> value[1]).sum() + wait.peek()[1] <= weight) {
                queue.add(wait.remove());
            }
            answer++;
        }

        while (!queue.isEmpty()) {

            int co = queue.size();
            for (int i = 0; i < co; i++) {
                int[] remove = queue.remove();
                int time = remove[0];
                int now = remove[1];

                if (time + 1 != bridge_length) {
                    queue.add(new int[]{time + 1, now});
                }
            }
            answer++;
        }

        return answer;
    }


    @Test
    public void test() {
        Assertions.assertEquals(solution(2, 10, new int[]{7, 4, 5, 6}), 8);
        Assertions.assertEquals(solution(100, 100, new int[]{10}), 101);
        Assertions.assertEquals(solution(100, 100, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10}), 110);
    }
}
