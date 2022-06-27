package etc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Course Schedule III
 */
public class Leet_630 {

    public int scheduleCourse(int[][] courses) {


        Arrays.sort(courses, Comparator.comparingInt(value -> value[1]));

        int start = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2-o1);

        for (int[] cours : courses) {

            start += cours[0];
            queue.add(cours[0]);

            if (start > cours[1]) {
                start -= queue.poll();
            }
        }

        return queue.size();
    }

    @Test
    void test() {
//        Assertions.assertEquals(scheduleCourse(new int[][]{{100, 200}, {200, 1300}, {1000, 1250}, {2000, 3200}}), 3);
        Assertions.assertEquals(scheduleCourse(new int[][]{{5,5},{4,6},{2,6}}), 2);
    }
}
