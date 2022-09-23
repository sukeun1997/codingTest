package programmers.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * 튜플
 */
public class level2_31 {

    public int[] solution(String s) {

        Set<Integer> set = new HashSet<>();
        int answer[];
        String[] trim = s.replaceAll("[{]", " ").replaceAll("[}]", " ").trim().split(" , ");

        Arrays.sort(trim, Comparator.comparingInt(String::length));

        int idx = 0;
        answer = new int[trim.length];
        for (String s1 : trim) {
            for (String s2 : s1.split(",")) {
                Integer value = Integer.valueOf(s2);
                if(set.add(value)) answer[idx++] = value;
            }
        }

        return answer;
    }

    @Test
    void test() {
        assertArrayEquals(solution("{{2},{2,1},{2,1,3},{2,1,3,4}}"),new int[]{2,1,3,4});
        assertArrayEquals(solution("{{1,2,3},{2,1},{1,2,4,3},{2}}"),new int[]{2,1,3,4});
        assertArrayEquals(solution("{{20,111},{111}}"),new int[]{111,20});
        assertArrayEquals(solution("{{123}}"),new int[]{123});
        assertArrayEquals(solution("{{4,2,3},{3},{2,3,4,1},{2,3}}"),new int[]{3,2,4,1});

    }


    /**
     * Set 풀이
     */

    /*public int[] solution(String s) {
        Set<String> set = new HashSet<>();
        String[] arr = s.replaceAll("[{]", " ").replaceAll("[}]", " ").trim().split(" , ");
        Arrays.sort(arr, (a, b)->{return a.length() - b.length();});
        int[] answer = new int[arr.length];
        int idx = 0;
        for(String s1 : arr) {
            for(String s2 : s1.split(",")) {
                if(set.add(s2)) answer[idx++] = Integer.parseInt(s2);
            }
        }
        return answer;
    }*/

    /**
     * Map 풀이
     */
    /*
        public int[] solution(String s) {

        Map<String, Integer> map = new HashMap<>();
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()) {
            String n = matcher.group();
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int size = map.size();
        int[] answer = new int[size];
        for (String key: map.keySet()) {
            answer[size - map.get(key)] = Integer.parseInt(key);
        }
        return answer;
    }
     */
}
