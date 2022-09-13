package programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;

public class level1_12 {


    // id_list 2~1000
    // report 1~200,000
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        LinkedHashMap<String, Integer> number = new LinkedHashMap<>();

        for (int i = 0; i < id_list.length; i++) {
            number.put(id_list[i], i);
        }

        boolean[][] visited = new boolean[id_list.length][id_list.length];

        int[] count = new int[id_list.length];

        for (String s : report) {
            String[] blame = s.split(" ");
            Integer reportId = number.get(blame[0]);
            Integer reportedId = number.get(blame[1]);

            if (!visited[reportId][reportedId]) {
                visited[reportId][reportedId] = true;
                count[reportedId]++;
            }
        }

        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                if (count[j] >= k && visited[i][j]) {
                    answer[i]++;
                }
            }
        }


        return answer;
    }

    @Test
    void test() {
        Assertions.assertArrayEquals(solution(new String[]{"muzi", "frodo", "apeach", "neo"}, new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"}
        ,2), new int[]{2,1,1,0});
    }
}
