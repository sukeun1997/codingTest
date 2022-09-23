package programmers.level2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * 메뉴 리뉴얼 다시 풀기
 */
public class level2_43 {


    HashMap<String, Integer> hashMap;
    int m;

    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};

        for (int i = 0; i < orders.length; i++) {
            char[] chars = orders[i].toCharArray();
            Arrays.sort(chars);
            orders[i] = String.valueOf(chars);
        }

        TreeSet<String> set = new TreeSet<>();
        for (int i = 0; i < course.length; i++) {

            hashMap = new HashMap<>();
            m = 0;
            for (int j = 0; j < orders.length; j++) {
                createCourse(0, "", course[i], orders[j], 0);
            }

            if (m < 2) {
                continue;
            }

            for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
                if (entry.getValue() == m) {
                    set.add(entry.getKey());
                }
            }

        }

        return set.toArray(new String[0]);
    }

    private void createCourse(int idx, String now, int count, String order, int seq) {

        if (idx == count) {
            char[] chars = now.toCharArray();
            Arrays.sort(chars);
            now = String.valueOf(chars);

            hashMap.put(now, hashMap.getOrDefault(now, 0)+1);
            m = Math.max(hashMap.get(now), m);
            return;
        }

        for (int i = seq; i < order.length(); i++) {
            createCourse(idx + 1, now + order.charAt(i), count, order, i + 1);
        }
    }


    @Test
    void test() {
        assertArrayEquals(solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]{2, 3, 4}), new String[]{"AC", "ACDE", "BCFG", "CDE"});
        assertArrayEquals(solution(new String[]{"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"}, new int[]{2, 3, 5}), new String[]{"ACD", "AD", "ADE", "CD", "XYZ"});

    }

}
