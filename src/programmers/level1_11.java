package programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class level1_11 {

    public String solution(String[] survey, int[] choices) {
        String answer = "";


        HashMap<String, Integer> map = new HashMap<>();

        map.put("T", 0);
        map.put("C", 0);
        map.put("M", 0);
        map.put("A", 0);
        map.put("N", 0);
        map.put("R", 0);
        map.put("F", 0);
        map.put("J", 0);

        for (int i = 0; i < survey.length; i++) {
            if (choices[i] - 4 > 0) {
                String sec = String.valueOf(survey[i].charAt(1));
                map.put(sec, map.getOrDefault(sec, 0) + choices[i] - 4);
            } else {
                String  sec = String.valueOf(survey[i].charAt(0));
                map.put(sec, map.getOrDefault(sec, 0) + Math.abs(choices[i] - 4));
            }
        }

        if (map.get("R") >= map.get("T")) {
            answer += "R";
        } else {
            answer += "T";
        }

        if (map.get("C") >= map.get("F")) {
            answer += "C";
        } else {
            answer += "F";
        }

        if (map.get("J") >= map.get("M")) {
            answer += "J";
        } else {
            answer += "M";
        }

        if (map.get("A") >= map.get("N")) {
            answer += "A";
        } else {
            answer += "N";
        }

        return answer;
    }


    @Test
    void test() {
        Assertions.assertEquals(solution(new String[]{"AN", "CF", "MJ", "RT", "NA"}, new int[]{5, 3, 2, 7, 5}), "TCMA");
    }
}
