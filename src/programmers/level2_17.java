package programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class level2_17 {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        int answer = 0;
        for (String[] clothe : clothes) {
            if (hashMap.containsKey(clothe[1])) {
                hashMap.put(clothe[1], hashMap.get(clothe[1])+1);
            } else {
                hashMap.put(clothe[1], 1);
            }
        }
        answer = 1;
        for (Integer value : hashMap.values()) {
            answer *= (value + 1);
        }
        return answer-1;
    }

    @Test
    public void test() {
        Assertions.assertEquals(solution(new String[][]{{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}}), 5);
    }
}
