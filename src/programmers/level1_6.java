package programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 체육복
 */
public class level1_6 {


    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        answer = n-lost.length;

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        Arrays.stream(lost).forEach(set1::add);
        Arrays.stream(reserve).forEach(set2::add);

        for (Integer integer : lost) {
            if (set2.contains(integer)) {
                set1.remove(integer);
                set2.remove(integer);
                answer++;
            }
        }

        for (Integer integer : set1) {
            int n1 = integer + 1;
            int n2 = integer - 1;

            if (set2.contains(n2)) {
                set2.remove(n2);
                answer++;
                continue;
            }

            if (set2.contains(n1)) {
                set2.remove(n1);
                answer++;
                continue;
            }
        }

        return answer;
    }

    @Test
    void test() {
        Assertions.assertEquals(solution(5, new int[]{2, 4}, new int[]{1, 3, 5}), 5);
          Assertions.assertEquals(solution(5, new int[]{2, 4}, new int[]{3}), 4);
          Assertions.assertEquals(solution(3, new int[]{3}, new int[]{1}), 2);
          Assertions.assertEquals(solution(5, new int[]{1,2,4}, new int[]{2,4,5}), 4);
    }

}
