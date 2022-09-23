package programmers.level1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 신고 결과 받기
 */
public class level1_14 {

    // id_list = 2~1000 , report =  1~200,000 , k = 1~200
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        List<Report> reports = Arrays.stream(report).distinct().map(s -> {
            String[] split = s.split(" ");
            return new Report(split[0], split[1]);
        }).collect(Collectors.toList());

        Map<String, Integer> reported = new HashMap<>();

        for (Report reporter : reports) {
            reported.put(reporter.to, reported.getOrDefault(reporter.to, 0) + 1);
        }



        for (int i = 0; i < id_list.length; i++) {
            String reporter = id_list[i];
            long count = reports.stream().filter(report1 -> {
                if (report1.reporter.equals(reporter) && reported.get(report1.to) >= k) {
                    return true;
                }
                return false;
            }).count();
            answer[i] = (int) count;
        }

        return answer;
    }


    private class Report {
        String reporter, to;

        public Report(String reporter, String to) {
            this.reporter = reporter;
            this.to = to;
        }
    }


    @Test
    void test() {
        Assertions.assertArrayEquals(solution(new String[]{"muzi", "frodo", "apeach", "neo"}, new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"}
                ,2), new int[]{2,1,1,0});
    }
}
