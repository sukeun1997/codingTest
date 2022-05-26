package programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 캐시
 */
public class level2_39 {

    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        for (int i = 0; i < cities.length; i++) {
            cities[i] = cities[i].toLowerCase();
        }

        Deque<String> deque = new ArrayDeque<>(cacheSize);

        for (String city : cities) {

            if (cacheSize == 0) {
                answer += 5;
                continue;
            }

            if (deque.isEmpty()) {
                deque.add(city);
                answer += 5;
                continue;
            } else {
                if (deque.contains(city)) {
                    deque.remove(city);
                    deque.add(city);
                    answer += 1;
                } else {
                    if (deque.size() == cacheSize) {
                        deque.pop();
                    }
                    deque.add(city);
                    answer += 5;

                }

            }
        }

        return answer;
    }


    @Test
    void test() {
        assertEquals(solution(3,new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}),50);
        assertEquals(solution(3,new String[]{"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"}),21);
        assertEquals(solution(2,new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}),60);
        assertEquals(solution(5,new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}),52);
        assertEquals(solution(2,new String[]{"Jeju", "Pangyo", "NewYork", "newyork"}),16);
        assertEquals(solution(2,new String[]{"Jeju", "Pangyo", "Jeju", "Pangyo"}),12);
        assertEquals(solution(0,new String[]{"Jeju", "Jeju"}),10);
        assertEquals(solution(0, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA"}), 25);
    }
}
