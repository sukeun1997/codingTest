package etc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.SimpleTimeZone;

public class kakao_1 {

    /**
     * 모든 달 28일 까지 있다
     * terms 1~20
     * privacies = 1~100
     */
    public int[] solution(String today, String[] terms, String[] privacies) {

        HashMap<String, Integer> doc = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (String term : terms) {
            String[] s = term.split(" ");
            doc.put(s[0], Integer.parseInt(s[1]) * 28);
        }

        long now = changeDay(today);

        for (int i = 0; i < privacies.length; i++) {
            String[] priv = privacies[i].split(" ");
            if (now >= changeDay(priv[0]) + doc.get(priv[1])) {
                result.add(i + 1);
            }
        }

        return result.stream().mapToInt(value -> value).toArray();
    }

    private long changeDay(String today) {
        String[] day = today.split("[.]");
        int y = Integer.parseInt(day[0]) - 2000;
        int m = Integer.parseInt(day[1]);
        int d = Integer.parseInt(day[2]);

        return (y * 12 * 28) + (m * 28) + d;
    }

    @Test
    void test() {
        Assertions.assertArrayEquals(solution("2022.05.19", new String[]{"A 6", "B 12", "C 3"},
                        new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"}),
                new int[]{1, 3});
    }
}
