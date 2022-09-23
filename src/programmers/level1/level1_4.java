package programmers.level1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class level1_4 {

    public String solution(String[] participant, String[] completion) {

        HashMap<String, Integer> hashMap = new HashMap<>();
        String answer = "";

        for (String s : participant) {
            if (!hashMap.containsKey(s)) {
                hashMap.put(s, 1);
            } else {
                hashMap.put(s, hashMap.get(s) + 1);
            }

        }

        for (String s : completion) {
            if (hashMap.containsKey(s)) {
                hashMap.put(s, hashMap.get(s) - 1);
            }
        }

        for (String s : hashMap.keySet()) {
            if (hashMap.get(s) > 0) {
                answer = s;
                break;
            }
        }

        return answer;
    }

    @Test
    public void test() {
        Assertions.assertEquals(solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"}), "leo");
        Assertions.assertEquals(solution(new String[]{"marina", "josipa", "nikola", "vinko", "filipa"}, new String[]{"josipa", "filipa", "marina", "nikola"}), "vinko");
    }
}
