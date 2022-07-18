package leet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Course Schedule II
 */
public class Leet_210 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        int count[] = new int[numCourses];

        ArrayList<Integer> graphs[] = new ArrayList[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graphs[i] = new ArrayList<>();
        }

        for (int[] prerequisite : prerequisites) {
            int next = prerequisite[0];
            int req = prerequisite[1];
            graphs[req].add(next);
            count[next]++;
        }


        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> answer = new ArrayList<>();

        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0) {
                queue.add(i);
            }
        }


        while (!queue.isEmpty()) {
            Integer now = queue.poll();
            answer.add(now);

            for (Integer next : graphs[now]) {
                count[next]--;
                if (count[next] == 0) {
                    queue.add(next);
                }
            }
        }


        if (answer.size() == numCourses) {
            return answer.stream().mapToInt(value -> value).toArray();
        }
        return new int[0];
    }


    @Test
    void test() {
//        Assertions.assertArrayEquals(findOrder(2, new int[][]{{1, 0}}), new int[]{0, 1});
        Assertions.assertArrayEquals(findOrder(3, new int[][]{{1, 0}, {1, 2}, {0, 1}}), new int[]{});
//        Assertions.assertArrayEquals(findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}}), new int[]{0, 2, 1, 3});
    }
}
