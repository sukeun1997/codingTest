package programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class level1_8 {

    public int solution(int[] numbers) {

        ArrayList<Integer> list = new ArrayList<>();


        for (int number : numbers) {
            list.add(number);
        }

        int answer = 0;
        for (int i = 0; i < 10; i++) {
            if (!list.contains(i)) {
                answer += i;
            }
        }

        return answer;
    }


    @Test
    void test() {
        Assertions.assertEquals(solution(new int[]{1, 2, 3, 4, 6, 7, 8, 0}), 14);
    }
}
