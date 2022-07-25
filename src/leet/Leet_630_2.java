package leet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class Leet_630_2 {

    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, Comparator.comparingInt(o -> o[1]));

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);

        int sum = 0;
        for (int i = 0; i < courses.length; i++) {

            sum += courses[i][0];
            queue.add(courses[i][0]);
            if (sum > courses[i][1]) {
                Integer poll = queue.poll();
                sum -= poll;
            }
        }
        return queue.size();
    }

    @Test
    void test() {
        Assertions.assertEquals(scheduleCourse(new int[][]{{100, 200}, {200, 1300}, {1000, 1250}, {2000, 3200}}), 3);
        Assertions.assertEquals(scheduleCourse(new int[][]{{5,5},{4,6},{2,6}}), 2);
    }
}
