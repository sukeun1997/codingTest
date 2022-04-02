package programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 숫자문자열과 문자열
 */
public class level1_7 {

    public int solution(String s) {
        String[] st = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        Set<String> strings = new HashSet<>();
        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < st.length; i++) {
            map.put(st[i], String.valueOf(i));
        }
        for (int i = 0; i < 10; i++) {
            strings.add(String.valueOf(i));
        }

        String[] split = s.split("");

        StringBuilder sb = new StringBuilder();

        String find = "";
        for (int i = 0; i < split.length; i++) {
            if (find.equals("") && strings.contains(split[i])) {
                sb.append(split[i]);
            } else {
                    find += split[i];
                if(map.containsKey(find)) {
                    sb.append(map.get(find));
                    find = "";
                }
            }
        }

        int answer = Integer.valueOf(sb.toString());
        return answer;
    }


    @Test
    void test(){
        Assertions.assertEquals(solution("one4seveneight"), 1478);
        Assertions.assertEquals(solution("23four5six7"), 234567);
    }
}
