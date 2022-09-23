package programmers.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 카펫
 */
public class level2_24 {

    public int[] solution(int brown, int yellow) {
        int[] answer = {};

        ArrayList<Integer> first = new ArrayList<>();
        ArrayList<Integer> second = new ArrayList<>();
        for (int i = 1; i*i <= yellow; i++) {
            if (yellow % i == 0) {
                first.add(i);
                second.add(yellow / i);
            }
        }

        answer = new int[2];
        for (int i = 0; i < first.size(); i++) {
            Integer row = second.get(i);
            Integer col = first.get(i);
            if ((col *2) + (row *2) + 4 == brown) {
                answer[0] = row + 2;
                answer[1] = col + 2;
            }
        }
        return answer;

    }

    @Test
    void test() {
        assertArrayEquals(solution(10, 2), new int[]{4,3});
        assertArrayEquals(solution(8, 1), new int[]{3,3});
        assertArrayEquals(solution(24, 24), new int[]{8,6});
    }

}
