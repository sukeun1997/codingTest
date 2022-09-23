package programmers.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class level2_21 {


    public int solution(int[] citations) {

        Arrays.sort(citations);

        int count = 0;
        for (int i = citations.length - 1; i >= 0; i--) {
            count++;

            if (citations[i] < count) {
                return --count;
            }

        }

        return count;
    }


    @Test
    public void test() {
        Assertions.assertEquals(solution(new int[]{1, 3, 5, 7, 9, 11}), 4);
        Assertions.assertEquals(solution(new int[]{1, 1, 5, 7, 6}), 3);
        Assertions.assertEquals(solution(new int[]{9,9,9,12}), 4);
    }
}
