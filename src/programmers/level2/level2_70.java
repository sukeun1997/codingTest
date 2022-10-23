package programmers.level2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class level2_70 {
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
}
