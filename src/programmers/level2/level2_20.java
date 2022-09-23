package programmers.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class level2_20 {

    private class Work {

        int progress;
        int speed;
        int count;

        public Work(int progress, int speed, int count) {
            this.progress = progress;
            this.speed = speed;
            this.count = count;
        }

        public void Working() {
            progress += speed;
        }
    }

    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        ArrayList<Integer> arrayList = new ArrayList<>();

        Queue<Work> queue = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            queue.add(new Work(progresses[i], speeds[i], i));
        }

        int next = 0;

        while (!queue.isEmpty()) {
            if (arrayList.stream().mapToInt(value -> value).sum() == progresses.length) {
                break;
            }
            for (Work work : queue) {
                work.Working();
            }

            int end = 0;
            for (Work work : queue) {
                if (work.progress >= 100) {
                    if (next == work.count) {
                        end++;
                        next++;
                    }
                }
            }
            if (end > 0) {
                arrayList.add(end);
            }
        }

        answer = new int[arrayList.size()];

        for (int i = 0; i < arrayList.size(); i++) {
            answer[i] = arrayList.get(i);
        }

        return answer;
    }

    @Test
    public void test() {
        Assertions.assertEquals(solution(new int[]{93, 30, 55}, new int[]{1, 30, 5}), new int[]{2, 1});
        Assertions.assertEquals(solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1}), new int[]{1, 3, 2});
        Assertions.assertEquals(solution(new int[]{20, 99, 93, 30, 55, 10}, new int[]{5, 10, 1, 1, 30, 5}), new int[]{3,3});
        Assertions.assertEquals(solution(new int[]{2, 2, 1, 2}, new int[]{1, 1, 1, 1}), new int[]{2,2});
    }
}
