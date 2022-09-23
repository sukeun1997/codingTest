package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * 모의고사
 */
public class level1_10 {

    public int[] solution(int[] answers) {

        int[] a = new int[]{1, 2, 3, 4, 5};
        int[] b = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] ans = new int[3];
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == a[i % 5]) ans[0]++;
            if (answers[i] == b[i % 8]) ans[1]++;
            if (answers[i] == c[i % 10]) ans[2]++;
        }

        int max = Arrays.stream(ans).max().getAsInt();

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < ans.length; i++) {
            if (max == ans[i]) {
                list.add(i + 1);
            }
        }

        return list.stream().mapToInt(value -> value).toArray();

    }
}
