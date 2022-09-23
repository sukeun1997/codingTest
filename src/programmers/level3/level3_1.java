package programmers.level3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class level3_1 {

    public int solution(int n, int[][] edge) {
        ArrayList<Integer> arrayList[] = new ArrayList[n + 1];
        boolean visited[] = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n ; i++) {
            arrayList[i] = new ArrayList<>();
        }
        for (int[] value : edge) {
            int a = value[0];
            int b = value[1];
            arrayList[a].add(b);
            arrayList[b].add(a);
        }

        queue.add(1);
        visited[1] = true;

        int count[] = new int[n + 1];
        int max = 0;
        while (!queue.isEmpty()) {

            Integer poll = queue.poll();

            for (Integer integer : arrayList[poll]) {
                if (!visited[integer]) {
                    visited[integer] = true;
                    count[integer] = count[poll] + 1;
                    max = Math.max(max, count[integer]);
                    queue.add(integer);
                }
            }
        }

        int finalMax = max;
        int answer = (int) Arrays.stream(count).filter(value -> value == finalMax).count();
        return answer;
    }

    @Test
    void test() {
        Assertions.assertEquals(solution(6,new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}}),3);
    }
}
