package programmers.level2;

import java.util.Deque;
import java.util.LinkedList;

public class level2_2 {


    public static int solution(int[] priorities, int location) {

        int answer = 0;
        Deque<int[]> deque = new LinkedList<>();
        for (int i = 0; i < priorities.length ; i++) {
            deque.add(new int[]{i,priorities[i]});

        }

        int max = deque.stream().max((o1, o2) -> o1[1] - o2[1]).get()[1];
        while (!deque.isEmpty()) {
            if (deque.getFirst()[1] == max) {
                answer++;
                if (deque.getFirst()[0] == location) {
                    break;
                }
                deque.remove();
                max = deque.stream().max((o1, o2) -> o1[1] - o2[1]).get()[1];

            } else {
                deque.add(deque.remove());
            }
        }

        return answer;
    }

    public static void main(String[] args) {
//        solution(new int[]{2, 1, 3, 2}, 2);
        solution(new int[]{1, 1, 9, 1, 1, 1}, 0);
    }
}
