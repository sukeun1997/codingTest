package programmers.level2;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * 메뉴 리뉴얼
 */
public class level2_27 {

    HashMap<String, Integer> hashMap;
    TreeSet<String> treeSet;
    int m;

    public String[] solution(String[] orders, int[] course) {

        for (int i = 0; i < orders.length; i++) {
            char[] chars = orders[i].toCharArray();
            Arrays.sort(chars);
            orders[i] = String.valueOf(chars);
        }

        treeSet = new TreeSet<>();
        for (int i = 0; i < course.length; i++) {
            hashMap = new HashMap<>();
            m = 0;
            for (int j = 0; j < orders.length; j++) {
                dfs(0,"",orders[j],course[i],0);
            }

            if (m <= 1) {
                continue;
            }
            for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
                if (entry.getValue() == m) {
                    treeSet.add(entry.getKey());
                }
            }
        }

        return treeSet.toArray(new String[0]);
    }

    private void dfs(int idx, String now, String order, int number,int seq) {
        if (idx == number) {
            char[] chars = now.toCharArray();
            Arrays.sort(chars);
            String value = String.valueOf(chars);
            hashMap.put(value, hashMap.getOrDefault(value, 0) + 1);
            m = Math.max(m, hashMap.get(value));
            return;
        }

        for (int i = seq; i < order.length(); i++) {
            dfs(idx+1,now + order.charAt(i),order,number,i+1);
        }
    }

    @Test
    void test() {
        assertArrayEquals(solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"},new int[]{2,3,4}), new String[]{"AC", "ACDE", "BCFG", "CDE"});
        assertArrayEquals(solution(new String[]{"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"},new int[]{2,3,5}), new String[]{"ACD", "AD", "ADE", "CD", "XYZ"});

    }
}
