package programmers;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 주차 요금
 */
public class level2_56 {

    //Map <차량번호,입차시간>
    //Map <차량번호,총시간>
    public int[] solution(int[] fees, String[] records) {

        HashMap<String, Integer> startTime = new HashMap<>();
        TreeMap<String, Integer> totalTime = new TreeMap<>();


        for (int i = 0; i < records.length; i++) {
            String[] record = records[i].split(" ");

            int time = Integer.parseInt(record[0].substring(0, 2)) * 60 + Integer.parseInt(record[0].substring(3, 5));

            String carNum = record[1];
            String status = record[2];

            if (status.equals("IN")) {
                startTime.put(carNum, time);
            } else {
                time = time - startTime.get(carNum);
                totalTime.put(carNum, totalTime.getOrDefault(carNum, 0) + time);
                startTime.remove(carNum);
            }
        }

        for (Map.Entry<String, Integer> entry : startTime.entrySet()) {
            int endTime = 23 * 60 + 59;
            totalTime.put(entry.getKey(), totalTime.getOrDefault(entry.getKey(), 0) + endTime - entry.getValue());
        }

        int[] answer = new int[totalTime.size()];
        int size = 0;

        for (Map.Entry<String, Integer> totalPark : totalTime.entrySet()) {
            int totalFee = fees[1];
            int remainTime = totalPark.getValue() - fees[0];

            if (remainTime > 0) {
                double time = Math.ceil((double) remainTime / fees[2]);
                totalFee += time * fees[3];
            }

            answer[size++] = totalFee;
        }


        return answer;
    }

    @Test
    void test() {
        Assertions.assertArrayEquals(solution(new int[]{180, 5000, 10, 600}, new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"}),
                new int[]{14600, 34400, 5000});

        Assertions.assertArrayEquals(solution(new int[]{120, 0, 60, 591}, new String[]{"16:00 3961 IN", "16:00 0202 IN", "18:00 3961 OUT", "18:00 0202 OUT", "23:58 3961 IN"})
                , new int[]{0, 591});


    }
}
