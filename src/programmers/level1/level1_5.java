package programmers.level1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class level1_5 {
    public int[] solution(int[] array, int[][] commands) {

        int[] answer = {};

        answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int[] ints = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            Arrays.sort(ints);
            answer[i] = ints[commands[i][2]-1];
        }

        return answer;
    }

    @Test
    public void test() {
        Assertions.assertEquals(solution(new int[]{1, 5, 2, 6, 3, 7, 4},new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}}), new int[]{5,6,3});
    }
}
