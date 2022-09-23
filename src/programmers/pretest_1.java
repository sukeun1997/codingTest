package programmers;

import java.util.*;

public class pretest_1 {

    public int[] solution(int[][] v) {
        int[] answer = {0,0};

        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();

        for (int[] ints : v) {
            if (x.contains(ints[0])) {
                x.remove(x.indexOf(ints[0]));
            } else {
                x.add(ints[0]);
            }

            if (y.contains(ints[1])) {
                y.remove(y.indexOf(ints[1]));
            } else {
                y.add(ints[1]);
            }
        }

        answer[0] = x.get(0);
        answer[1] = y.get(0);
        return answer;
    }

}
