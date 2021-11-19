package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class level1_3 {

    public static int[] solution(int[] lottos, int[] win_nums) {

            int count = 0;
            int zeroCount = 0;

        for (int lotto : lottos) {
            if (Arrays.stream(win_nums).anyMatch(value -> value == lotto)) {
                count++;
            }
            if (lotto == 0) {
                zeroCount++;
            }
        }

        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(rank(count + zeroCount));
        answer.add(rank(count));



        return answer.stream().mapToInt(value -> value).toArray();
    }

    private static int rank(int num) {

        switch (num) {
            case 6:
                return 1;
            case 5:
                return 2;
            case 4:
                return 3;
            case 3:
                return 4;
            case 2:
                return 5;
            default:
                return 6;
        }
    }


    public static void main(String[] args) {

        solution(new int[]{44, 1, 0, 0, 31, 25}, new int[]{31, 10, 45, 1, 6, 19});

    }
}
